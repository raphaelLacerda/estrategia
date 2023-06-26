import numpy as np
import sklearn.model_selection as model_selection
from sklearn import preprocessing, neighbors
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split

import pandas as pd
from sklearn import tree

if __name__ == '__main__':
    # features = [[155, "rough"], [180, "rough"], [135, "smooth"], [110, "smooth"]]
    # labels = ["orange", "orange", "apple", "apple"]

    # scikit trabalha melhor com numeros
    features = [[155, 0], [180, 0], [135, 1], [110, 1]]
    labels = [1, 1, 0, 0]

    clf = tree.DecisionTreeClassifier()

    # At this point, the classifier is just an empty box of rules
    # since it continues to be unaware of apples or oranges.

    # To train it, we'll need a learning algorithm.

    clf = clf.fit(features, labels)

    # vai mudando os valores q ele vai mudando o aprendizado
    print(clf.predict([[150, 0]]))
    print(clf.predict([[80, 0]]))
    print(clf.predict([[100, 1]]))



