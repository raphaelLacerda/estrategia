package main

import "fmt"

/* global variable declaration */
var g int

func main() {
	g = 1
	fmt.Println("g = ", g)
	sum, sub := calculate(10)
	fmt.Println("soma = ", sum)
	fmt.Println("sub = ", sub)
	fmt.Println("g = ", g)

	//funcao as values
	x := compute(calculate)
	fmt.Println("x = ", x)

	//closures
	soma := adder()
	soma(10)
	soma(20)
	total := soma(30)

	fmt.Println("total = ", total)

}

func calculate(number int) (x, y int) {
	x = number + 10
	y = number - 5
	g = 50
	return
}

//funcao as values
func compute(fn func(int) (a, b int)) int {
	a, b := fn(30)
	return a + b
}

func adder() func(int) int {
	sum := 0
	return func(x int) int {
		sum += x
		return sum
	}
}
