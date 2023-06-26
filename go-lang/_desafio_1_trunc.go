package main

import (
	"fmt"
)

func main() {
	fmt.Println("Enter a floating point: ")
	var x float64
    fmt.Scanln(&x)
	fmt.Println("Your number truncated ", int64(x))
}
