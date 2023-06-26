<?php
   class Person{
      private $name;
      private static $total=0;

      function __construct(){
         echo "constructor";
         Person::$total++;
      }

      function __destruct(){
         echo "</br>destructor $this->name";
      }

      function _call($name, $arguments){
         echo "</br>default $name com argumentos $arguments";
      }

      public function setName($name){
         $this->name = $name;
      }
      public function getName(){
         return $this->name;
      }

      public static function getTotal(){
         return Person::$total;
      }
   }
   $person = new Person();
   $person->setName("Raphael");
   //não existe esse método
   echo $person->getIdade();

   // $total = Person::getTotal();
   // echo "<br/>Total de pessoas $total";
?>