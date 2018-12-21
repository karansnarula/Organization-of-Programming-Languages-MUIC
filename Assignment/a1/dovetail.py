"""Main Class"""
def iter_dovetail(*iterators):
    """Main function"""
    modify_list = []
    for lst in iterators:
        modify_list.append(list(lst))
    new_list = make_them_equal_length(modify_list)
    yield flattener_list(traversal(new_list,len(new_list[0])))

def traversal(new_list, lenght_of_list):
    """Helper Function, the nest for-loop traverses only the first
    column and then go diagonally. The while-for loop traverses the
    rest of the column and then go diagonally every column it visits"""
    traversed_list = []
    for lst_index in range(len(new_list)):
        for element in range(lst_index + 1):
            try:
                traversed_list.append(new_list[lst_index][element])
                lst_index -= 1
            except IndexError:
                break
    if lenght_of_list > 1:
        element_index = 1
        lst_index = len(new_list) - 1
        while(element_index < len(new_list[0])):
            for element in range(len(new_list)):
                try:
                    traversed_list.append(new_list[lst_index][element + element_index])
                    lst_index -= 1
                except IndexError:
                    break
            lst_index = len(new_list) - 1
            element_index += 1
    return traversed_list

def make_them_equal_length(lists):
    """Helper function"""
    equal_list = []
    longest_length = len(max(lists, key=len)) # Max lenght of the list of lists
    for lst in lists:
        lst += [""] * (longest_length - len(lst))
        equal_list.append(lst)
    return equal_list

def flattener_list(lst):
    """Helper function"""
    flattened_list = []
    for element in lst:
        if element != '':
            flattened_list.append(element)
    return flattened_list
