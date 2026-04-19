
public class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;
    int height;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}
