if __name__ == '__main__':
    palavra_secreta = input("Informe por favor a palavra secreta: ")
    gabarito = []
    chutes_errados = []

    tamanho_palavra = len(palavra_secreta)
    for x in range(tamanho_palavra):
        gabarito.append('_')

    maximo_tentativas = tamanho_palavra + 1
    total_tentativas = 0

    finalizou = False

    while total_tentativas < maximo_tentativas and not finalizou:
        print(f"o seu gabarito é {gabarito}")
        print(f"os chutes errados foram {chutes_errados}")
        chute = input("Qual letra? => ")
        posicao = 0
        acertou = False

        for letra in palavra_secreta:
            if letra == chute:
                gabarito[posicao] = letra
                acertou = True
            posicao = posicao + 1

        if not acertou:
            chutes_errados.append(chute)

        total_tentativas += 1
        finalizou = '_' not in gabarito

    print(f"o seu gabarito é {gabarito}")
    print(f"os chutes errados foram {chutes_errados}")
    if finalizou:
        print("PARABENS")
    else:
        print("DEU MOLE")
