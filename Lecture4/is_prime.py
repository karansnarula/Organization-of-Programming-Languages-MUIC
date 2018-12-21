from typing import List
def is_prime(number: int) -> bool:
	sqrtn = int(number**0.5)
	divisible = False
	for d in range(2, number+1):
		if number % d == 0:
			divisible = True
	return not divisible

def primes_in_range(a: int, b: int) -> List[int]:
	return [number for number in range(a,b) if is_prime(number)]


# print(primes_in_range(1,10))

def fibonacci(n: int) -> int:
	if n <= 1:
		return n
	return fibonacci(n-1) + fibonacci(n-2)

print(fibonacci(8))
