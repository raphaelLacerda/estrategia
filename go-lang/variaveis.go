package main

import "fmt"

const PI = 3.14

func main() {

	nome, idade, maior := "rafa", 19, true
	fmt.Println(nome, idade, maior)
	fmt.Printf("nome is of type %T\n", nome)
	fmt.Printf("idade is of type %T\n", idade)
	fmt.Printf("maior is of type %T\n", maior)

	var a int
	a = 17
	var b float32 = 32.2

	// b = float32(a)
	a = int(b)

	fmt.Println(a)
	fmt.Println(b)

	fmt.Println(b * PI)

	//conversoes

	var x int32 = 1
	var y int16 = 2

	//x=y
	// cannot use y (variable of type int16) as type int32 in assignment

	x = int32(y)

	fmt.Println("x ", x)
	fmt.Println("y ", y)
}
