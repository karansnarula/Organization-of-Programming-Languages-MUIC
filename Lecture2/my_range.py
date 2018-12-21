class my_range: #pretend this is a function even if it is a class
	def __init__(self,n):
		self.n = n
		self.index = 0

	def __iter__(self):
		return self

	def __next__(self):
		if self.index < self.n:
			index = self.index
			self.index += 1
			return index
		else:
			raise StopIteration

class natural_numbers:
	def __init__(self):
		self.index = 0

	def __iter__(self):
		return self

	def __next__(self):
		index = self.index
		self.index += 1
		return index

class fib_sequence:
	def __init__(self):
		self.index = 0
		self.first = 1
		self.second = 1
	
	def __iter__(self):
		next_number = self.first + self.second
		return next_number

	def __next__(self):
		index = self.index
		self.index += 1
		return index

# for number in natural_numbers():
# 	print(number

def foo():
	print("A")
	yield 3
	print("B")
	yield 5
	print("C")
	yield 2
	print("D")

def prime_from(n = 1):
	def is_prime(num):
		while True:
			if is_prime(n):
				yield n
			n += 1

def combine_generator(g1,g2):
	try:
		while True:
			yield next(g1)
	except StopIteration:
		pass
	try:
		while True:
			yield next(g2)
	except StopIteration:
		pass

	# yield from g1 # simplified version
	# yield from g2 # simplified version