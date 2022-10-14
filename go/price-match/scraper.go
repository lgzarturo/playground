package main

import (
    "fmt"
    "github.com/gocolly/colly"
    "log"
)

func main() {
    c := colly.NewCollector(
        colly.AllowedDomains("despegar.com.mx", "www.despegar.com.mx"),
    )

    c.OnHTML("div.main-info", func(h *colly.HTMLElement) {
        fmt.Println(h.ChildText("h1"))
    })

    c.OnHTML("div.detail-container", func(h *colly.HTMLElement) {
        fmt.Println(h.Text)
    })

    c.OnRequest(func(r *colly.Request) {
        fmt.Println(r.URL.String())
    })

    c.Visit("https://www.despegar.com.mx/accommodations/detail/265946/2022-06-04/2022-06-05/2")
    log.Println(c)
}
