import json

from product import Product, convert_price_to_number
from selenium import webdriver
from selenium.webdriver.common.keys import Keys

# Revisando precios en Amazon
URL = "https://www.amazon.com.mx"
NUMBER_OF_PAGES_TO_REVIEW = 2
search_term = str(input('Que producto buscas?\n>')).split(" ")

best_discount = 0.0
best_price = 0.0
cheapest_product = Product("", "", "", "")
best_deal_product = Product("", "", "", "")

# Configuración del navegador
options = webdriver.ChromeOptions()
options.add_argument('--ignore-certificate-errors')
options.add_argument('--incognito')
options.add_argument('--headless')
driver = webdriver.Chrome('./chromedriver85', chrome_options=options)

# Acceder al sitio web
driver.get(URL)
search_box = driver.find_element_by_xpath('//*[@id="twotabsearchtextbox"]')
search_box.send_keys(search_term)
search_box.send_keys(Keys.ENTER)

products = []

page = NUMBER_OF_PAGES_TO_REVIEW

while True:
	if page != 0:
		try:
			page_url = f'{driver.current_url}&page={str(page)}'
			print(f'Crawling: {page_url}')
			driver.get(f'{page_url}')
		except Exception:
			break

	for index_result in driver.find_elements_by_xpath('//*[@id="search"]/div[1]/div[2]/div/span[4]/div[1]'):
		counter = 0
		for element in index_result.find_elements_by_xpath('//div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/a'):
			should_add = True
			name = ""
			price = ""
			old_price = ""
			link = ""
			try:
				name = index_result.find_element_by_tag_name('h2')[counter].text
				product_price = element.find_element_by_class_name('a-price').text
				price = convert_price_to_number(product_price)
				link = index_result.find_element_by_xpath()[counter].get_attribute('href')
				try:
					product_price = element.find_element_by_class_name(
						'a-text-price').text
					old_price = convert_price_to_number(product_price)
				except Exception:
					old_price = price
			except Exception:
				should_add = False
				continue
			product = Product(name, price, old_price, link)
			if should_add:
				products.append(product)
			counter = counter + 1
	page = page - 1
	if page == 0:
		break
	print(page)

run = 0

for product in products:
	not_right = False
	for word in search_term:
		if word.lower() not in product.name.lower():
			not_right = True
	if not not_right:
		if run == 0:
			best_price = product.current_price
			cheapest_product = product
			run = 1
		elif product.current_price < best_price:
			best_price = product.current_price
			cheapest_product = product
		discount = product.old_price - product.current_price
		if discount > best_discount:
			best_discount = discount
			best_deal_product = product

with open('products.json', 'w') as json_file:
	data = {"Products": []}
	for product in products:
		data["Products"].append(product.serialize())
	json.dump(data, json_file, sort_keys=True, indent=2)

print(json.dumps(cheapest_product.serialize(), sort_keys=True, indent=2))
print(json.dumps(best_deal_product.serialize(), sort_keys=True, indent=2))

# Configuración del navegador
options = webdriver.ChromeOptions()
options.add_argument('--ignore-certificate-errors')
options.add_argument('--incognito')
options.add_argument('--headless')
driver = webdriver.Chrome('./chromedriver85', chrome_options=options)

# Acceder al sitio web
if best_deal_product.link != '':
	driver.get(best_deal_product.link)
	driver.find_element_by_tag_name('body').send_keys(Keys.COMMAND+'t')

