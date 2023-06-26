import pandas as pd
import numpy as np

if __name__ == '__main__':
    # # s = pd.Series([1, 3, 5, 6, 8])
    # # print(s)
    # # print(s[2])
    # s = pd.Series([1, 3, 5, 6, 8], ["p1", "p2", "p3", "p4", "p5"])
    # print(s)
    # print(s["p3"])
    # print(type(s.to_numpy()))
    # print(s+1)
    #
    # # print(s.median())
    # # print(type(s.array))
    # # print(type(s.to_numpy()))
    #

    concursos = pd.DataFrame({
        'banca': ['cespe', 'cesgranrio'],
        'instituicao': ['tcu', 'bb'],
        'salario': [3000, 20000],
        'data da prova': [pd.to_datetime("20/1/2018"),
                          pd.to_datetime("28/08/2021")]
    })
    #
    print(concursos)
    print(type(concursos))
    print(concursos.dtypes)
    #
    # alunos = [['Raphael', 10, True],
    #         ['Matheus', 4, False],
    #         ['Paula', 5.5, True]]
    #
    # escola = pd.DataFrame(alunos,columns=['nome', 'nota', 'aprovado'])
    #
    # print(escola)

    # y = np.array([[1, 2], [2, 2], [3, 3]])
    # print(np.median(y, axis=0))
