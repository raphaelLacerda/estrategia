if __name__ == '__main__':
    palavra_secreta = input('qual será a palavra?')
    chutes_corretos = []
    chutes_errados = []

    maximo_tentativas = len(palavra_secreta)
    total_tentativas = 0

    for x in range(0, maximo_tentativas):
        chutes_corretos.append('_')

    print(chutes_corretos)

    finalizou = False

    while total_tentativas <= maximo_tentativas and not finalizou:
        print('Chutes errados: {}'.format(chutes_errados))
        print('Chutes corretos: {}'.format(chutes_corretos))
        print(f'total de tentativas {total_tentativas}/{maximo_tentativas}')
        chute = input('Qual letra?')
        acertou = False
        posicao = 0
        for letra in palavra_secreta:
            if letra == chute:
                chutes_corretos[posicao] = letra
                acertou = True
            posicao = posicao + 1

        if not acertou:
            chutes_errados.append(chute)
        total_tentativas += 1
        finalizou = '_' not in chutes_corretos

    print(chutes_corretos)
    print(chutes_errados)
