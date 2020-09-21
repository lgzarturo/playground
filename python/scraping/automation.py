#!/usr/bin/env python

from pathlib import Path
from watchdog.events import FileSystemEventHandler
from watchdog.observers import Observer

import time
import os
import uuid


def add_extension_path(path: Path, extension):
  extension_path = path / f'{extension}'
  extension_path.mkdir(parents=True, exist_ok=True)
  return extension_path


def move_file(filename):
  index = 0
  name, extension = os.path.splitext(filename)

  if extension in extension_paths:
    folder_path = add_extension_path(
      destination_path, extension_paths[extension]
    )
  else:
    folder_path = add_extension_path(
      destination_path, 'other/uncategorized'
    )

  new_name = f'{name}{extension}'
  file_exists = os.path.isfile(f'{folder_path}/{new_name}')
  print(f'filename:{name}, extension:{extension}, exists:{file_exists}')
  while file_exists:
    index += 1
    new_name = f'{name}_{str(index)}{extension}'
    file_exists = os.path.isfile(f'{folder_path}/{new_name}')
  src = f'{folder_to_track}/{filename}'
  new_destination = f'{folder_path}/{new_name}'
  try:
    os.rename(src, new_destination)
  except Exception:
    os.rename(src, f'{new_destination}-{uuid.uuid4()}')


def move_folder(folder):
  print(f'folder:{folder}')
  src = f'{folder_to_track}/{folder}'
  folder_path = add_extension_path(
    destination_path, 'folders'
  )
  new_destination = f'{folder_path}/{folder}'
  try:
    os.rename(src, new_destination)
  except Exception:
    os.rename(src, f'{folder_path}-{uuid.uuid4()}')


class CustomHandler(FileSystemEventHandler):
  def on_modified(self, event):
    for name in os.listdir(folder_to_track):
      if name not in ignore_files:
        if Path.resolve(track_path / name).is_dir():
          move_folder(name)
        else:
          move_file(name)

    for root, dirs, files in os.walk(folder_destination, topdown=False):
      for name in dirs:
        try:
          if len(os.listdir(os.path.join(root, name))) == 0:
            print("Deleting", os.path.join(root, name))
            try:
              os.rmdir(os.path.join(root, name))
            except:
              print("FAILED :", os.path.join(root, name))
              pass
        except:
          pass


def main():
  if not destination_path.exists():
    destination_path.mkdir(parents=True, exist_ok=True)

  event_handler = CustomHandler()
  observer = Observer()
  observer.schedule(event_handler, folder_to_track, recursive=True)
  observer.start()

  try:
    while True:
      time.sleep(1)
  except KeyboardInterrupt:
    observer.stop()

  observer.join()


track_path = Path.home() / 'Downloads'
destination_path = Path.home() / 'Desktop' / 'ArturoLG'
folder_to_track = f'{track_path}'
folder_destination = f'{destination_path}'

ignore_files = ['.DS_Store', 'Thumbs.db', 'desktop.ini']

extension_paths = {
  # No name
  'noname': 'other/uncategorized',
  # audio
  '.aif': 'media/audio',
  '.cda': 'media/audio',
  '.mid': 'media/audio',
  '.midi': 'media/audio',
  '.mp3': 'media/audio',
  '.mpa': 'media/audio',
  '.ogg': 'media/audio',
  '.wav': 'media/audio',
  '.wma': 'media/audio',
  '.wpl': 'media/audio',
  '.m3u': 'media/audio',
  # text
  '.txt': 'text/text_files',
  '.doc': 'text/microsoft/word',
  '.docx': 'text/microsoft/word',
  '.odt ': 'text/text_files',
  '.pdf': 'text/pdf',
  '.rtf': 'text/text_files',
  '.tex': 'text/text_files',
  '.wks ': 'text/text_files',
  '.wps': 'text/text_files',
  '.wpd': 'text/text_files',
  '.epub': 'text/book',
  '.mobi': 'text/book',
  # video
  '.3g2': 'media/video',
  '.3gp': 'media/video',
  '.avi': 'media/video',
  '.flv': 'media/video',
  '.h264': 'media/video',
  '.m4v': 'media/video',
  '.mkv': 'media/video',
  '.mov': 'media/video',
  '.mp4': 'media/video',
  '.mpg': 'media/video',
  '.mpeg': 'media/video',
  '.rm': 'media/video',
  '.swf': 'media/video',
  '.vob': 'media/video',
  '.wmv': 'media/video',
  # images
  '.bmp': 'media/images',
  '.gif': 'media/images',
  '.jpg': 'media/images',
  '.jpeg': 'media/images',
  '.png': 'media/images',
  '.ps': 'media/images',
  '.svg': 'media/images',
  '.tif': 'media/images',
  '.tiff': 'media/images',
  '.cr2': 'media/images',
  # internet
  '.ics': 'other/calendar',
  '.asp': 'other/internet',
  '.aspx': 'other/internet',
  '.cer': 'other/internet',
  '.cfm': 'other/internet',
  '.cgi': 'other/internet',
  '.pl': 'other/internet',
  '.css': 'other/internet',
  '.htm': 'other/internet',
  '.js': 'other/internet',
  '.jsp': 'other/internet',
  '.part': 'other/internet',
  '.php': 'other/internet',
  '.rss': 'other/internet',
  '.xhtml': 'other/internet',
  '.html': 'other/internet',
  # compressed
  '.7z': 'other/compressed',
  '.arj': 'other/compressed',
  '.deb': 'other/compressed',
  '.pkg': 'other/compressed',
  '.rar': 'other/compressed',
  '.rpm': 'other/compressed',
  '.tar.gz': 'other/compressed',
  '.z': 'other/compressed',
  '.zip': 'other/compressed',
  # disc
  '.bin': 'other/disc',
  '.dmg': 'other/installer',
  '.iso': 'other/disc',
  '.toast': 'other/disc',
  '.vcd': 'other/disc',
  # data
  '.csv': 'programming/data',
  '.dat': 'programming/database',
  '.db': 'programming/database',
  '.dbf': 'programming/database',
  '.log': 'programming/log',
  '.mdb': 'programming/database',
  '.sav': 'programming/database',
  '.sql': 'programming/database',
  '.tar': 'programming/backup',
  '.xml': 'programming/database',
  '.json': 'programming/data',
  # executables
  '.apk': 'other/executables',
  '.bat': 'other/executables',
  '.com': 'other/executables',
  '.exe': 'other/executables',
  '.gadget': 'other/executables',
  '.jar': 'other/executables',
  '.wsf': 'other/executables',
  # fonts
  '.fnt': 'other/fonts',
  '.fon': 'other/fonts',
  '.otf': 'other/fonts',
  '.ttf': 'other/fonts',
  '.woff2': 'other/fonts',
  # presentations
  '.key': 'text/presentations',
  '.odp': 'text/presentations',
  '.pps': 'text/presentations',
  '.ppt': 'text/presentations',
  '.pptx': 'text/presentations',
  # programming
  '.c': 'programming/c&c++',
  '.class': 'programming/java',
  '.java': 'programming/java',
  '.py': 'programming/python',
  '.sh': 'programming/shell',
  '.h': 'programming/c&c++',
  '.patch': 'programming/changes',
  '.http': 'programming/endpoints',
  # spreadsheets
  '.ods': 'text/microsoft/excel',
  '.xlr': 'text/microsoft/excel',
  '.xls': 'text/microsoft/excel',
  '.xlsx': 'text/microsoft/excel',
  # system
  '.bak': 'text/other/system',
  '.cab': 'text/other/system',
  '.cfg': 'text/other/system',
  '.cpl': 'text/other/system',
  '.cur': 'text/other/system',
  '.dll': 'text/other/system',
  '.dmp': 'text/other/system',
  '.drv': 'text/other/system',
  '.icns': 'text/other/system',
  '.ico': 'text/other/system',
  '.ini': 'text/other/system',
  '.lnk': 'text/other/system',
  '.msi': 'text/other/system',
  '.sys': 'text/other/system',
  '.tmp': 'text/other/system',
  # adobe
  '.xd': 'work/xd',
  '.psd': 'work/photoshop',
  '.ai': 'media/illustrator',
}

if __name__ == '__main__':
  main()
