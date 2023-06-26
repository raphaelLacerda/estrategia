<?php
$age = array("Peter"=>35, "Ben"=>37, "Joe"=>43);

$json_string = json_encode($age);

echo var_dump ($json_string);


$json_object = json_decode($json_string, true);
//The json_decode() function has a second parameter, and when set to true, JSON objects are decoded into associative arrays.

echo $json_object["Peter"];

?>