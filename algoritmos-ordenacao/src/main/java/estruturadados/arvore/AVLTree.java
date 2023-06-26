package estruturadados.arvore;

// create class ConstructAVLTree for constructing AVL Tree  
public class AVLTree
{  
    private Node rootNode;       
  
    //Constructor to set null value to the rootNode  
    public AVLTree()  
    {  
        rootNode = null;  
    }  
      
    //create removeAll() method to make AVL Tree empty  
    public void removeAll()  
    {  
        rootNode = null;  
    }  
      
    // create checkEmpty() method to check whether the AVL Tree is empty or not  
    public boolean checkEmpty()  
    {  
        if(rootNode == null)  
            return true;  
        else   
            return false;  
    }  
      
    // create insertElement() to insert element to to the AVL Tree  
    public void insertElement(int element)  
    {  
        rootNode = insertElement(element, rootNode);  
    }  
      
    //create getHeight() method to get the height of the AVL Tree  
    private int getHeight(Node node )  
    {  
        return node == null ? -1 : node.h;  
    }  
      
    //create maxNode() method to get the maximum height from left and right node  
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)  
    {  
    return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;  
    }  
      
      
    //create insertElement() method to insert data in the AVL Tree recursively   
    private Node insertElement(int element, Node node)  
    {  
        //check whether the node is null or not  
        if (node == null)  
            node = new Node(element);  
        //insert a node in case when the given element is lesser than the element of the root node  
        else if (element < node.value)  
        {  
            node.left = insertElement( element, node.left );  
            if( getHeight( node.left ) - getHeight( node.right ) == 2 )  
                if( element < node.left.value )  
                    node = rotateWithLeftChild( node );  
                else  
                    node = doubleWithLeftChild( node );  
        }  
        else if( element > node.value )  
        {  
            node.right = insertElement( element, node.right );  
            if( getHeight( node.right ) - getHeight( node.left ) == 2 )  
                if( element > node.right.value)  
                    node = rotateWithRightChild( node );  
                else  
                    node = doubleWithRightChild( node );  
        }  
        else  
            ;  // if the element is already present in the tree, we will do nothing   
        node.h = getMaxHeight( getHeight( node.left ), getHeight( node.right ) ) + 1;  
          
        return node;  
          
    }  
      
    // creating rotateWithLeftChild() method to perform rotation of binary tree node with left child        
    private Node rotateWithLeftChild(Node node2)  
    {  
        Node node1 = node2.left;  
        node2.left = node1.right;  
        node1.right = node2;  
        node2.h = getMaxHeight( getHeight( node2.left ), getHeight( node2.right ) ) + 1;  
        node1.h = getMaxHeight( getHeight( node1.left ), node2.h ) + 1;  
        return node1;  
    }  
  
    // creating rotateWithRightChild() method to perform rotation of binary tree node with right child        
    private Node rotateWithRightChild(Node node1)  
    {  
        Node node2 = node1.right;  
        node1.right = node2.left;  
        node2.left = node1;  
        node1.h = getMaxHeight( getHeight( node1.left ), getHeight( node1.right ) ) + 1;  
        node2.h = getMaxHeight( getHeight( node2.right ), node1.h ) + 1;  
        return node2;  
    }  
  
    //create doubleWithLeftChild() method to perform double rotation of binary tree node. This method first rotate the left child with its right child, and after that, node3 with the new left child  
    private Node doubleWithLeftChild(Node node3)  
    {  
        node3.left = rotateWithRightChild( node3.left );  
        return rotateWithLeftChild( node3 );  
    }  
  
    //create doubleWithRightChild() method to perform double rotation of binary tree node. This method first rotate the right child with its left child and after that node1 with the new right child  
    private Node doubleWithRightChild(Node node1)  
    {  
        node1.right = rotateWithLeftChild( node1.right );  
        return rotateWithRightChild( node1 );  
    }      
  
    //create getTotalNumberOfNodes() method to get total number of nodes in the AVL Tree  
    public int getTotalNumberOfNodes()  
    {  
        return getTotalNumberOfNodes(rootNode);  
    }  
    private int getTotalNumberOfNodes(Node head)  
    {  
        if (head == null)  
            return 0;  
        else  
        {  
            int length = 1;  
            length = length + getTotalNumberOfNodes(head.left);  
            length = length + getTotalNumberOfNodes(head.right);  
            return length;  
        }  
    }  
  
    //create searchElement() method to find an element in the AVL Tree  
    public boolean searchElement(int element)  
    {  
        return searchElement(rootNode, element);  
    }  
  
    private boolean searchElement(Node head, int element)  
    {  
        boolean check = false;  
        while ((head != null) && !check)  
        {  
            int headElement = head.value;  
            if (element < headElement)  
                head = head.left;  
            else if (element > headElement)  
                head = head.right;  
            else  
            {  
                check = true;  
                break;  
            }  
            check = searchElement(head, element);  
        }  
        return check;  
    }  
    // create inorderTraversal() method for traversing AVL Tree in in-order form  
    public void inorderTraversal()  
    {  
        inorderTraversal(rootNode);  
    }  
    private void inorderTraversal(Node head)  
    {  
        if (head != null)  
        {  
            inorderTraversal(head.left);  
            System.out.print(head.value+" ");  
            inorderTraversal(head.right);  
        }  
    }  
  
    // create preorderTraversal() method for traversing AVL Tree in pre-order form  
    public void preorderTraversal()  
    {  
        preorderTraversal(rootNode);  
    }  
    private void preorderTraversal(Node head)  
    {  
        if (head != null)  
        {  
            System.out.print(head.value+" ");  
            preorderTraversal(head.left);               
            preorderTraversal(head.right);  
        }  
    }  
      
    // create postorderTraversal() method for traversing AVL Tree in post-order form  
    public void postorderTraversal()  
    {  
        postorderTraversal(rootNode);  
    }  
      
    private void postorderTraversal(Node head)  
    {  
        if (head != null)  
        {  
            postorderTraversal(head.left);               
            postorderTraversal(head.right);  
            System.out.print(head.value+" ");  
        }  
    }

    @Override
    public String toString() {
        return "AVL{" +
                "root=" + rootNode +
                '}';
    }
}  
