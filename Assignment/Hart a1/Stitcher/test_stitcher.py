import os
import sys
import unittest
import stitcher

class TestStitcher(unittest.TestCase):
    def test_empty(self):
        iter_test = stitcher.stitch_files()
        with self.assertRaises(StopIteration):
            next(iter_test)

    def test_invalid_input(self):
        iter_test = stitcher.stitch_files(5)
        with self.assertRaises(ValueError):
            next(iter_test)
        iter_test = stitcher.stitch_files("abc.txt", [5], "test.txt")
        with self.assertRaises(ValueError):
            next(iter_test)

    def test_file_not_found(self):
        iter_test = stitcher.stitch_files("nonexistingfile")
        with self.assertRaises(FileNotFoundError):
            next(iter_test)

    def test_iteration(self):
        iter_test = stitcher.stitch_files("abc.txt", "test.txt", "nonexistingfile")
        self.assertEqual("a", next(iter_test).strip())
        self.assertEqual("b", next(iter_test).strip())
        self.assertEqual("c", next(iter_test).strip())
        self.assertEqual("d", next(iter_test).strip())
        self.assertEqual("e", next(iter_test).strip())
        self.assertEqual("f", next(iter_test).strip())
        self.assertEqual("firstline", next(iter_test).strip())
        self.assertEqual("123", next(iter_test).strip())
        self.assertEqual("456", next(iter_test).strip())
        self.assertEqual("78910", next(iter_test).strip())
        self.assertEqual("111213", next(iter_test).strip())
        self.assertEqual("1415", next(iter_test).strip())
        self.assertEqual("lastline", next(iter_test).strip())
        with self.assertRaises(FileNotFoundError):
            next(iter_test)
        with self.assertRaises(StopIteration):
            next(iter_test)

if __name__ == '__main__':
    unittest.main()
