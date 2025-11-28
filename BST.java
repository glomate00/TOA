public class BST {

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    Node root;

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key) node.left = insertRec(node.left, key);
        else node.right = insertRec(node.right, key);

        return node;
    }

    Node minNode(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    Node delete(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) node.left = delete(node.left, key);
        else if (key > node.key) node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node min = minNode(node.right);
            node.key = min.key;
            node.right = delete(node.right, min.key);
        }
        return node;
    }

        void preorder(Node n) {
        if (n == null) return;
        System.out.print(n.key + " ");
        preorder(n.left);
        preorder(n.right);
    }

    void inorder(Node n) {
        if (n == null) return;
        inorder(n.left);
        System.out.print(n.key + " ");
        inorder(n.right);
    }

    void postorder(Node n) {
        if (n == null) return;
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.key + " ");
    }

    void printTree(Node node, int space) {
        if (node == null) return;
        space += 7;

        printTree(node.right, space);

        System.out.println();
        for (int i = 7; i < space; i++) System.out.print(" ");
        System.out.println(node.key);

        printTree(node.left, space);
    }

    public void printFlat(Node node) {
        if (node == null) return;

        String root = String.valueOf(node.key);
        String left = node.left == null ? "null" : String.valueOf(node.left.key);
        String right = node.right == null ? "null" : String.valueOf(node.right.key);

        System.out.println(root + " → L=" + left + ", R=" + right);

        printFlat(node.left);
        printFlat(node.right);
    }

    public static void main(String[] args) {

        BST tree = new BST();
        int[] arr = {28, 76, 27, 10, 5, 35, 95, 16, 33};

        for (int x : arr) tree.insert(x);

        System.out.println("BST:");
        tree.printFlat(tree.root);
    }
}
