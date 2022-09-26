package main

import (
	"github.com/temoto/robotstxt"
	"net/http"
)

func main1() {
	resp, err := http.Get("https://despegar.com/robots.txt")
	if err != nil {
		panic(err)
	}
	data, err := robotstxt.FromResponse(resp)
	if err != nil {
		panic(err)
	}
	grp := data.FindGroup("Go-http-client/1.1")
	if grp != nil {
		testUrls := []string{
			"/vuelos-baratos",
			"/hotels",
			"/Cancun2005",
			"/promo",
			"/Cars/",
		}
		for _, url := range testUrls {
			print("checking " + url + " ...")
			if grp.Test(url) == true {
				println("OK")
			} else {
				println("X")
			}
		}
	}
}
