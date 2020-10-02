from zipfile import ZipFile


def breaking(filename, pass_file):
  global zip_file, foundpass
  try:
    zip_file = ZipFile(filename)
    foundpass = ""
  except:
    exit(0)

  with open(pass_file, "r") as f:
    for line in f:
      password = line.strip("\n")
      password = password.encode("utf-8")

      try:
        foundpass = zip_file.extractall(pwd = password)
        if foundpass is None:
          print("\nFound password: ",password.decode())
      except RuntimeError:
        pass

    if foundpass == "":
      print("\nPassword not found, try a bigger password list!!")
