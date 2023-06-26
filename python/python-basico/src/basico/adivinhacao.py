if __name__ == '__main__':
    numero = 42
    chute = input('Guess?')
    if chute == numero:
        print('acertou')
    else:
        print('errou')

    print(type(chute))
    chute = int(chute)
    print(type(chute))

