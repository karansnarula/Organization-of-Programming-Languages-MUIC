# pylint: disable=C0103
def all_perms(n):
    """Main Function"""
    make_list = list(all_perms_helper(n))
    yield make_list


def all_perms_helper(n):
    """Helper function"""
    lst = [tuple(range(n)[1:])]
    final_list = []
    y = 0
    if n == 1:
        return set([(1,)])
    lst = all_perms_helper(n-1)
    for element in lst:
        while y <= len(element):
            perm_tuple = element[:y] + (n,) + element[y:]
            final_list.append(perm_tuple)
            y += 1
        y = 0
    return set(final_list)

