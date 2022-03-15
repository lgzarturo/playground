#!/usr/bin/env python
#_*_ coding:utf-8 _*_

import argparse
import mechanize
import requests

from os import path

parser = argparse.ArgumentParser(description='Headers:')
parser.add_argument('-u', '--url', help='url', required=False)
parser.add_argument('-f', '--file', help='file', required=False)
parser.add_argument('-s', '--search', help='search', required=False)

parser = parser.parse_args()
dict_headers = {}
web = "https://curso--python-0-prueba-pentest.000webhostapp.com/index.php"
browser_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"

def main():
    if parser.search:
        bus = mechanize.Browser()
        bus.set_handle_robots(False)
        bus.set_handle_equiv(False)
        bus.addheader = [('User-agent', browser_agent)]
        bus.open("https://www.google.com")
        for n in bus.forms():
            print(n)
    if parser.file:
        if path.exists(parser.file):
            file = open(parser.file, 'rb')
            headers = {
                'User-Agent': browser_agent,
            }
            response = requests.post(url=web, files={'uploaded_file': file}, headers=headers)
            if parser.file in response.text:
                print("[+] File uploaded successfully")
            else:
                print("[-] File not uploaded")
    if parser.url:
        url = parser.url
        try:
            headers = requests.get(url).headers
            dict_headers = dict(headers)
            for key in headers:
                print(key + ': ' + headers[key])
        except Exception as e:
            print(e)


if __name__ == '__main__':
    try:
        main()
        print("*" * 50)
        print(dict_headers)
    except KeyBoardInterrupt:
        print("\n[-] User aborted the scan")
