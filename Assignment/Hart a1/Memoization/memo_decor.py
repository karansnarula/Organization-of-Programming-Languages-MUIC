"""This module contain a memoized decorator, and two memoized functions (fib, n_choose_r)"""
import functools

class Memoized:
    """Decorator adding memoization to a function"""
    def __init__(self, func):
        functools.update_wrapper(self, func) # Will make e.g. fib.__name__ = "fib"
        self.func = func
        self.mem = {}

    def memoizer(self, *args, **kwargs):
        """The function that actually memoized the function and update the dictionary memory"""
        if args not in self.mem:
            self.mem[args] = self.func(*args, **kwargs)
        return self.mem[args]

    def __call__(self, *args, **kwargs):
        return self.memoizer(*args, **kwargs)

@Memoized
def fib(num):
    """Return the nth fib number"""
    if num <= 1:
        return num
    return fib(num-1) + fib(num-2)

@Memoized
def n_choose_r(n_value, r_value):
    """Return the total combinations for n choose r"""
    if n_value < r_value or n_value < 0 or r_value < 0:
        return 0
    if r_value in (0, n_value):
        return 1
    return n_choose_r(n_value-1, r_value-1) + n_choose_r(n_value-1, r_value)
