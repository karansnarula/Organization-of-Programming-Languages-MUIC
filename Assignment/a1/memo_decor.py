#pylint: disable=C0103
"""Main Class"""
def memoized(func):
    """Memoized function"""
    mem = {}
    def helper(*args):
        if args not in mem:            
            mem[args] = func(*args)
        return mem[args]
    return helper

@memoized
def fib(n):
    """Fib function"""
    if n <= 1:
        return n
    return fib(n-1) + fib(n-2)

@memoized
def n_choose_r(n, r):
    """nCr function"""
    if r == 0:
        return 1
    if n == r:
        return 1
    return n_choose_r(n-1, r-1) + n_choose_r(n-1, r)
