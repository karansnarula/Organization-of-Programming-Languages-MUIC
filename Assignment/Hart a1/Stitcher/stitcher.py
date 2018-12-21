"""The module stitches files' line together as a generator"""

def verify_input(args):
    """Verifies all input params is a string"""
    indexes_wrong_type = []
    for index, arg in enumerate(args):
        if not isinstance(arg, str):
            indexes_wrong_type.append(index)
    if indexes_wrong_type:
        raise ValueError("Input parameter(s) not a string at index: {}".format(indexes_wrong_type))

def stitch_files(*args):
    """Generator to yield line from multiple files sequentially"""
    verify_input(args) # Will raise exception if any input is not a string
    for file in args:
        with open(file, 'r') as file_pointer:  # f is an iterable object
            # Reads file line by line
            for line in file_pointer:
                yield line
