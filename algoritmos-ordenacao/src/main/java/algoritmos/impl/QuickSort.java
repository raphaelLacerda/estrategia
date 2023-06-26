package algoritmos.impl;

import algoritmos.Habilitado;
import algoritmos.Ordenador;


//@Habilitado
public class QuickSort extends Ordenador {


    public QuickSort(boolean impressao) {
        super(impressao);
    }

    protected int[] executarAlgoritmoSort(int[] array) {

        quickSort(array, 0, array.length-1);
        return array;
    }

    public static void quickSort(int[] arr, int start, int end){

        int partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }
}
