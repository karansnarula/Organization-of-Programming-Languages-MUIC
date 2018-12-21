# no side effects
# side-effects free

def triple(x):
	return x * 3

# has side effects
def say_hello(name):
	print('Hello, {}'.format(name))
	return name

def meow(name):
	print('Meow meow .. {}'.format(name))

def greet_pan(greet_func):
	greet_func('Pan')

def foo(name):
	def bar(code):
		print(f'{name}: {code}')
	def moo(rep):
		print(name*rep)
	DEFAULT_NUM = 3
	bar('1409')
	moo(DEFAULT_NUM)

def foo2(multiplier, absolute = False):
	def mult(x):
		return x * multiplier
	def abs_mult(x):
		return abs(x * multiplier)
	if absolute:
		return abs_mult
	else:
		return mult

def tracer(func):
	def perform_trace(*args):
		from time import time
		name = func.__name__
		print(f'[LOG] Call: {name}{args}')
		start = time()
		return_value = func(*args)
		done = time()
		print(f'[LOG] Took {(done-start):.3}s')
		return return_value
	return perform_trace

@tracer
def adder(x,y):
	from time import sleep
	sleep(5.0)
	return x + y

# adder = tracer(adder)

def debug_adder(x,y):
	print(f'[LOG] debug_adder({x}, {y})') #without writing
	return x + y


def fac(n):
	if n == 0:
		return 1
	else:
		return n * fac(n-1)

import json
def get_name(json_raw):
	body = json.loads(json_raw)
	return body.get('name')

json.loads = tracer(json.loads)

print(foo2(3)(2))

# print(adder(2,3))

#Functions are values, so you can do many things with values
#Function:
#pass in an arg
#nesting
#can be returned