<html>
<body>

<form action="form-resposta.php" method="post">
Name: <input type="text" name="name"><br>
E-mail: <input type="text" name="email"><br>
Salario: <input type="number" name="salario"><br>
<input type="submit">
</form>

<?php
$servername = "mysql";
$username = "root";
$password = "root";
$database = "php";

$conn = new mysqli($servername, $username, $password, $database);
$sql = "SELECT * FROM PESSOAS";
$result = $conn->query($sql);
echo "Quantidade de registros encontrados $result->num_rows";
?>

<h2>Listagem de Pessoas</h2>
<table>
    <?php
    if ($result->num_rows > 0) {
        // output data of each row
        while($row = $result->fetch_assoc()){
            ?>
            <tr>
                <td><?php echo $row['nome']; ?></td>
                <td><?php echo $row['email']; ?></td>
                <td><?php echo $row['salario']; ?></td>
            </tr>
            <?php
        }
    }else{
        echo "Nenhum registro encontrado";
    }
    ?>    
</table>

<h2>Pessoas que ganham mais do que 5000</h2>
<table>
    <?php
    $sql = "SELECT * FROM PESSOAS WHERE salario > ?";
    $stmt = $conn->prepare($sql);
    $salario = 11000;
    $stmt->bind_param("d", $salario);
    $stmt->execute();
    $result = $stmt->get_result();
    
    echo "Quantidade de registros encontrados $result->num_rows";
    
    if ($result->num_rows > 0) {
        // output data of each row
        while($row = $result->fetch_assoc()){
            ?>
            <tr>
                <td><?php echo $row['nome']; ?></td>
                <td><?php echo $row['email']; ?></td>
                <td><?php echo $row['salario']; ?></td>
            </tr>
            <?php
        }
    }else{
        echo "Nenhum registro encontrado";
    }
    $conn->close();
    ?>    
</table>

</body>
</html>