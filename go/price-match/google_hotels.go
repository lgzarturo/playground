package main

import (
	"fmt"
	"github.com/gocolly/colly"
	"log"
	"sync"
	"time"
)

func main() {
	start := time.Now()
	stocks := []string{
		"ChgI3tDLtsTZ0NnRARoLL2cvMXRkcV9zOXYQAQ",
	}
	parsePrices(stocks)
	fmt.Printf("Completed the process, took: %f secods\n", time.Since(start).Seconds())
}

func parsePrices(entities []string) {
	ch := make(chan string)
	var wg sync.WaitGroup
	for _, entity := range entities {
		wg.Add(1)
		go parsePrice(entity, ch, &wg)
	}

	go func() {
		wg.Wait()
		close(ch)
	}()

	for msg := range ch {
		fmt.Println(msg)
	}
}

func parsePrice(entity string, ch chan string, wg *sync.WaitGroup) {
	defer (*wg).Done()
	c := colly.NewCollector(
		colly.UserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.128 Safari/537.36"),
		colly.AllowedDomains("www.google.com", "google.com"),
		colly.MaxBodySize(0),
		colly.AllowURLRevisit(),
		colly.Async(true),
	)
	err := c.Limit(&colly.LimitRule{
		DomainGlob:  "*",
		Parallelism: 2,
		Delay:       1 * time.Second,
		RandomDelay: 1 * time.Second,
	})
	if err != nil {
		fmt.Println("Error en los limites de colly")
		return
	}
	c.OnRequest(func(r *colly.Request) {
		log.Println("Visiting: " + r.URL.String())
	})

	c.OnHTML("//div[@data-is-overview='true']", func(e *colly.HTMLElement) {
		e.ForEach("//a[@data-is-organic='false']/div", func(i int, el *colly.HTMLElement) {
			var dataSlice []string
			el.ForEach("/div", func(_ int, item *colly.HTMLElement) {
				dataSlice = append(dataSlice, item.Text)
			})
			ch <- dataSlice[0] + " price" + dataSlice[1]
		})
	})
	err = c.Visit("https://www.google.com/travel/hotels/entity/" + entity)
	if err != nil {
		fmt.Println("Error al procesar la entidad " + entity)
		return
	}
	c.Wait()
}
