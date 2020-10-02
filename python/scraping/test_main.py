from security import cipher, paperclip


def main():
  data = '.daed era meht fo owt fi ,terces a peek nac eerhT'
  print(cipher.reverse(data))
  data = 'this is my secret message'
  data_encrypted = cipher.caesar(data)
  print(data_encrypted)
  print(cipher.caesar(data_encrypted, 'decrypt'))
  paperclip.copy(data_encrypted)
  print('='*40)
  cipher.breaking_caesar(data_encrypted)
  text = cipher.caesar_encrypt(data)
  print(text+" | "+cipher.caesar_decrypt(text))
  cipher.transposition()


if __name__ == '__main__':
  main()
