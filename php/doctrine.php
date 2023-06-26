<?php
require __DIR__ . "/vendor/autoload.php";
use Doctrine\Common\Collections\ArrayCollection;

$collection = new ArrayCollection([1, 2, 3]);

$filteredCollection = $collection->filter(function($element) {
    return $element > 1;
}); // [2, 3]


print_r ($filteredCollection);