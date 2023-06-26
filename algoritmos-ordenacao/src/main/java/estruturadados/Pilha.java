package estruturadados;

import java.util.Stack;

/**
 * Nao esquece de falar do problema da heranca
 */
public class Pilha {
    public static void main(String[] args) {

        Stack<String> nomes = new Stack<>();

        nomes.push("rafa");
        nomes.push("matheus");
        nomes.push("ricardo");
        nomes.push("guilherme");

        System.out.println(nomes.pop());
    }
}
