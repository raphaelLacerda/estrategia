package estruturadados.arvore;


/**
 * https://www.baeldung.com/java-binary-tree
 */
public class MainTree {

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        AVLTree avl = new AVLTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);


        avl.insertElement(6);
        avl.insertElement(4);
        avl.insertElement(8);
        avl.insertElement(3);
        avl.insertElement(5);
        avl.insertElement(7);
        avl.insertElement(9);


        System.out.println(bt);
        System.out.println(bt.containsNode(9));
        System.out.println(avl);
        System.out.println(avl.searchElement(9));

    }
}
