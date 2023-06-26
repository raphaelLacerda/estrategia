package algoritmos.impl;

import algoritmos.Habilitado;
import algoritmos.Ordenador;


//@Habilitado
public class ShellSort extends Ordenador {


    public ShellSort(boolean impressao) {
        super(impressao);
    }

    protected int[] executarAlgoritmoSort(int[] array) {

        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > key) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
        }

        return array;
    }
}
