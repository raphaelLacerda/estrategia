package main

import (
	"fmt"
)

func main() {
	var contas map[int]string
	contas = make(map[int]string)
	contas[123] = "rafa"
	contas[456] = "matheus"
	contas[789] = "gui"
	fmt.Println(contas)
	fmt.Println(contas[0])

	for k, v := range contas {
		fmt.Println("key", k, "value", v)
	}
	fmt.Println("--------------")
	fmt.Println("--------------")
	cliente, ok := contas[123]
	fmt.Println(cliente)
	fmt.Println(ok)
	cliente2, nao_ok := contas[1011]
	fmt.Println(cliente2)
	fmt.Println(nao_ok)

	delete(contas, 789)

	for k, v := range contas {
		fmt.Println("key", k, "value", v)
	}

}
