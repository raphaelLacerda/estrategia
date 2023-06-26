package helper;

import java.util.Random;

public class Gerador {

    private int tamanho;

    public Gerador(int tamanho) {
        this.tamanho = tamanho;
    }

    public int[] gerarElementosFixosPiorCaso() {

        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = tamanho - i;
        }
        return array;
    }

    public int[] gerarElementosFixosMelhorCasoJaOrdenados() {

        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = i;
        }
        return array;
    }

    public int[] gerarElementosAleatorios() {

        int[] array = new int[tamanho];

        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {

            array[i] = random.nextInt(10000);
        }
        return array;
    }
}
