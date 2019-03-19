import socket
from random import randint
class Server:
	def __init__(self, HOST = "localhost", PORT = 9999):
		self.HOST = HOST
		self.PORT = PORT
		self.s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
		print('Socket created')
	def connect(self):
		try:
			self.s.bind((self.HOST, self.PORT))
		except socket.error as err:
			print('Bind failed. Error Code : ' .format(err))
		while True:
			self.s.listen(10)
			print("Socket Listening")
			conn, addr = self.s.accept()
			
			game = HangGame()
			word = game.chooseWord()
			print(word)
			len_word = len(word)
			unicas = set() 	#create a set to have control of unique letters
			for e in word:
				unicas.add(e)

			conn.send(bytes(str(len_word)+"\n", "UTF-8")) #send the length of the string to the client

			correct = 0
			mistakes = 0
			while correct < len(word) and mistakes < 10: #we will ask for a letter from client until
				letter = conn.recv(1024)				
				letter = letter.decode(encoding='UTF-8')
				#letter = chr(letter[-1])
				print("letter: <<" + str(letter)+">>")
				positions = []
				if letter in unicas: #if the letter from client is in the set
					print("This word is in")
					conn.send(bytes("0\n", "UTF-8"))
					for i in range(0, len(word)):
						if word[i] == letter:
							positions.append(i)
					correct += len(positions)	#number of ocurrences found
					print(positions) #list with the positions of the guessed letters
					conn.send(bytes(str(len(positions))+"\n", "UTF-8")) #we send the positions to the client
					for i in range(0, len(positions)):
						print("sending: " + str(positions[i]))
						conn.send(bytes(str(positions[i])+"\n", "UTF-8"))
				else:
					mistakes += 1		#if the letter is not in the set then we increase the mistakes
					print("This word is not")
					conn.send(bytes("1\n", "UTF-8"))
				if correct == len(word):
					print("The player guessed all the letters :)")
				if mistakes >= 10:
					print("The player was not able to guess all the words :(")
			'''
			conn.send(bytes("From server python"+"\r\n",'UTF-8'))
			print("Message sent")
			data = conn.recv(1024)
			print("received: " + data.decode(encoding='UTF-8'))'''

class HangGame:
	def __init__(self, words = None):
		if words == None:
			self.words = ["mexico", "brasil", "venezuela", "argentina", "uruguay", "guatemala", "belice", "ecuador", "brasil"]
		else:
			self.words = words
	def chooseWord(self):
		total = len(self.words)
		pos_word = randint(0, total - 1)
		return self.words[pos_word]

test = Server()
test.connect()	    
