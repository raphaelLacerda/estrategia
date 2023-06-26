<?php

    $nome = "Raphael Lacerda";
    echo $nome;
    echo "</br>";
    echo "</br>";
    echo "</br>";
    $idade = 10;
    $idade+=1;
    echo $idade;
    $a= $b = $c = 30.5;
    echo "</br>";
    echo $a;
    echo "</br>";
    echo "</br>";
    echo "</br>";
    echo "</br>";
    print var_dump($nome);
    print var_dump($idade);
    print var_dump($a);

    echo "</br>";
    echo "</br>";
    echo "</br>";
    
    print "Ola ". $nome ." sua idade é ". $idade;
    echo "</br>";
    print "Ola $nome sua idade é $idade";
    
    echo "</br>";
    $idade_s = "20";
    $d = $idade + $idade_s;
    print $d;
    
    
    echo "</br>";
    define("GREETING", "Welcome to W3Schools.com!");
    echo GREETING;


    $a = 3;
    $b = "2";

    echo $a|$b;
    echo $a&$b;
?>