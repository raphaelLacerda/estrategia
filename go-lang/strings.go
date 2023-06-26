package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	nome := "Raphael Henrique"
	nome = nome + " Lacerda Pinho"
	fmt.Println(len(nome))

	strings.ToUpper(nome)
	fmt.Println(nome)
	fmt.Println(len(nome))

	nomes := strings.Split(nome, " ")
	fmt.Println(nomes)
	fmt.Println(nomes[0])
	fmt.Println(strings.Join(nomes, "-"))

	idade := 10
	fmt.Println("Nome ", nome, " Idade: ", idade)

	//conversao de string para int
	v := "10"
	x,err := strconv.Atoi(v)
	fmt.Println(x + 14)
	fmt.Println(err)
	
	str1 := "Geeks"
	str4 := "Geeks"
	result4 := str1 == str4
	fmt.Println("Result 4: ", result4)
}
