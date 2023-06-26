package main

import (
	"fmt"
)

func main() {
	idade := 10
	amigo_dono := true

	if idade > 18 || amigo_dono {
		fmt.Println("pode entrar")
	} else {
		fmt.Println("Vaza!")
	}
}
