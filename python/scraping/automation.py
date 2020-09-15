from watchdog.events import FileSystemEventHandler
from watchdog.observers import Observer

import json
import time
import os


class CustomHandler(FileSystemEventHandler):
	i = 1

	def on_modified(self, event):
		new_name = f'new_file_{str(self.i)}.txt'
		for filename in os.listdir(folder_to_track):
			file_exists = os.path.isfile(f'{folder_destination}/{new_name}')
			while file_exists:
				self.i += 1
				new_name = f'new_file_{str(self.i)}.txt'
				file_exists = os.path.isfile(f'{folder_destination}/{new_name}')
			src = f'{folder_to_track}/{filename}'
			new_destination = f'{folder_destination}/{new_name}'
			os.rename(src, new_destination)


home_directory = '/Users/arturolopez'
folder_to_track = f'{home_directory}/Downloads/test'
folder_destination = f'{home_directory}/Downloads/testAutomation'
event_handler = CustomHandler()
observer = Observer()
observer.schedule(event_handler, folder_to_track, recursive=True)
observer.start()

try:
	while True:
		time.sleep(10)
except KeyboardInterrupt:
	observer.stop()

observer.join()
