from tensorflow import keras
import tensorflow as tf
from tensorflow import keras
import numpy as np
import matplotlib.pyplot as plt


def mostrar_imagem(image):
    plt.figure()
    plt.imshow(image)
    plt.colorbar()
    plt.grid(False)
    plt.show()


if __name__ == '__main__':
    fashion = tf.keras.datasets.fashion_mnist
    # recuperando os dados da base
    (train_images, train_labels), (test_images, test_labels) = fashion.load_data()
    # print(train_labels.size)
    # print(test_labels[0])

    # categorias por posicoes
    class_names = ['T-shirt/top', 'Trouser', 'Pullover', 'Dress', 'Coat',
                   'Sandal', 'Shirt', 'Sneaker', 'Bag', 'Ankle boot']

    # mostrar_imagem(train_images[1])
    # print(train_labels[1])

    # colocando todos na mesma escala
    train_images = train_images / 255.0
    test_images = test_images / 255.0

    # mostrar_imagem(train_images[1])
    #
    #
    # plt.figure(figsize=(10, 10))
    # for i in range(25):
    #     plt.subplot(5, 5, i + 1)
    #     plt.xticks([])
    #     plt.yticks([])
    #     plt.grid(False)
    #     plt.imshow(test_images[i], cmap=plt.cm.binary)
    #     plt.xlabel(class_names[test_labels[i]])
    # plt.show()

    # construir uma rede neural
    # extrair informações signifcativas (características e aprendizado)
    # LAYERS

    model = keras.Sequential([
        # transformando bidimensional para uni = 28*28 = 784 (pixel)
        keras.layers.Flatten(input_shape=(28, 28)),
        # 128 neurons - cada um possui um score para classificar
        # a categoria da imagem
        keras.layers.Dense(128, activation='relu'),
        keras.layers.Dense(10)
    ])

    # configuração do treinamento

    model.compile(optimizer='adam',
                  loss=tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
                  metrics=['accuracy'])

    # treinamento e avaliacao

    # model.fit(train_images, train_labels, epochs=10)

    test_loss, test_precisao = model.evaluate(test_images, test_labels, verbose=2)
    print(f'teste de precisao {test_precisao}')

    # probabilidade de qual categoria é uma imagem

    probabilidades = keras.Sequential([
        model, keras.layers.Softmax()
    ])

    previsoes = probabilidades.predict(test_images)

    # a saída deveria ser 7 - SNEAKER ( EU - HUMANO - PENSADO)
    # MAS a saída deu que 86% - 9 - ankle boot (MAQUINA MAIS PRECISA QUE o HUMANO)
    # print(previsoes[0])
    # print(np.argmax(previsoes[0]))

    mostrar_imagem(test_images[9])
    print(previsoes[9])
    print(np.argmax(previsoes[9]))