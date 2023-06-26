package main

import (
	"fmt"
	"io/ioutil"
	"strings"
)

type Player struct {
	Fname string
	Lname string
}

func main() {
	fmt.Println("Enter file name: ")
	var filename string
	fmt.Scanln(&filename)
	data, _ := ioutil.ReadFile(filename)
	names := strings.Split(string(data), "\n")
	players := make([]Player, 0)

	for _, name := range names {
		fname := strings.Split(name, " ")[0]
		lname := strings.Split(name, " ")[1]
		players = append(players, Player{Fname: fname, Lname: lname})
	}

	for _, v := range players {
		fmt.Println("fname: ", v.Fname, "lname: ", v.Lname)
	}

}
