<?php
interface Animal {
  public function makeSound();
}

class Cat implements Animal {
  public function makeSound() {
    echo "<br/>Meow";
  }
}
class Dog implements Animal {
  public function makeSound() {
    echo "<br/>AuAuAU";
  }
}

class Teste{
    public function makeSound() {
        echo "<br/>teste";
      }
}

$cat = new Cat();
$dog = new Dog();
$teste = new Teste();

falar($cat);
falar($dog);
falar($teste);


function falar($animal){
    $animal->makeSound();
}
?>