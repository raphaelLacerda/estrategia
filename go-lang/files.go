package main

import (
	"fmt"
	"io/ioutil"
	"os"
)

func main() {

	//nao precisa fechar e abrir
	data, _ := ioutil.ReadFile("teste.txt")
	fmt.Println(data)
	fmt.Println(string(data))

	//third is the FileMode - permissions
	//sobrescreve
	// newdata := []byte("bem vindo a minha aula")
	// _ = ioutil.WriteFile("teste.txt", newdata, 0777)

	//appending
	f, err := os.OpenFile("teste.txt", os.O_APPEND|os.O_WRONLY, 0600)
	if err != nil {
		fmt.Println(err)
		return
	}
	f.WriteString("\npai do guilherme\n")
	f.Close()

}
