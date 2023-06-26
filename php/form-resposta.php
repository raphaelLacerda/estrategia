<html>
<body>

Welcome <?php echo $_POST["name"]; ?><br>
Your email address is: <?php echo $_POST["email"]; ?>
Your salary is: <?php echo $_POST["salario"]; ?>

<?php
$servername = "mysql";
$username = "root";
$password = "root";
$database = "php";

$conn = new mysqli($servername, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

// prepare and bind
$stmt = $conn->prepare("INSERT INTO PESSOAS (nome, email, salario) VALUES (?, ?, ?)");
$stmt->bind_param("ssd", $_POST["name"], $_POST["email"], $_POST["salario"]);
$stmt->execute();
echo "<br/> Registro salvo com sucesso";
/*
This function binds the parameters to the SQL query and tells the database what the parameters are. The "sss" argument lists the types of data that the parameters are. The s character tells mysql that the parameter is a string.

The argument may be one of four types:

i - integer
d - double
s - string
b - BLOB
*/
?>



</body>
</html>