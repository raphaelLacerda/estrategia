def say_hello(nome):
    return f'Olá {nome}, seja bem-vindo!'


def double(L):
    for x in L:
        yield x * 2


if __name__ == "__main__":
    msg = say_hello("Raphael")
    print(msg)
    a = 10
    b = "10" / a

    print(b)


