import numpy as np
import matplotlib as mpl
import matplotlib.pyplot as plt


import scipy as sp

if __name__ == '__main__':

    x = np.linspace(0, 100, 80)
    # 1 linha, 2 colunas, primeiro plot
    plt.subplot(1,2,1)
    plt.plot([1, 2, 3, 4], [1, 4, 2, 3], label="notas", marker='o', linestyle='dotted', color='r')
    plt.plot([1, 2, 3, 4], [3, 2, 2, 6], label="média geral", marker='o')
    plt.xlabel("eixo x")
    plt.ylabel("eixo y")
    plt.title("Notas e médias")
    plt.legend()
    plt.grid()

    #1 linhas, 2 colunas, 2 grafico
    plt.subplot(1,2,2)
    plt.plot([1, 2, 3, 4], [3, 2, 2, 6], label="média geral", marker='o')
    plt.title("Média Geral")
    # plt.plot(x, label="notas do semestre", marker='o')

    plt.suptitle('ano escolar')
    plt.savefig('linha.png')



    #bar
    # plt.bar(["bacen", "tcu", "bb", "stf"],[10, 20, 30, 40])
    # plt.savefig('bar.png')


    # plt.subplot()
    # plt.pie([1, 2, 3, 4], labels=["bacen", "tcu", "bb", "stf"])
    # plt.savefig('pie.png')