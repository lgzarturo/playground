from bs4 import BeautifulSoup as bs
import pandas as pd
import time
import requests
import random

pd.set_option('display.max_colwidth', 500)


def main():
	"""Obtener el tipo de cambio del Diario Oficial de la Federación"""
	url = "https://www.dof.gob.mx/indicadores_detalle.php"
	code = 158
	date = "29%2F06%2F2020"
	page = requests.get(f"{url}?cod_tipo_indicador={code}&dfecha={date}&hfecha={date}")
	soup = bs(page.content.decode('utf-8'), 'html.parser')
	data = [i.text for i in soup.find_all(class_='txt')]
	print(data)
	print(soup.find_all(class_='txt')[-1].text)
	df = pd.DataFrame()
	df['Valor'] = [soup.find_all(class_='txt')[-1].text]
	df['Fecha'] = [soup.find_all(class_='txt')[-2].text]
	print(df)
	rate = [i / 10 for i in range(10)]
	time.sleep(random.choice(rate))
	scrap_quotes()


def scrap_quotes():
	authors = []
	quotes = []
	urls = [f"http://quotes.toscrape.com/page/{i}/" for i in range(1, 11)]
	rate = [i / 10 for i in range(10)]
	for url in urls:
		page = requests.get(url)
		soup = bs(page.content.decode('utf-8'), 'html.parser')
		authors.extend([i.text for i in soup.find_all(class_='author')])
		quotes.extend([i.text for i in soup.find_all(class_='text')])

		if len(quotes) >= 52:
			break

		time.sleep(random.choice(rate))
	df = pd.DataFrame()
	df['Authors'] = authors
	df['Quotes'] = quotes
	print(df)


if __name__ == '__main__':
	main()
