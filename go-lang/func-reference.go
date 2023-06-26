package main

import "fmt"

func main() {

	x := 2
	r := fooByValue(x)
	fmt.Println("x", x)
	fmt.Println("r", r)

	x = 2
	r = fooByReference(&x)
	fmt.Println("x", x)
	fmt.Println("r", r)

	impressao(10, 20, 30, 40, 50)
}

func fooByValue(a int) int {
	a = a + 1
	return a
}

func fooByReference(a *int) int {
	*a = *a + 1
	return *a
}

func impressao(vals ...int) {
	for _, v := range vals {
		fmt.Println(v)
	}
}
