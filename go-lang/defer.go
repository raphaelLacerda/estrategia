package main

import (
	"fmt"
)

func hello() {
	fmt.Println("Primeiro")
}

//PILHA de defer.go
func main() {
	defer hello()
	fmt.Println("Segundo")

	fmt.Println("counting")

	for i := 0; i < 10; i++ {
		defer fmt.Println(i)
	}

	fmt.Println("done")
}
