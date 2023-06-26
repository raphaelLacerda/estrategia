
<?php
$nome="raphael";
$variavel = 'Meu $nome não será impresso!\\n';
print($variavel);
print(strlen($variavel));
$variavel = "Meu $nome não será impresso!\\n";
print($variavel);

$A = 3;
$B = "2";
print(var_dump($A));
print(var_dump($B));
$c = $A * $B;
print ("valor de c $c ");
echo "</br>";
echo "</br>";
echo $A+$B;
echo "</br>";
echo $B.$A;
echo "</br>";
echo $A|$B;
echo "</br>";
echo $A&$B;

?>