from instapy_cli import client

username = 'lgzarturo@gmail.com'
password = 'gilt-CING0ford@drid'
image = 'posts/IMG_0722.JPG'
text = 'Hello world 😎'

with client(username, password) as cli:
	cli.upload(image, text)
