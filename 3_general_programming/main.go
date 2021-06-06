package main

import "fmt"

func main() {
	for i := 1; i <= 100; i++ {
		if i%3 == 0 && i%5 == 0 {
			fmt.Println("Instaclustr")
		} else if i%3 == 0 {
			fmt.Println("Insta")
		} else if i%5 == 0 {
			fmt.Println("clustr")
		} else {
			fmt.Println(i)
		}
	}
}
