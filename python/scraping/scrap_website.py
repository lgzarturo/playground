from bs4 import BeautifulSoup
from urllib.request import Request, urlopen
from urllib.parse import urlparse, urljoin
import re
import html2text

internal_urls = set()
urls_visited = 0


def is_valid(url):
  parsed = urlparse(url)
  return bool(parsed.netloc) and bool(parsed.scheme) and ("https" in url or "http" in url)


def get_all_links_from_website(url):
  print(f"Enlace: {url}")
  req = Request(url)
  html_page = urlopen(req)
  soup = BeautifulSoup(html_page, "html.parser")

  for tag in soup.find_all("a"):
    href = tag.attrs.get("href")
    if ".php" not in href:
      continue

    href = urljoin(url, href)
    parsed_href = urlparse(href)
    href = f"{parsed_href.scheme}://{parsed_href.netloc}{parsed_href.path}"

    if not is_valid(href):
      continue

    if href in internal_urls:
      continue

    internal_urls.add(href)
    internal_urls.update(get_all_links_from_website(href))

  return internal_urls


def get_text_from_page(url):
  req = Request(url)
  html_page = urlopen(req)
  soup = BeautifulSoup(html_page, "html.parser")
  h = html2text.HTML2Text()
  h.ignore_links = True
  content = "> BEGIN " + url + "\r"
  for line in h.handle(str(soup)):
    content += line
  content += "\r> END " + url + "\r\r\r"
  return content


def crawl_content_from_website(url, max_urls=500):
  global urls_visited
  content = ""
  urls_visited += 1
  links = get_all_links_from_website(url)

  for link in links:
    if urls_visited > max_urls:
      break
    content += get_text_from_page(link)
  return content


def create_file(content):
  f = open("html_text.md", "w")
  f.write(content)
  f.close()


if __name__ == "__main__":
  content = crawl_content_from_website("https://arthurolg.com")
  create_file(content)
