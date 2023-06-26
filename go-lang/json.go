package main

import (
	"encoding/json"
	"fmt"
)

// se colocar com letra minuscula nao rola
type Pessoa struct {
	Name string
	Age  int
}

func main() {

	bolB, _ := json.Marshal(true)
	fmt.Println(bolB)
	fmt.Println(string(bolB))

	p := Pessoa{Age: 10, Name: "rafa"}
	p_as_json, _ := json.Marshal(&p)
	fmt.Println(p_as_json)
	fmt.Println(string(p_as_json))

	var p2 Pessoa
	json.Unmarshal(p_as_json, &p2)
	fmt.Println(p2.Age)
	fmt.Println(p2.Name)

}
