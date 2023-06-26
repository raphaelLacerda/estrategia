if __name__ == '__main__':
    quantidade_maxima = 3
    numero_magico = 42
    tentativas = 0
    acertou = False

    while tentativas < quantidade_maxima and not acertou:

        numero_informado = input('Qual é o número que estou pensado? ')
        numero_informado = int(numero_informado)
        if numero_magico == numero_informado:
            print("ACERTOU! CAMPEAO")
            acertou = True
        elif numero_magico > numero_informado:
            print("aumente seu palpite ai")
        else:
            print("diminua seu palpiltao ai")

        tentativas = tentativas + 1

    print("finalizou o programa1")
