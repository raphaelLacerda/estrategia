package main

import (
	"fmt"
)

func main() {
	idade := 10
	var idade2 = idade
	fmt.Printf("O valor de idade é %d\n", idade)
	fmt.Printf("O endereço de idade é %x\n", &idade)

	idade2 = 20
	fmt.Printf("O valor de idade2 é %d\n", idade2)
	fmt.Printf("O endereço de idade2 é %x\n", &idade2)

	var idade3 *int
	idade3 = &idade
	fmt.Printf("O valor de idade3 é %d\n", *idade3)
	fmt.Printf("O endereço de idade3 é %x\n", idade3)

	*idade3 = 30
	fmt.Println("--------------------------")
	fmt.Println("--------------------------")
	fmt.Println("--------------------------")
	fmt.Printf("O valor de idade é %d\n", idade)
	fmt.Printf("O endereço de idade é %x\n", &idade)
	fmt.Printf("O valor de idade3 é %d\n", *idade3)
	fmt.Printf("O endereço de idade3 é %x\n", idade3)

}
