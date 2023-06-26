package main

import (
	"fmt"
	// "time"
)

func main() {
	channel := make(chan string)
	fmt.Println("main iniciando programa")
	go olaMundo(channel)
	go sayMyName(channel)
	fmt.Println("main depois de ter chamado as routines")
	//use the channel to block until it receives a send
	r := <-channel
	n := <-channel
	//a ordem varia do tempo de execucao

	fmt.Println("resposta! : ", n+r)

}

func olaMundo(channel chan string) {
	fmt.Println("Ola Mundo inicio")
	channel <- "Olá Mundo :: "
	fmt.Println("Ola Mundo FIM")
}

func sayMyName(channel chan string) {
	// time.Sleep(10 * time.Second)
	fmt.Println("Say My Name inicio")
	channel <- "say My name: Raphael"
	fmt.Println("Say My Name fim")

}
