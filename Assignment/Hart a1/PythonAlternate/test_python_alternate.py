import os
import sys
import unittest
import alternate

def generator_finite(start_from, size):
    for _ in range(size):
        yield start_from
        start_from += 1

def generator_infinite(start_from):
    while True:
        yield start_from
        start_from += 1

class TestPythonAlternate(unittest.TestCase):
    def test_generator_finite(self):
        iter_test = alternate.iter_alternate(generator_finite(0, 5), generator_finite(10, 10))
        for n in range(5):
            self.assertEqual(n, next(iter_test))
            self.assertEqual(n+10, next(iter_test))
        for m in range(15, 20):
            self.assertEqual(m, next(iter_test))
        with self.assertRaises(StopIteration):
            next(iter_test)

    def test_generator_infinite(self):
        iter_test = alternate.iter_alternate(generator_infinite(0), generator_infinite(10))
        for n in range(100):
            self.assertEqual(n, next(iter_test))
            self.assertEqual(n+10, next(iter_test))
        

if __name__ == '__main__':
    unittest.main()
