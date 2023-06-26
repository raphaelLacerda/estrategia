import pandas as pd
import numpy as np


if __name__ == '__main__':
    dados = pd.read_csv('concursos.csv', ';')
    # print(dados)
    #
    # print("----------------")
    #
    # print(type(dados))
    # print(dados.info())
    # print(dados.dtypes)
    # print(dados.shape)

    # salarios = dados['salario']
    #
    # print( salarios )
    # print(salarios.median())
    #
    bancas = dados['banca']
    # bancas.drop_duplicates(inplace=True)
    # # print(type(bancas))
    # # print(bancas.index)
    bancas = bancas.append(pd.Series(['fgv'], index=['novo']))
    print(bancas)
    #
    print(bancas.isin(dados['banca']))


    # selecionando mais de uma coluna
    #
    # resumo = dados[['banca', 'instituicao']]
    #
    # print(resumo)