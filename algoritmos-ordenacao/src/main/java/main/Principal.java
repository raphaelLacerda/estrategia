package main;

import helper.Executor;
import helper.Gerador;

public class Principal {

    public static void main(String[] args) {

//        Gerador gerador = new Gerador(500);
//        Gerador gerador = new Gerador(100_000);
        Gerador gerador = new Gerador(500_000);
        Executor executor = new Executor(false);

        System.out.println("====================PIOR CASO================");
        executor.executarTodosAlgoritmos(gerador.gerarElementosFixosPiorCaso());

        System.out.println("====================CASO MEDIO================");
        executor.executarTodosAlgoritmos(gerador.gerarElementosAleatorios());

        System.out.println("====================MELHOR CASO================");
        executor.executarTodosAlgoritmos(gerador.gerarElementosFixosMelhorCasoJaOrdenados());


//
        System.out.println("\n\n\n");

    }





}
