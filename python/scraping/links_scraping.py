import colorama
import requests
import time
from console_progressbar import ProgressBar
from urllib.parse import urlparse, urljoin
from bs4 import BeautifulSoup

colorama.init()
GREEN = colorama.Fore.GREEN
BLUE = colorama.Fore.BLUE
RESET = colorama.Fore.RESET

internal_urls = set()
external_urls = set()
urls_visited = 0
index = 0

def is_valid(url):
  parsed = urlparse(url)
  return bool(parsed.netloc) and bool(parsed.scheme)

def get_all_links_from_webstie(url):
  urls = set()
  domain_name = urlparse(url).netloc
  soup = BeautifulSoup(requests.get(url).content, "html.parser")

  for tag in soup.find_all("a"):
    href = tag.attrs.get("href")
    if href == "" or href is None:
      continue

    href = urljoin(url, href)
    parsed_href = urlparse(href)
    href = f"{parsed_href.scheme}://{parsed_href.netloc}{parsed_href.path}"

    if not is_valid(href):
      continue

    if href in internal_urls:
      continue

    if domain_name not in href:
      if href not in external_urls:
        external_urls.add(href)
      continue
    internal_urls.add(href)
    urls.add(href)
  return urls

def crawl_links(url, pb, max_urls=500):
  global urls_visited
  urls_visited += 1
  links = get_all_links_from_webstie(url)
  for link in links:
    if urls_visited > max_urls:
      break
    if url in link:
      pb.print_progress_bar(urls_visited)
      crawl_links(link, pb, max_urls=max_urls)

if __name__ == "__main__":
  pb = ProgressBar(total=20,prefix='Here', suffix='Now', decimals=0, length=50, fill='X', zfill='-')
  crawl_links("https://arthurolg.com", pb)

  print("\n\r")
  for external in external_urls:
    print(f"{BLUE}[!] External link: {external}{RESET}")
  for internal in internal_urls:
    print(f"{GREEN}[!] Internal link: {internal}{RESET}")

  print("[+] Total External links:", len(external_urls))
  print("[+] Total Internal links:", len(internal_urls))
  print("[+] Total:", len(external_urls) + len(internal_urls))
