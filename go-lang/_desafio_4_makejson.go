package main

import (
	"encoding/json"
	"fmt"
)

func main() {

	fmt.Println("Enter your first name: ")
	var firstName string
	fmt.Scanln(&firstName)
	fmt.Println("Enter your address: ")
	var address string
	fmt.Scanln(&address)

	var person map[string]string
	person = make(map[string]string)

	person["firstname"] = firstName
	person["address"] = address

	personAsJson,_ := json.Marshal(person)

	fmt.Println(string(personAsJson))

}
