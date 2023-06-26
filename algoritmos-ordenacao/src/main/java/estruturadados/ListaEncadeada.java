package estruturadados;

import java.util.LinkedList;

public class ListaEncadeada {

    public static void main(String[] args) {


        LinkedList<Integer> numeros = new LinkedList<>();

        numeros.add(1);
        numeros.add(10);
        numeros.add(20);


        System.out.println(numeros.getLast());
        System.out.println(numeros.getFirst());

    }
}
