public class RBT {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int key;
        boolean color;
        Node left, right, parent;

        Node(int key) {
            this.key = key;
            this.color = RED;
        }
    }

    private Node root;

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null)
            y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;

        if (y.right != null)
            y.right.parent = x;

        y.parent = x.parent;

        if (x.parent == null)
            root = y;
        else if (x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;

        y.right = x;
        x.parent = y;
    }

    private Node bstInsert(Node root, Node node) {
        if (root == null) return node;

        if (node.key < root.key) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }

        return root;
    }

    public void insert(int key) {
        Node node = new Node(key);
        root = bstInsert(root, node);
        fixInsert(node);
    }

    private void fixInsert(Node node) {
        while (node != root && node.parent.color == RED) {

            Node parent = node.parent;
            Node grand = parent.parent;

            if (parent == grand.left) {

                Node uncle = grand.right;

                if (uncle != null && uncle.color == RED) {
                    grand.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grand;
                }
                else {
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                    }
                    rotateRight(grand);
                    parent.color = BLACK;
                    grand.color = RED;
                }

            } else {

                Node uncle = grand.left;

                if (uncle != null && uncle.color == RED) {
                    grand.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grand;
                }
                else {
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                    }
                    rotateLeft(grand);
                    parent.color = BLACK;
                    grand.color = RED;
                }
            }
        }

        root.color = BLACK;
    }

    public void printTree(Node node, int space) {
        if (node == null) return;

        space += 7;
        printTree(node.right, space);

        System.out.println();
        for (int i = 7; i < space; i++) System.out.print(" ");
        System.out.print(node.key + (node.color ? "(R)" : "(B)"));

        printTree(node.left, space);
    }

    public void printFlat(Node node) {
        if (node == null) return;

        String root = node.key + (node.color ? "(R)" : "(B)");
        String left = node.left == null ? "null" : node.left.key + (node.left.color ? "(R)" : "(B)");
        String right = node.right == null ? "null" : node.right.key + (node.right.color ? "(R)" : "(B)");

        System.out.println(root + " → L=" + left + ", R=" + right);

        printFlat(node.left);
        printFlat(node.right);
    }

    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {

        RedBlackTree rbt = new RedBlackTree();
        int[] arr = {28, 76, 27, 10, 5, 35, 95, 16, 33};

        for (int x : arr) rbt.insert(x);
        System.out.println("RBT:");
        rbt.printFlat(rbt.getRoot());
    }
}
