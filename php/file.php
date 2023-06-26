<?php
echo readfile("nomes.txt");
echo "<br/>";
echo "<br/>";
echo "<br/>";

$myfile = fopen("nomes.txt", "r") or die("Unable to open file!");
// echo fread($myfile,filesize("nomes.txt"));

//unica linha
while(!feof($myfile)) {
    echo fgets($myfile) . "<br>";
}
echo "<br/>";
echo "<br/>";
echo "<br/>";
fclose($myfile);
?>