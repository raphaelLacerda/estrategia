<?php
$fruits = array (
    "fruits"  => array("a" => "orange", "b" => "banana", "c" => "apple"),
    "numbers" => array(1, 2, 3),
    "holes"   => array("first", 5 => "second", "third")
);

// print var_dump($fruits);

array_push($fruits["numbers"],4);
print $fruits["numbers"][3]."</br>";
print $fruits["fruits"]["b"]."</br>";
print_r ($fruits["holes"]);

list($a,$b,$c)=$fruits["numbers"];

echo "variavel $a foi definida </br>";
echo "variavel $b foi definida </br>";
echo "variavel $c foi definida </br>";

echo "</br>";
echo "</br>";
echo "</br>";

echo ($fruits["holes"][0]);
echo "</br>";
echo ($fruits["holes"][5]);
echo "</br>";
echo ($fruits["holes"][6]);

echo "</br>";
echo "</br>";
echo "</br>";

$cars = array("nome"=>"joao", "cpf"=>"123");

print(var_dump(3.1));

// for($x = 0; $x < $arrlength; $x++) {
//   echo $cars[$x];
//   echo "<br>";
// }
// echo "<br>SLICE";

// print_r (array_slice($cars,1,3));

// foreach (range(0, 12) as $number) {
//     echo $number;
// }


// function cube($n)
// {
//     return ($n * $n);
// }

// echo "<br>";
// echo "<br>";
// $a = [1, 2, 3, 4, 5];
// $b = array_map('cube', $a);
// print_r($b);


// echo "<br>";
// echo "<br>";

// $c = array_map(function($n){
//     return $n*$n;
// }, $a);
// print_r($c);



?>