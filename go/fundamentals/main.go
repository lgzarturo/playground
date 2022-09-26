package main

import "fmt"

const (
	Sunday int = iota
	Monday
	Tuesday
	Wednesday
	Thursday
	Friday
	Saturday
)

/*
Go block comment
*/
func main() {
	// Go line comment
	fmt.Println("Hello world!")
	// Variable declaration
	var name = "arturo lopez"
	lastName := "gomez"
	var age int
	var city, country, postalCode = "Cancun", "Mèxico", 77500
	fmt.Println("Mi nombre es", name, "y", lastName, "es mi apellido, tengo", age, "años.")
	fmt.Println("Vivo en la ciudad de", city, "que esta en el paìs de", country, " y el codigo postal es", postalCode)
	// Relational operators
	var result = age > 0
	fmt.Println(result)
	// Boolean operators
	validation := 15 == 15 && 60 < 80 && (90 < 100 || 100 == 90)
	fmt.Println(validation)
	// IOTA Sequence
	fmt.Println(Sunday)
	fmt.Println(Monday)
	fmt.Println(Tuesday)
	fmt.Println(Wednesday)
	fmt.Println(Thursday)
	fmt.Println(Friday)
	fmt.Println(Saturday)
}
