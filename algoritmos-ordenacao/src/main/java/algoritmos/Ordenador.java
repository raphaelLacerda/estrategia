package algoritmos;

import main.Principal;

import java.util.Arrays;
import java.util.List;

public abstract class Ordenador {

    private boolean impressao;

    public Ordenador(boolean impressao) {
        this.impressao = impressao;
    }

    public int[] ordenar (int[] array){

        System.out.println(this.getClass().getSimpleName()+" --------------array antes ordenacao-----------------");
        imprimirArray(array);

        long inicio = System.currentTimeMillis();

        int[] executarAlgoritmoSort = this.executarAlgoritmoSort(array);

        long fim = System.currentTimeMillis() - inicio;
        System.out.println("\n"+ this.getClass().getSimpleName()+" - Tempo total em milisegundos: "+ fim);

        System.out.println("\n"+this.getClass().getSimpleName()+" --------------array depois ordenacao-----------------");
        imprimirArray(array);

        System.out.println("\n************************************************************************************");

        return executarAlgoritmoSort;


    }

    protected abstract int[] executarAlgoritmoSort(int[] array);

    private void imprimirArray(int[] array) {

        if(impressao){
            System.out.println(Arrays.toString(array));
        }
    }
}
