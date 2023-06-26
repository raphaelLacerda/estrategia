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

def plot_image(i, predictions_array, true_label, img):
  true_label, img = true_label[i], img[i]
  plt.grid(False)
  plt.xticks([])
  plt.yticks([])

  plt.imshow(img, cmap=plt.cm.binary)

  predicted_label = np.argmax(predictions_array)
  if predicted_label == true_label:
    color = 'blue'
  else:
    color = 'red'

  plt.xlabel("{} {:2.0f}% ({})".format(class_names[predicted_label],
                                100*np.max(predictions_array),
                                class_names[true_label]),
                                color=color)

def plot_value_array(i, predictions_array, true_label):
  true_label = true_label[i]
  plt.grid(False)
  plt.xticks(range(10))
  plt.yticks([])
  thisplot = plt.bar(range(10), predictions_array, color="#777777")
  plt.ylim([0, 1])
  predicted_label = np.argmax(predictions_array)

  thisplot[predicted_label].set_color('red')
  thisplot[true_label].set_color('blue')

if __name__ == '__main__':
    fashion_mnist = tf.keras.datasets.fashion_mnist
    (train_images, train_labels), (test_images, test_labels) = fashion_mnist.load_data()

    #numpy array
    print(len(train_labels))
    print(len(test_labels))

    class_names = ['T-shirt/top', 'Trouser', 'Pullover', 'Dress', 'Coat',
               'Sandal', 'Shirt', 'Sneaker', 'Bag', 'Ankle boot']

    #The images are 28x28 NumPy arrays,
    print(train_images[0])
    print(train_images.shape)
    print(train_images.ndim)

    # mostrar imagem scala 255
    mostrar_imagem(train_images[1])

    # The data must be preprocessed before training the network.

    # Scale these values to a range of 0 to 1 before feeding them to the neural network model
    train_images = train_images / 255.0
    test_images = test_images / 255.0

    # mostrar_imagem(train_images[1])

    plt.figure(figsize=(10, 10))
    for i in range(25):
        plt.subplot(5, 5, i + 1)
        plt.xticks([])
        plt.yticks([])
        plt.grid(False)
        plt.imshow(test_images[i], cmap=plt.cm.binary)
        plt.xlabel(class_names[test_labels[i]])
    plt.show()



    # Construindo a rede neural
    # The basic building block of a neural network is the layer
    # Extraem informações significativas dos dados
    # Torceremos para essas informações serem significativas

    model = tf.keras.Sequential([
        tf.keras.layers.Flatten(input_shape=(28, 28)),
        tf.keras.layers.Dense(128, activation='relu'),
        tf.keras.layers.Dense(10)
    ])

    # Flatten transformar a imagem bidimensional 28 por 28 em unidimensional - 784 pixels
    # This layer has no parameters to learn; it only reformats the data.
    # ------------------------------------

    # Second layers - DENSE
    # The first Dense layer has 128 nodes (or neurons).
    # Each node contains a score that indicates the current image belongs to one of the 10 classes.
    #_______-------------------

    # Third Layer
    # layer returns a function that maps probabilities  array with length of 10. E


    #----------------------------

    # Agora a rede neural precisa treinar
    # mas antes precisa ser configurado

    model.compile(optimizer='adam',
                  loss=tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
                  metrics=['accuracy'])

    model.fit(train_images, train_labels, epochs=10)

    # avaliando sem treinar
    # Verificar que a precisão está horrivel

    test_loss, test_acc = model.evaluate(test_images, test_labels, verbose=2)
    print('\nTest accuracy:', test_acc)

    probability_model = tf.keras.Sequential([model,
                                             tf.keras.layers.Softmax()])
    predictions = probability_model.predict(test_images)

    # eu jurava q era um snekear e a rede neural ja sabia melhor do que eu que era uma ankle boot
    mostrar_imagem(test_images[0])

    # Traz uma probabilidade de qual categoria é aquela figura
    print(predictions[0])
    print(np.argmax(predictions[0]))
    # 13% que é um tenis
    # 14% que é uma BAG!! quando nao esta treinada

    print(predictions[9])
    # which label has the highest confidence value:
    print(np.argmax(predictions[9]))

    print(class_names)

    # Treinando o modelo

    # model.fit(train_images, train_labels, epochs=10)



