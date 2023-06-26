if __name__ == '__main__':
    numero = 42
    tentativas = 0

    while tentativas < 3:
        chute = input('Guess?')
        if chute == numero:
            print('acertou')
        else:
            print('errou')
        tentativas = tentativas + 1


