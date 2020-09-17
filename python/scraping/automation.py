from pathlib import Path
from watchdog.events import FileSystemEventHandler
from watchdog.observers import Observer

import json
import time
import os


class CustomHandler(FileSystemEventHandler):
	def on_modified(self, event):
		for filename in os.listdir(folder_to_track):
			try:
				index = 1
				new_name = f'new_file_{str(index)}.txt'
				name, extension = os.path.splitext(filename)
				file_exists = os.path.isfile(f'{folder_destination}/{new_name}')
				print(f'filename:{name}, extension:{extension}, exists:{file_exists}')
				while file_exists:
					index += 1
					new_name = f'new_file_{str(index)}{extension}'
					file_exists = os.path.isfile(f'{folder_destination}/{new_name}')
				src = f'{folder_to_track}/{filename}'
				new_destination = f'{folder_destination}/{new_name}'
				os.rename(src, new_destination)
			except Exception:
				print(filename)


home_directory = Path.home()
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
