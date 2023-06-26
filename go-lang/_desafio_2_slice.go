package main

import (
	"fmt"
	"sort"
	"strconv"
	"strings"
)

func main() {

	numeros := make([]int, 0, 3)
	for {
		fmt.Println("---------------")
		fmt.Print("Enter a value: ")
		var x string
		fmt.Scanln(&x)
		if strings.ToLower(x) == "x" {
			break
		}
		value, _ := strconv.Atoi(x)
		numeros = append(numeros, value)
		sort.Ints(numeros)
		fmt.Println("sorted order ", numeros)
	}

}
