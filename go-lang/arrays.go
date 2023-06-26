package main

import (
	"fmt"
)

func main() {
	//declares a variable a as an array of ten integers.
	var numeros [10]int
	// numeros := make([]int, 10)

	//b := make([]int, 0, 5) // len(b)=0, cap(b)=5
	//a := make([]int, 5)  // len(a)=5

	//first argument to append must be a slice; have numeros (variable of type [10]int)
	// append(numeros, 24.24)

	//ao declarar um slice, nao passa a quantidade de elementos
	var numeros2 = []float32{1000.0, 2.0, 3.4, 7.0, 50.0}
	fmt.Println(numeros)
	fmt.Println(numeros2)
	numeros2 = append(numeros2, 24.24)
	fmt.Println(numeros2)

	for i := 0; i < len(numeros); i++ {
		numeros[i] = i + 100 /* set element at location i to i + 100 */
	}

	fmt.Println(numeros)
	fmt.Println(numeros[1:4])
	fmt.Println(len(numeros[1:4]))
	fmt.Println(cap(numeros[1:4]))
	fmt.Println(numeros[2:5])
	fmt.Println(len(numeros[2:5]))
	fmt.Println(cap(numeros[2:5]))

	for i, v := range numeros {
		fmt.Println("Indice ", i, " Numero: ", v)
	}

	//modificar os slices modificam o array

	names := [4]string{
		"John",
		"Paul",
		"George",
		"Ringo",
	}
	fmt.Println(names)

	// //slices
	// //pointer - start
	// //length - numero de elementos no slice
	// //capacity - maximo numero de elementos que ele comparta do inicio até o fim

	a := names[0:2]
	b := names[1:3]
	fmt.Println(a, b)
	fmt.Println(len(b))
	fmt.Println(cap(b))

	b[0] = "XXX"
	fmt.Println(a, b)
	fmt.Println(names)

}
