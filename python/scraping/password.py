import sqlite3
from hashlib import sha256

conn = sqlite3.connect('pass_manager.db')
PASS = "1234"
connect = input("Cual es el password?:\n")

while connect != PASS:
	connect = input("Cual es el password?:\n")
	if connect == "q":
		break


def create_password(pass_key, service, admin_pass):
	admin_pass = admin_pass.encode('utf-8')
	service = service.lower().encode('utf-8')
	pass_key = pass_key.encode('utf-8')
	return sha256(f'{admin_pass}{service}{pass_key}'.encode('utf-8')).hexdigest()[:15]


def get_hex_key(admin_pass, service):
	admin_pass = admin_pass.encode('utf-8')
	service = service.lower().encode('utf-8')
	return sha256(f'{admin_pass}{service}'.encode('utf-8')).hexdigest()


def get_password(admin_pass, service):
	secret_key = get_hex_key(admin_pass, service)
	cursor = conn.execute(f'SELECT * FROM KEYS WHERE PASS_KEYS = "{secret_key}"')
	pass_key = ""
	for row in cursor:
		pass_key = row[0]
	return create_password(pass_key, service, admin_pass)


def add_password(service, admin_pass):
	secret_key = get_hex_key(admin_pass, service)
	command = f'INSERT INTO KEYS (PASS_KEYS) VALUES ("{secret_key}");'
	conn.execute(command)
	conn.commit()
	return create_password(secret_key, service, admin_pass)


if connect == PASS:
	try:
		command = f'CREATE TABLE KEYS (PASS_KEYS TEXT PRIMARY KEY NOT NULL);'
		conn.execute(command)
		print("Safe vault has been created!")
	except Exception:
		print("Already exists safe vault")

	while True:
		print('*'*30)
		print('COMMANDS:')
		print('q = quit program')
		print('sp = store password')
		print('gp = get password')
		print('*'*30)
		_input_ = input('> ')
		if _input_ == 'q':
			break
		if _input_ == 'sp':
			service = input('What is the name of service?\n')
			print(f'{service.capitalize()} password: {add_password(service, PASS)}')
		if _input_ == 'gp':
			service = input('What is the name of service?\n')
			print(f'{service.capitalize()} password: {get_password(service, PASS)}')
