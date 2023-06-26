package main

import (
	"fmt"
)

func hello() {
	fmt.Println("Olá nossa GoRoutine")
}
func main() {
	go hello()
	fmt.Println("Executando o programa!")
	// Isso aconteceu por que o retorno de uma nova goroutine não é aguardado pela execução do programa
	// time.Sleep(5 * time.Second)
}
