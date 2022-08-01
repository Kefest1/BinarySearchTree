import java.util.LinkedList;

public class BinarySearchTree<T> {
    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;

    MyData<T> root;
    private int size = 0;

    public BinarySearchTree() {

    }

    public BinarySearchTree(MyData<T> root) {
        size = 1;
        this.root = root;
    }


    public void insertNode(T data, int key) throws KeyIsAlreadyTaken {
        if (size == 0)
            root = new MyData<>(data, key);
        else {
            var buffer = root;
            var buf = buffer;

            while (buffer != null) {
                if (buffer.key == key) throw new KeyIsAlreadyTaken();
                buf = buffer;
                buffer = buffer.key < key ?
                        buffer.right : buffer.left;
            }

            if (buf.key < key)
                buf.right = new MyData<>(data, key);
            else buf.left = new MyData<>(data, key);
        }
        size++;
    }

    private MyData<T> getNode(int key) {
        if (size == 0) return null;
        var buffer = root;
        var buf = root;

        while (buffer != null) {
            buf = buffer;
            if (buffer.key == key) return buffer;
            buffer = buffer.key < key ?
                    buffer.right : buffer.left;
        }

        if (buf.key == key)
            return buf;
        return null;
    }

    public T getData(int key) {
        try {
            return getNode(key).getData();
        } catch (Exception NullPointerException) {
            return null;
        }
    }

    public boolean containsKey(int key) {
        var buffer = root;

        while (buffer != null) {
            if (buffer.key == key) return true;
            buffer = buffer.key < key
                    ? buffer.right : buffer.left;
        }

        return false;
    }

    public T removeNode(int key) {
        if (size == 0) return null;
        var buffer = root;
        var buf = root;

        while (buffer != null) {
            if (buffer.key == key) break;
            buf = buffer;
            buffer = buffer.key < key ?
                    buffer.right : buffer.left;
        }

        if (buffer == null) return null;

        if (buffer.left == null && buffer.right == null) {
            if (buf.left == buffer)
                buf.left = null;
            else buf.right = null;
        } else if (buffer.right != null && buffer.left != null) {
            var save = buffer;
            buffer = buffer.right;

            while (buffer.left != null)
                buffer = buffer.left;
            removeNode(buffer.key);

            buffer.left = save.left;
            buffer.right = save.right;
            if (buf.left == save)
                buf.left = buffer;
            else buf.right = save;
        } else {
            if (buffer.left == null) {
                if (buf.left == buffer)
                    buf.left = buffer.right;
                else buf.right = buffer.right;
            } else {
                if (buf.left == buffer)
                    buf.left = buffer.left;
                else buf.right = buffer.left;
            }
        }

        size--;
        return buffer.getData();
    }

    public int findMaxKey() {
        if (size == 0)
            return Integer.MAX_VALUE;
        var ret = root;
        while (ret.right != null)
            ret = ret.right;
        return ret.key;
    }

    public int findMinKey() {
        if (size == 0)
            return Integer.MIN_VALUE;
        var ret = root;
        while (ret.left != null)
            ret = ret.left;
        return ret.key;
    }



    public int treeHeight() {
        return treeHeight(root);
    }

    private int treeHeight(MyData<T> data) {
        if (data == null) return 0;
        int leftHeight = treeHeight(data.left);
        int rightHeight = treeHeight(data.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(MyData<T> at) {
        if (at != null) {
            inorder(at.left);
            System.out.print(at.getData().toString() + " ");
            inorder(at.right);
        }
    }

    public void inorderReverse() {
        inorderReverse(root);
        System.out.println();
    }

    private void inorderReverse(MyData<T> at) {
        if (at != null) {
            inorderReverse(at.right);
            System.out.print(at.getData().toString() + " ");
            inorderReverse(at.left);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(MyData<T> at) {
        if (at != null) {
            System.out.print(at.getData().toString() + " ");
            preorder(at.left);
            preorder(at.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(MyData<T> at) {
        if (at != null) {
            postorder(at.left);
            postorder(at.right);
            System.out.print(at.getData().toString() + " ");
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedList<T> treeToList(int order) {
        LinkedList<T> list = new LinkedList<>();
        if (order == ASCENDING)
            treeToListAscending(list, root);
        else treeToListDescending(list, root);

        return list;
    }

    private void treeToListAscending(LinkedList<T> list, MyData<T> at) {
        if (at != null) {
            treeToListAscending(list, at.left);
            list.addLast(at.data);
            treeToListAscending(list, at.right);
        }
    }

    private void treeToListDescending(LinkedList<T> list, MyData<T> at) {
        if (at != null) {
            treeToListDescending(list, at.right);
            list.addLast(at.data);
            treeToListDescending(list, at.left);
        }
    }
}
