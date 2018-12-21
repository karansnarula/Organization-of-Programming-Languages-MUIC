def stitch_files(*args):
    """Main Function"""
    try:
        for files in args:
            try:
                file = open(files)
                line = file.readline()
            except IOError:
                print("IOError")
            while line:
                yield line.strip()
                line = file.readline()
            file.close()
    except ValueError:
        print("Wrong file format!")
