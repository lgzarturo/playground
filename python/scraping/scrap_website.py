import urllib.error
from urllib.parse import urlparse, urljoin
from urllib.request import Request, urlopen

import html2text
from bs4 import BeautifulSoup

internal_urls = set()
urls_visited = 0
hdr = {
    'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11',
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
    'Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.3',
    'Accept-Encoding': 'none',
    'Accept-Language': 'en-US,en;q=0.8',
    'Connection': 'keep-alive'
}


def is_valid(url):
    parsed = urlparse(url)
    return bool(parsed.netloc) and bool(parsed.scheme) and ("https" in url or "http" in url)


def get_all_links_from_website(url):
    print(f"Enlace: {url}")
    domain_name = urlparse(url).netloc
    req = Request(url, headers=hdr)
    try:
        html_page = urlopen(req)
        soup = BeautifulSoup(html_page, "html.parser")

        for tag in soup.find_all("a"):
            href = tag.attrs.get("href")
            if href == "" or href is None or "youtube" in href or "form-test" in href or "pt-br" in href:
                continue

            href = urljoin(url, href)
            parsed_href = urlparse(href)
            href = f"{parsed_href.scheme}://{parsed_href.netloc}{parsed_href.path}"

            if not is_valid(href):
                continue

            if domain_name not in href:
                continue

            if href in internal_urls:
                continue

            internal_urls.add(href)
            internal_urls.update(get_all_links_from_website(href))
    except urllib.error.HTTPError as e:
        print(f"Error: {url} {e.fp.read()}")

    return internal_urls


def get_text_from_page(url):
    req = Request(url, headers=hdr)
    try:
        html_page = urlopen(req)
        soup = BeautifulSoup(html_page, "html.parser")
        h = html2text.HTML2Text()
        h.ignore_links = True
        content_text = "> BEGIN " + url + "\r"
        for line in h.handle(str(soup)):
            content_text += line
        content_text += "\r> END " + url + "\r\r\r"
    except urllib.error.HTTPError as e:
        content_text = ""
        print(f"Error: {url} {e.fp.read()}")

    return content_text


def crawl_content_from_website(url, max_urls=500):
    global urls_visited
    content_page = ""
    urls_visited += 1
    links = get_all_links_from_website(url)

    for link in links:
        if urls_visited > max_urls:
            break
        content_page += get_text_from_page(link)
    return content_page


def create_file(content):
    f = open("html_text.md", "w")
    f.write(content)
    f.close()


if __name__ == "__main__":
    content = crawl_content_from_website("https://arthurolg.com")
    create_file(content)
