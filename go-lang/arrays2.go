package main

import (
	"fmt"
)

func main() {

	n1 := []int {4, 8, 5}
	
	y := n1[0:2]

	fmt.Println(y)
	fmt.Println(n1)

	y[0]=10
	fmt.Println(y)
	fmt.Println(n1)


	s := make([]int, 0, 3)
	s = append(s, 100)
	fmt.Println(len(s), cap(s))


}
