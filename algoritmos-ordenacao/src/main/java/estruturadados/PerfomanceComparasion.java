package estruturadados;

import estruturadados.arvore.AVLTree;
import estruturadados.arvore.BinaryTree;

import java.util.*;

public class PerfomanceComparasion {

    public static void main(String[] args) {

        //https://www.geeksforgeeks.org/difference-between-list-set-and-map-in-java/
        compareSetvsList();
        //https://stackoverflow.com/questions/10799417/performance-and-memory-allocation-comparison-between-list-and-set
        //https://stackoverflow.com/questions/10656471/performance-differences-between-arraylist-and-linkedlist
        //https://www.baeldung.com/java-choose-list-set-queue-map
        //https://www.baeldung.com/java-arraylist-vs-linkedlist-vs-hashmap
    }

    private static void compareSetvsList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> treeset = new TreeSet<>();
        Set<Integer> linkedSet = new TreeSet<>();

        BinaryTree binaryTree = new BinaryTree();
        AVLTree avl = new AVLTree();

        System.out.println("Setting values in list and set .... ");
//        int counter = 10_000_000;
//        int counter = 1_000_000;
        int counter = 100_000;
//        int counter = 30_000;

        System.out.println("Checking time Adding LIST.... ");
        long t = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            list.add(i);
        }
        long f = System.currentTimeMillis();
        System.out.println(" time taken : " + (f - t));

        System.out.println("Checking time Adding Linked.... ");
        t = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            linkedList.add(i);
        }
        f = System.currentTimeMillis();
        System.out.println(" time taken : " + (f - t));


        System.out.println("Checking time Adding Binary Tree.... ");
        t = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            binaryTree.add(i);
        }
        f = System.currentTimeMillis();
        System.out.println(" time taken : " + (f - t));


        System.out.println("Checking time Adding AVL Tree.... ");
        t = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            avl.insertElement(i);
        }
        f = System.currentTimeMillis();
        System.out.println(" time taken : " + (f - t));



        System.out.println("Checking time Adding SET.... ");
        t = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            set.add(i);
        }
        f = System.currentTimeMillis();
        System.out.println(" time taken : " + (f - t));


        System.out.println("Checking time Adding TREESET.... ");
        t = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            treeset.add(i);
        }
        f = System.currentTimeMillis();
        System.out.println(" time taken : " + (f - t));


        System.out.println("Checking time Adding LinkedHashSet.... ");
        t = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            linkedSet.add(i);
        }
        f = System.currentTimeMillis();
        System.out.println(" time taken : " + (f - t));


        System.out.println("Checking time SEARCHING LIST.... ");
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) list.contains(i);
        long l2 = System.currentTimeMillis();
        System.out.println(" time taken for list : " + (l2 - l1));


        System.out.println("Checking time SEARCHING LinkedList.... ");
        l1 = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) linkedList.contains(i);
        l2 = System.currentTimeMillis();
        System.out.println(" time taken  : " + (l2 - l1));


        System.out.println("Checking time SEARCHING binaryTree.... ");
        l1 = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) binaryTree.containsNode(i);
        l2 = System.currentTimeMillis();
        System.out.println(" time taken  : " + (l2 - l1));


        System.out.println("Checking time SEARCHING AVL Treee.... ");
        l1 = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) avl.searchElement(i);
        l2 = System.currentTimeMillis();
        System.out.println(" time taken  : " + (l2 - l1));


        System.out.println("Checking time SEARCHING HashSet.... ");
        l1 = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) set.contains(i);
        l2 = System.currentTimeMillis();
        System.out.println(" time taken for set : " + (l2-l1));

        System.out.println("Checking time SEARCHING TreeSet.... ");
        l1 = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) treeset.contains(i);
        l2 = System.currentTimeMillis();
        System.out.println(" time taken : " + (l2-l1));

        System.out.println("Checking time SEARCHING LinkedSet.... ");
        l1 = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) linkedSet.contains(i);
        l2 = System.currentTimeMillis();
        System.out.println(" time taken  : " + (l2-l1));


    }
}
