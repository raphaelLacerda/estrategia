<?php
require "../vendor/autoload.php";
use Animal\Tunica;
use Animal\Pepe;
use Carro\Celta;

use Main\Calculadora;

$c = new Calculadora();
echo $c->calcular(10,10);

$t = new Tunica();
$t->sayOla();
$t = new Pepe();
$t->sayOla();
$t = new Celta();
$t->acelerar();
?>