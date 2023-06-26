<?php //declare(strict_types=1); ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Olá Mundo</title>
</head>
<body>

    <h1>Aula de PHP</h1>
    <h2>oioi <?php echo 'Olá Mundo aula' ?></h2>
    <?php
    
    $age = array("Peter"=>35, "Ben"=>37, "Joe"=>43);
    print_r ($age);
    
    $str = json_encode($age);

    $r = json_decode($str);

    print_r ($r);





    ?>
</body>
</html>