def test():
    return 'abc', 100

if __name__ == '__main__':
    a = 3
    b = a * 2

    a, b = b, a

    result = test()

    print(result)
    print(result[0])
    print(type(result))

