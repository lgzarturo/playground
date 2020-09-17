import sys
import subprocess
import os
import time
from decouple import config
from selenium import webdriver
from selenium.webdriver.common.keys import Keys

IP_NETWORK = config('IP_NETWORK')
IP_DEVICE = config('IP_DEVICE')
URL = "https://music.youtube.com/"

proc = subprocess.Popen(['ping', IP_NETWORK], stdout=subprocess.PIPE)

sent_warning = True

while True:
	line = proc.stdout.readline()
	if not line:
		break
	connected_ip = (line.decode('utf-8').split()[3]).split(':')[0]

	if connected_ip == IP_DEVICE and sent_warning:
		subprocess.Popen(['say', 'Hola Gustavo!'])
		options = webdriver.ChromeOptions()
		driver = webdriver.Chrome('./chromedriver85', chrome_options=options)
		driver.get(URL)
		time.sleep(2)
		button = driver.find_element_by_xpath(
			'/html/body/ytmusic-app/ytmusic-app-layout/div[3]/ytmusic-browse-response/ytmusic-section-list-renderer/div[2]/ytmusic-immersive-carousel-shelf-renderer/div/ytmusic-carousel/div/ul/ytmusic-two-row-item-renderer[1]/a/ytmusic-item-thumbnail-overlay-renderer/div/ytmusic-play-button-renderer/div')
		button.click()
		time.sleep(2)
		sent_warning = False

	if connected_ip != IP_DEVICE and not sent_warning:
		subprocess.Popen(['say', 'Adios, Gustavo, espero que tengas buen día!'])
		sent_warning = True
