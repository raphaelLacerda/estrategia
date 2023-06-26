<?php 
declare(strict_types=1);

function passagemPorCopia($a){
    $a = $a+10;
}

function passagerPorReferencia(&$a){
    $a = $a+20;
}

function addNumbers(int $a, int $b=30): int {
    return $a + $b;
  }


$a = 100;
passagemPorCopia($a);
echo "seu valor é $a </br>";

$b = 100;
passagerPorReferencia($b);
echo "seu valor é $b </br>";

echo addNumbers(5, "5 days");
echo "</br>";
echo addNumbers(5);
// since strict is NOT enabled "5 days" is changed to int(5), and it will return 10

?>