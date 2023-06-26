package estruturadados;

import java.util.PriorityQueue;
import java.util.Queue;

public class Fila {
    public static void main(String[] args) {


        Queue<Integer> senhas = new PriorityQueue<>();



        senhas.add(10);
        senhas.add(30);
        senhas.add(40);




        System.out.println(senhas.peek());
        System.out.println(senhas.poll());
        System.out.println(senhas.size());
    }
}
