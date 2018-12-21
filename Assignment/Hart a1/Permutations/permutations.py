"""This module generates all permutation of numbers starting from 1 up to and including n"""

def helper_all_perms(numbers):
    """Recursive function to actually generate the permutations"""
    if len(numbers) <= 1:
        yield numbers
    else:
        # Generate all permutation for numbers excluding the first element
        for perm in helper_all_perms(numbers[1:]):
            # Insert the first element of numbers at all possible position in perm
            for index in range(len(numbers)):
                yield perm[:index] + [numbers[0]] + perm[index:]

def all_perms(size):
    """Generate the array for helper_all_perms and yield the result as tuple"""
    for perm in helper_all_perms([num for num in range(1, size+1)]):
        yield tuple(perm)
