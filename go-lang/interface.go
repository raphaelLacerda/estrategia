package main

import (
	"fmt"
)

type Animal interface {
	Say()
	GetDetails()
}

type Dog struct {
	breed string
}

type MacBook struct {
	ano int
}

func (d Dog) Say() {
	fmt.Println("auau, ")
}

func (d Dog) GetDetails() {
	fmt.Println("breed ", d.breed)
}

type Person struct {
	name string
	age  int
	uf   string
}

func (p Person) Say() {
	fmt.Println("Hi, ", p.name)
}

func (p Person) GetDetails() {
	fmt.Printf("Hi, %s - Idade %d - Cidade %s\n", p.name, p.age, p.uf)
}

func printAnimal(a Animal) {
	fmt.Println("----PRINTING ANIMAL------")
	a.Say()
	a.GetDetails()
}

func main() {
	person := new(Person)
	person.name ="matheus"
	person.age = 12;

	fmt.Println(person)
	person1 := Person{"raphael", 37, "df"}
	person2 := Person{age: 1, name: "gui", uf: "sp"}
	person3 := person1
	var person4 *Person

	person3.name = "paula"
	person3.age = 30
	person4 = &person1
	person4.name = "rafa alterado"

	printAnimal(person1)
	printAnimal(person2)
	printAnimal(person3)
	printAnimal(person4)

	fmt.Printf("(%v, %T)\n", person1, person1)

	var dog1 Dog
	dog1.breed = "salsicha"

	printAnimal(dog1)
	fmt.Printf("(%v, %T)\n", dog1, dog1)

	mac := MacBook{ano: 2022}
	fmt.Println(mac.ano)
	// printAnimal(mac)
}
