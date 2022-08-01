import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();


        try {
            binarySearchTree.insertNode(8, 8);
            binarySearchTree.insertNode(3, 3);
            binarySearchTree.insertNode(10, 10);
            binarySearchTree.insertNode(1, 1);
            binarySearchTree.insertNode(6, 6);
            binarySearchTree.insertNode(14, 14);
            binarySearchTree.insertNode(4, 4);
            binarySearchTree.insertNode(7, 7);
            binarySearchTree.insertNode(13, 13);
        }
        catch (Exception KeyIsAlreadyTaken) {
            System.out.println("Key has to be unique");
        }

        System.out.println(binarySearchTree.treeToList(BinarySearchTree.ASCENDING));
        System.out.println(binarySearchTree.treeToList(BinarySearchTree.DESCENDING));
    }
}
