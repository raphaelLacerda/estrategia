import datetime
if __name__ == '__main__':
    today = datetime.datetime.now()

    # legível
    print(str(today))

    # official format / debuggable
    print(repr(today))