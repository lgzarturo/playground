import math
import random
import sys

symbols = ' !"#$%&/\\()=\'¡?¿`*´{}[]-.,_<>@|~^'
numbers = "1234567890"
letters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
alphabet = f'{symbols}{numbers}{letters}'


def reverse(message):
  translated = ''
  index = len(message) - 1
  while index >= 0:
    translated = translated + message[index]
    print(index, message[index], translated)
    index -= 1
  return translated


def caesar(message, mode='encrypt'):
  key = 50
  translated = ''
  message = message.upper()

  for symbol in message:
    if symbol in alphabet:
      num = alphabet.find(symbol)
      if mode == 'encrypt':
        num = num + key
      elif mode == 'decrypt':
        num = num - key

      if num >= len(alphabet):
        num = num - len(alphabet)
      elif num < 0:
        num = num + len(alphabet)

      translated = translated + alphabet[num]
    else:
      translated = translated + symbol
  return translated


def caesar_encrypt(message, key_size=8):
  ciphertext = [''] * key_size
  for col in range(key_size):
    pointer = col
    while pointer < len(message):
      ciphertext[col] += message[pointer]
      pointer += key_size
  return ''.join(ciphertext)


def caesar_decrypt(encrypted_message, key_size=8):
  cols = math.ceil(len(encrypted_message) / key_size)
  rows = key_size
  shades = (cols * rows) - len(encrypted_message)
  plaintext = [''] * cols
  col = 0
  row = 0
  for symbol in encrypted_message:
    plaintext[col] += symbol
    col += 1
    if (col == cols) or (col == cols - 1 and row >= rows - shades):
      col = 0
      row += 1
  return ''.join(plaintext)


def breaking_caesar(message):
  for key in range(len(alphabet)):
    translated = ''
    for symbol in message:
      if symbol in alphabet:
        num = alphabet.find(symbol)
        num = num - key

        if num < 0:
          num = num + len(alphabet)

        translated = translated + alphabet[num]
      else:
        translated = translated + symbol
    print(f'{key}.- Translated: {translated}')


def random_string():
  message = letters * random.randint(4, 40)
  message = list(message)
  random.shuffle(message)
  message = ''.join(message)
  return message


def transposition(seed=42):
  random.seed(seed)
  for index in range(20):
    message = random_string()
    print(f'Test #{index}: "{message[:50]}..."')
    for key in range(1, len(message)):
      encrypted = caesar_encrypt(message, key)
      decrypted = caesar_decrypt(encrypted, key)
      if message != decrypted:
        print(f'Error con la llave {key} y el mensaje {message}')
        print(decrypted)
        sys.exit()
  print('Se han pasado las pruebas del cifrado')
