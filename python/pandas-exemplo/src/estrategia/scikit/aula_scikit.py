import numpy as np
from sklearn import tree

if __name__ == '__main__':
    print('ola mundo')

    #0 - rugosa
    #1 - lisa
    caracteristicas = [
        [155, 0],
        [180, 0],
        [135, 1],
        [110, 1]
    ]
    # 1 - laranja
    # 0 - maçã
    categorias = [
        [1],
        [1],
        [0],
        [0]
    ]
    # criou a árvore de decisão
    clf = tree.DecisionTreeClassifier()
    # TREINAMENTO
    clf = clf.fit(caracteristicas, categorias)

    # previsões
    print(clf.predict([[150,0]]))
    print(clf.predict([[80,0]]))
    print(clf.predict([[110,0]]))
    print(clf.predict([[30,1]]))
    print(clf.predict([[300,1]]))


