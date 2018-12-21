"""This module yields objects from multiple iterators in a dovetail sequence"""

def iter_dovetail(*args):
    """Generator yielding objects using dovetailing from multiple iterators"""
    iterators = [iter(arg) for arg in args]
    iterators_has_next = [True for arg in args]
    current_iter_index, current_diagonal_length, max_diagonal_length = 0, 0, 1
    while True in iterators_has_next:
        while current_diagonal_length < max_diagonal_length:
            try:
                yield next(iterators[current_iter_index])
            except StopIteration:
                iterators_has_next[current_iter_index] = False
            finally:
                current_diagonal_length += 1
                current_iter_index -= 1
        if max_diagonal_length < len(iterators):
            max_diagonal_length += 1
        current_iter_index = max_diagonal_length - 1 # Minus 1 to convert length to index
        current_diagonal_length = 0
