<?php
namespace Main;

class Calculadora {
    function calcular ($a,$b){
        return $a-$b;
    }    
}

$c = new Calculadora();
$r = $c->calcular(10,4);
echo ($r);

?>