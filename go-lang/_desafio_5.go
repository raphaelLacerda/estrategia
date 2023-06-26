package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	in := bufio.NewReader(os.Stdin)
	// x, err := in.ReadString('\n')
	// if err != nil {
	// 	return
	// }
	x, _ := in.ReadString('\n')
	x = strings.ToLower(x)
	x = strings.TrimSpace(x)
	fmt.Println(x)
	fmt.Println(strings.HasPrefix(x, "i"))
	fmt.Println(strings.HasSuffix(x, "n"))
	fmt.Println(strings.Contains(x, "a"))
	if strings.HasPrefix(x, "i") &&
		strings.HasSuffix(x, "n") &&
		strings.Contains(x, "a") {
		fmt.Println("Found")
	} else {
		fmt.Println("Not Found")
	}
}
