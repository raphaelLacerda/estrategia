package algoritmos.impl;

import algoritmos.Habilitado;
import algoritmos.Ordenador;

/**
 * Pedi para o chatGPT uma implementação
 */
@Habilitado
public class BubbleSort extends Ordenador {

    public BubbleSort(boolean impressao) {
        super(impressao);
    }

    protected int[] executarAlgoritmoSort(int[] array) {
        int n = array.length;
        int temp = 0;

//        boolean flagHouveTroca = false;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                int x = array[j - 1];
                int y = array[j];

                if(x > y){
                    temp = x;
                    array[j-1] = y;
                    array[j] = temp;
//                    flagHouveTroca = true;
                }
            }
//            if(!flagHouveTroca){
//                break;
//            }
        }

        return array;
    }
}
