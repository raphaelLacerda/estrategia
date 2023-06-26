<?php
function divide($dividend, $divisor) {
    if($divisor == 0) {
      throw new Exception("Division by zero");
    }
    return $dividend / $divisor;
  }
  
  try{
    echo divide(5, 0);
  }catch(Exception $e){
    echo $e->getMessage();
    echo $e->getCode();
    echo $e->getTraceAsString();
    echo "deu errro!";
  }finally{
    echo "fim";
  }
  
  

?>