import json
import sys
import time
import tldextract
import inspect
import datetime
from time_activity import ActivityList, TimeEntry, Activity
from subprocess import Popen, PIPE

from os import path

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
activity_list = ActivityList([])
output_filename = 'activities.json'
osascript = '/usr/bin/osascript'
#https://gist.github.com/dongyuwei/a1c9d67e4af6bbbd999c
chrome = 'tell app "Google Chrome" to get the url of the active tab of window 1'
safari = 'tell app "Safari" to return URL of front document'
firefox = 'tell app "Firefox" to get name of front window'


def get_window_name():
	name = (NSWorkspace.sharedWorkspace().activeApplication()['NSApplicationName'])
	return name


def get_activity_name(window_name):
	if active_window_name == 'Google Chrome':
		command = f'{osascript} -e \'{chrome}\''
	elif active_window_name == 'Safari':
		command = f'{osascript} -e \'{safari}\''
	elif active_window_name == 'Firefox':
		command = f'{osascript} -e \'{firefox}\''
	else:
		return window_name

	command_pipe = Popen(command, shell=True, stdout=PIPE).stdout
	lines = command_pipe.readlines()
	action_name = lines[0].decode('utf-8')\
		.__str__().replace('\r', '').replace('\n', '')
	sys.stdout.flush()

	if action_name == '':
		return window_name

	if active_window_name == 'Firefox':
		return f'{window_name} - {action_name}'

	domain = tldextract.extract(f'{action_name}').registered_domain

	return f'{window_name} - {domain}'


def save_activity_list(data):
	with open(output_filename, 'w') as file:
		json.dump(data, file, indent=2, sort_keys=True)


try:
	while True:
		new_window_name = get_window_name()

		if active_window_name != new_window_name:
			activity_name = get_activity_name(active_window_name)
			print(activity_name)

			if not first_time:
				exists = False
				end_time = datetime.datetime.now()
				time_entry = TimeEntry(start_time, end_time, 0, 0, 0, 0)
				for activity in activity_list.activities:
					if activity.name == activity_name:
						exists = True
						activity.time_entries.append(time_entry)
						break

				if not exists:
					activity = Activity(activity_name, [time_entry])
					activity_list.activities.append(activity)

				save_activity_list(activity_list.serialize())
				start_time = datetime.datetime.now()
			first_time = False
			active_window_name = new_window_name

		time.sleep(1)
except KeyboardInterrupt:
	save_activity_list(activity_list.serialize())
	sys.exit(0)


