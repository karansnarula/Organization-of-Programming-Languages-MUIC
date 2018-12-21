from typing import TypeVar, Iterator, List, Callable

A = TypeVar('A')
B = TypeVar('B')

def flat_map(xs: Iterator[A], f: Callable[[A], Iterator[B]]) -> Iterator[B]:
    while True:
       try:
           x = next(xs)
           for elem in f(x):
               yield elem
       except StopIteration:
           break

if __name__ == '__main__':
    def foo(x: int):
        if x < 0:
            return []
        return (x**i for i in range(3))

    it = flat_map(iter([3, -4, -5, 2]), foo)
    assert list(it) == [1, 3, 9, 1, 2, 4]
    print('Asserts OK.')