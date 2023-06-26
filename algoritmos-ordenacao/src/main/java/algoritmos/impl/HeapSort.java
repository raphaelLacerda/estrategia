package algoritmos.impl;

import algoritmos.Habilitado;
import algoritmos.Ordenador;


//@Habilitado
public class HeapSort extends Ordenador {


    public HeapSort(boolean impressao) {
        super(impressao);
    }

    protected int[] executarAlgoritmoSort(int[] array) {

        int tamanho = array.length;
        int i = tamanho / 2, pai, filho, t;
        while (true) {
            if (i > 0) {
                i--;
                t = array[i];
            } else {
                tamanho--;
                if (tamanho <= 0) {
                    return array;
                }
                t = array[tamanho];
                array[tamanho] = array[0];
            }
            pai = i;
            filho = ((i * 2) + 1);
            while (filho < tamanho) {
                if ((filho + 1 < tamanho) && (array[filho + 1] > array[filho])) {
                    filho++;
                }
                if (array[filho] > t) {
                    array[pai] = array[filho];
                    pai = filho;
                    filho = pai * 2 + 1;
                } else {
                    break;
                }
            }
            array[pai] = t;
        }
    }

}

