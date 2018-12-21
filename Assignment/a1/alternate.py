def iter_alternate(iter1, iter2):
    """Main Function"""
    iter1_stop_loop = False
    iter2_stop_loop = False
    while True:
        try:
            yield next(iter1)
        except StopIteration:
            iter1_stop_loop = True
            # pass
            if(iter1_stop_loop is True and iter2_stop_loop is True):
                return
        try:
            yield next(iter2)
        except StopIteration:
            iter2_stop_loop = True
            # pass
            if(iter1_stop_loop is True and iter2_stop_loop is True):
                return
