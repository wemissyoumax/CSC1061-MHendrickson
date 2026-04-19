
public class Treeset<T extends Comparable<T>> {

    private Node<T> root;


    public Treeset() {
        root = null;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    public int height() {
        return height(root);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        int cmp = value.compareTo(node.data);

        if (cmp < 0) {
            node.left = insert(node.left, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }

        updateHeight(node);

        return rebalance(node);
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null) {
            return false; 
        }

        int cmp = value.compareTo(node.data);

        if (cmp < 0) {
            return contains(node.left, value);
        } else if (cmp > 0) {
            return contains(node.right, value);
        } else {
            return true;
        }
    }

    private int height(Node<T> node) {
        return (node == null) ? 0 : node.height;
    }

    private void updateHeight(Node<T> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int balanceFactor(Node<T> node) {
        return height(node.left) - height(node.right);
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> B = x.right;

        x.right = y;
        y.left  = B;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.right;
        Node<T> B = y.left;

        y.left  = x;
        x.right = B;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private Node<T> rebalance(Node<T> node) {
        int balance = balanceFactor(node);
        if (balance > 1) {
            if (balanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }

        if (balance < -1) {
            if (balanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }

        return node;
    }
}