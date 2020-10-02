from security import bruteforce_password
import argparse

parser = argparse.ArgumentParser(
  description="\nUsage: python zipforce.py -z <zipfile> -p <password_file>"
)
parser.add_argument('-z', dest='ziparchive', help="Zip archive file")
parser.add_argument('-p', dest='password_file', help="Password file")

parsed_args = parser.parse_args()

bruteforce_password.breaking(parsed_args.ziparchive, parsed_args.password_file)
