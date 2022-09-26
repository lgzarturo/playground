package main

import (
	"encoding/json"
	"fmt"
	"github.com/gocolly/colly"
	"github.com/gocolly/colly/debug"
	"github.com/gocolly/colly/extensions"
	"log"
	"net/http"
	"os"
)

type Hotel struct {
	Title    string
	Price    string
	Currency string
	Room     string
}

func main() {
	c := colly.NewCollector(
		colly.UserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1"),
		colly.AllowURLRevisit(),
		colly.AllowedDomains("despegar.com.mx", "www.despegar.com.mx"),
		colly.CacheDir("./despegar_cache"),
		colly.Async(true),
		colly.Debugger(&debug.LogDebugger{}),
	)

	c.WithTransport(&http.Transport{
		DisableKeepAlives: true,
	})

	extensions.RandomUserAgent(c)
	extensions.Referer(c)
	c.Limit(&colly.LimitRule{DomainGlob: "*", Parallelism: 4})

	hotels := make([]Hotel, 0, 200)

	c.OnHTML(`div.main-info`, func(h *colly.HTMLElement) {
		hotelName := h.ChildText("h1")
		if hotelName == "" {
			hotelName = "No se puede obtener el nombre del hotel"
		}
		log.Println("HOTEL: ", hotelName)
	})

	c.OnHTML(`.body`, func(e *colly.HTMLElement) {
		e.ForEach(".//aloha-roompack-container", func(i int, element *colly.HTMLElement) {
			hotel := Hotel{
				Title:    "All Ritmo Cancún",
				Price:    element.ChildText(".main-value"),
				Currency: element.ChildText(".currency"),
				Room:     element.ChildText(".room-name"),
			}
			hotels = append(hotels, hotel)
		})
	})

	c.OnRequest(func(r *colly.Request) {
		log.Println("visiting", r.URL.String())
	})

	c.OnScraped(func(r *colly.Response) {
		fmt.Println("Finished", r.Request.URL)
	})

	c.OnResponse(func(r *colly.Response) {
		fmt.Println("Visited", r.Request.URL)
		log.Println(r.Request.URL, "\t", r.StatusCode)
	})

	c.OnError(func(r *colly.Response, err error) {
		log.Println(r.Request.URL, "\t", r.StatusCode, "\nError:", err)
	})

	c.Visit("https://www.despegar.com.mx/accommodations/detail/265946/2022-06-04/2022-06-05/2")

	enc := json.NewEncoder(os.Stdout)
	enc.SetIndent("", "  ")
	enc.Encode(hotels)
	log.Println(c)
}
