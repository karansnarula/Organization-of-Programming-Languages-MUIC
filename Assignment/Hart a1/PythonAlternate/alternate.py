"""The module combines two iterator and yield values alternately"""

def iter_alternate(iter1, iter2):
    """Iterator yielding values from two iterators alternately"""
    iters_has_next = [True, True]
    while True in iters_has_next:
        for index, iterator in enumerate([iter1, iter2]):
            next_value = next(iterator, None)
            if next_value is not None:
                yield next_value
            else:
                iters_has_next[index] = False
