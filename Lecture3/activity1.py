def twice(func):
	def loop_twice(*args):
		func(*args)
		func(*args)
	return loop_twice

@twice
def say_hello(name):
	print(f'Hello, {name}')

say_hello('MUIC')


def repeat(n):
	def get_function(func):
		def do_something(*args):
			for _ in range(n):
				func(*args)
		return do_something
	return get_function



@repeat(3)
def say_hello(name):
	print(f'Hello, {name}')

say_hello('MUIC')

#A1 task7 use argument as key





# iter1 = [1,2,3]
# iter2 = [4,5,6]
# list = [1,2,3,4,5,6]