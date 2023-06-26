<?php
// require __DIR__ . "/../src/Calculadora.php";
use PHPUnit\Framework\TestCase;
use Main\Calculadora;

final class CalculadoraTest extends TestCase
{

    public function testSomandoNumeros(): void
    {
        $c = new Calculadora();
        $resultado = $c->calcular(10,4);
        $this->assertEquals('14',$resultado);
    }
}

?>