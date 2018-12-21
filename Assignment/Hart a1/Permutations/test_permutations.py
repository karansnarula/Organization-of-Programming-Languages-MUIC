import os
import sys
import unittest
import itertools
import permutations

class TestPermutations(unittest.TestCase):
    def test_permutations_1(self):
        my_perms = set()
        actual_perms = set(itertools.permutations([1]))
        for perm in permutations.all_perms(1):
            self.assertTrue(perm in actual_perms)
            my_perms.add(perm)
        self.assertEqual(len(my_perms), len(actual_perms))

    def test_permutations_2(self):
        my_perms = set()
        actual_perms = set(itertools.permutations([1, 2]))
        for perm in permutations.all_perms(2):
            self.assertTrue(perm in actual_perms)
            my_perms.add(perm)
        self.assertEqual(len(my_perms), len(actual_perms))   
    
    def test_permutations_3(self):
        my_perms = set()
        actual_perms = set(itertools.permutations([1, 2, 3]))
        for perm in permutations.all_perms(3):
            self.assertTrue(perm in actual_perms)
            my_perms.add(perm)
        self.assertEqual(len(my_perms), len(actual_perms))   

    def test_permutations_4(self):
        my_perms = set()
        actual_perms = set(itertools.permutations([1, 2, 3, 4]))
        for perm in permutations.all_perms(4):
            self.assertTrue(perm in actual_perms)
            my_perms.add(perm)
        self.assertEqual(len(my_perms), len(actual_perms))

    def test_permutations_10(self):
        my_perms = set()
        actual_perms = set(itertools.permutations([1, 2, 3, 4, 5, 6, 7, 8, 9]))
        for perm in permutations.all_perms(9):
            self.assertTrue(perm in actual_perms)
            my_perms.add(perm)
        self.assertEqual(len(my_perms), len(actual_perms))   

if __name__ == '__main__':
    unittest.main()
