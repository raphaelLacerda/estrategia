<?php
$servername = "mysql";
$username = "root";
$password = "root";
$database = "php";


try {
  $conn = new PDO("mysql:host=$servername;dbname=$database", $username, $password);
  // set the PDO error mode to exception
  $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  echo "Connected successfully";

  // sql to create table
  $sql = "CREATE TABLE if not exists TESTE (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL
    )";
  
    // use exec() because no results are returned
    $conn->exec($sql);
    echo "Table Teste created successfully";

    $sql = "INSERT INTO TESTE (nome) VALUES ('Rafa')";
    // use exec() because no results are returned
    $conn->exec($sql);

    $stmt = $conn->prepare("INSERT INTO TESTE (nome) VALUES (:nome)");
    $stmt->bindValue(':nome', "gui");
    $stmt->execute();

    echo "New record created successfully. Last inserted ID is: " . $conn->lastInsertId();

    $stmt = $conn->prepare("SELECT * from TESTE;");
    $stmt->execute();
    $result = $stmt->setFetchMode(PDO::FETCH_ASSOC);
  
    foreach($stmt->fetchAll() as $k=>$v) {

      $nome = $v['nome'];
      echo "Registro: $k - $nome";
    }

    echo '<br/><br/><br/><br/> Nomes que possuem ra';

    $stmt = $conn->prepare("SELECT * from TESTE where nome like ?");
    $nome='Ra';
    $params = array("%$nome%");
    $stmt->execute($params);
    $result = $stmt->setFetchMode(PDO::FETCH_ASSOC);
  
    foreach($stmt->fetchAll() as $k=>$v) {

      $nome = $v['nome'];
      echo "Registro: $k - $nome";
    }
} catch(PDOException $e) {
  echo "Connection failed: " . $e->getMessage();
}
?>