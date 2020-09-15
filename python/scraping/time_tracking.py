import sys
import time
import datetime
import os
import webbrowser
from selenium import webdriver
import appscript
from subprocess import Popen, PIPE

from os import path

url = path.realpath('.')
print(f'URL {url}')

try:
	from AppKit import NSWorkspace
	from Foundation import *
except ImportError:
	print("No se puede importar AppKit")
	sys.exit(1)

active_window_name = None
activity_name = ""
start_time = datetime.datetime.now()
first_time = True
osascript = '/usr/bin/osascript'
#https://gist.github.com/dongyuwei/a1c9d67e4af6bbbd999c
chrome = 'tell app "Google Chrome" to get the url of the active tab of window 1'
safari = 'tell app "Safari" to return URL of front document'
firefox = 'tell application "Firefox" to activate tell application "System Events" keystroke "l" using command down keystroke "c" using command down end tell'

try:
	while True:
		new_window_name = (NSWorkspace.sharedWorkspace()
			.activeApplication()['NSApplicationName'])

		if active_window_name != new_window_name:
			activity_name = active_window_name

			if not first_time:
				end_time = datetime.datetime.now()
				print(
					f'{active_window_name} - {activity_name} - End {end_time}')

			if active_window_name == 'Google Chrome':
				cmd = f'{osascript} -e \'{chrome}\''
				pipe = Popen(cmd, shell=True, stdout=PIPE).stdout
				print(pipe.readlines()[0])

			if active_window_name == 'Safari':
				cmd = f'{osascript} -e \'{safari}\''
				pipe = Popen(cmd, shell=True, stdout=PIPE).stdout
				print(pipe.readlines()[0])

			if active_window_name == 'Firefox':
				cmd = f'{osascript} -e \'{safari}\''
				pipe = Popen(cmd, shell=True, stdout=PIPE).stdout
				print(pipe.readlines()[0])

			first_time = False
			active_window_name = new_window_name

		time.sleep(1)
except KeyboardInterrupt:
	sys.exit(0)
