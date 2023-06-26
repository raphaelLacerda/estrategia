<?php
  
// trait Geeks
trait Geeks {
  public function sayhello() {
     echo "Hello";
   }
 }
  
// trait forGeeks
trait forGeeks {
  public function sayfor() {
     echo " Geeks";
   }
 }
  
class Sample {
  use Geeks;
  use forGeeks;
  public function geeksforgeeks() {
      echo "\nGeeksforGeeks";
   } 
}
  
$test = new Sample();
$test->sayhello();
$test->sayfor();
$test->geeksforgeeks();
?>