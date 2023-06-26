def calcular_idade(data_nascimento):
    idade = 2022 - data_nascimento
    print(f'Sua idade é {idade}')


def multiplicar(a, b):
    return a * b, 'resultado'


if __name__ == '__main__':
    retorno, a = multiplicar(3, 2)
    print('{} é {}'.format(a, retorno))
