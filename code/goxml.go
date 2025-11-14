// SPDX-License-Identifier: 0BSD
package main

import (
	"encoding/xml"
	"fmt"
	"os"
)

func main() {
	f, _ := os.Open(os.Args[1])

	dec := xml.NewDecoder(f)
	dec.Strict = false

	for tok, _ := dec.Token(); tok != nil; tok, _ = dec.Token() {
		// This does not output XML, but it's good enough
		// to test parser behavior
		fmt.Printf("%s", tok)
	}
}
