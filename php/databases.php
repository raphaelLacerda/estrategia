<?php
$servername = "mysql";
$username = "root";
$password = "root";
$database = "php";

// Create connection
try{
    $conn = new mysqli($servername, $username, $password, $database);
    // Check connection
    if ($conn->connect_error) {
      die("Connection failed: " . $conn->connect_error);
    }
    echo "Connected successfully";
}catch(Exception $e){   
    echo $e;
}finally{
    // $conn->close();
}

// sql to create table
$sql = "CREATE TABLE if not exists PESSOAS (id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(30) NOT NULL, email VARCHAR(50), salario decimal(15,2))";

echo "<br/> Criando a tabela $sql";

if ($conn->query($sql) === TRUE) {
    echo "Table Pessoas created successfully";
} else {
    echo "Error creating table: " . $conn->error;
}

$sql = "INSERT INTO PESSOAS (nome, email, salario) VALUES ('gui', 'gui@gmail.com', 12000);";

if ($conn->query($sql) === TRUE) {
  echo "<br/><br/><br/><br/>Registro salvo com sucesso $conn->insert_id";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}


$sql = "INSERT INTO PESSOAS (nome, email, salario) VALUES ('rafa', 'rafa@gmail.com', 12000);";
$sql .= "INSERT INTO PESSOAS (nome, email, salario) VALUES ('caliman', 'caliman@gmail.com', 5000);";
$sql .= "INSERT INTO PESSOAS (nome, email, salario) VALUES ('tunica', 'tunica@gmail.com', 2322.32);";
if ($conn->multi_query($sql) === TRUE) {
    echo "<br/><br/><br/><br/>REGISTROS salvo com sucesso $conn->insert_id";
  } else {
    echo "Error: " . $sql . "<br>" . $conn->error;
  }

//procedural

// Create connection
$conn = mysqli_connect($servername, $username, $password, $database);

// Check connection
if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}
echo "Connected successfully";
$conn->close();

?>