from memo_decor import fib, n_choose_r
from scipy.special import comb
import unittest

class TestMemoization(unittest.TestCase):
    def test_fib(self):
        self.assertEqual(fib(0), 0)
        self.assertEqual(fib(1), 1)
        self.assertEqual(fib(2), 1)
        self.assertEqual(fib(3), 2)
        self.assertEqual(fib(4), 3)
        self.assertEqual(fib(5), 5)
        self.assertEqual(fib(6), 8)
        self.assertEqual(fib(7), 13)
        self.assertEqual(fib(8), 21)
        self.assertEqual(fib(9), 34)
        self.assertEqual(fib(10), 55)
        self.assertEqual(fib(25), 75025)
        self.assertEqual(fib(37), 24157817)
        self.assertEqual(fib(50), 12586269025)
        self.assertEqual(fib(82), 61305790721611591)

    def test_n_count_r(self):
        for n in range(-200,200):
            for m in range(-100,400):
                self.assertEqual(n_choose_r(n,m), comb(n,m, exact=True))

if __name__ == '__main__':
    unittest.main()
