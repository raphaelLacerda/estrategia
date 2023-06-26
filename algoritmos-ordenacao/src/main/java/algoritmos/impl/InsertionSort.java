package algoritmos.impl;

import algoritmos.Habilitado;
import algoritmos.Ordenador;

@Habilitado
public class InsertionSort extends Ordenador {


    public InsertionSort(boolean impressao) {
        super(impressao);
    }

    protected int[] executarAlgoritmoSort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int elementoBaseEscolhido = array[i];
            int j = i - 1;

            while(j >= 0 && elementoBaseEscolhido < array[j]) {
                int elementoComparado = array[j];
                array[j+1] = elementoComparado;
                j--;
            }
            array[j+1] = elementoBaseEscolhido;
        }

        return array;
    }
}
