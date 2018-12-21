import os
import sys
import unittest
from itertools import count
import dovetail

class TestDovetail(unittest.TestCase):
    def test_empty(self):
        test_iter = dovetail.iter_dovetail()
        with self.assertRaises(StopIteration):
            next(test_iter)

    def test_invalid(self):
        test_iter = dovetail.iter_dovetail([3,5,9], 12, count(0))
        with self.assertRaises(TypeError):
            next(test_iter)

    def test_finite(self):
        test_iter = dovetail.iter_dovetail(
                                [3,5,9],
                                [4],
                                [8,7,11,6])
        self.assertEqual(3, next(test_iter))
        self.assertEqual(4, next(test_iter))
        self.assertEqual(5, next(test_iter))
        self.assertEqual(8, next(test_iter))
        self.assertEqual(9, next(test_iter))
        self.assertEqual(7, next(test_iter))
        self.assertEqual(11, next(test_iter))
        self.assertEqual(6, next(test_iter))
        with self.assertRaises(StopIteration):
            next(test_iter)
    
    def test_finite_single(self):
        test_iter = dovetail.iter_dovetail([3,5,9])
        self.assertEqual(3, next(test_iter))
        self.assertEqual(5, next(test_iter))
        self.assertEqual(9, next(test_iter))
        with self.assertRaises(StopIteration):
            next(test_iter)

    def test_infinite(self):
        test_iter = dovetail.iter_dovetail(
                                count(0),
                                count(11),
                                count(9),
                                count(100))
        self.assertEqual(0, next(test_iter))
        self.assertEqual(11, next(test_iter))
        self.assertEqual(1, next(test_iter))
        self.assertEqual(9, next(test_iter))
        self.assertEqual(12, next(test_iter))
        self.assertEqual(2, next(test_iter))
        self.assertEqual(100, next(test_iter))
        self.assertEqual(10, next(test_iter))
        self.assertEqual(13, next(test_iter))
        self.assertEqual(3, next(test_iter))
        self.assertEqual(101, next(test_iter))
        self.assertEqual(11, next(test_iter))
        self.assertEqual(14, next(test_iter))
        self.assertEqual(4, next(test_iter))
    
    def test_infinite_single(self):
        test_iter = dovetail.iter_dovetail(count(0))
        for n in range(100):
            self.assertEqual(n, next(test_iter))

if __name__ == '__main__':
    unittest.main()
