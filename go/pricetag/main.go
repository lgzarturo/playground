package main

import (
	"log"
	"net/http"
	"os"
)

func main2() {
	var r *http.Response
	var err error

	r, err = http.Get("https://revenatium.com")
	if err != nil {
		panic(err)
	}

	if r.StatusCode == 200 {
		var webPageContent []byte
		var bodyLength int = 1270
		webPageContent = make([]byte, bodyLength)
		r.Body.Read(webPageContent)
		var out *os.File
		out, err = os.OpenFile("index.html", os.O_CREATE|os.O_WRONLY, 0664)
		if err != nil {
			panic(err)
		}
		out.Write(webPageContent)
		out.Close()
	} else {
		log.Fatal("Failed to retrieve the webpage. Received status code", r.Status)
	}
}
