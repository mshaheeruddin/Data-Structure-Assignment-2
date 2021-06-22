package Q6HeapI;

class Node {
    int key; //key of the node
    Node left; //reference for the left child node
    Node right; //reference for the right child node

    Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

    public class MinHeap {

        public Node root;
        int size = 0;

        public MinHeap() {
            root = null;
            size = 0;
        }

        public void insertAtLeft(int key) {
            Node n = new Node(key);
            Node temp = root;
            if (temp == null) {
                root = n;
            } else {
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = n;
            }
            size++;
        }

        public void insertAtRight(int key) {
            Node n = new Node(key);
            Node temp = root;
            if (temp == null) {
                root = n;
            } else {
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = n;
            }
            size++;
        }
        String str = "";
        public String lessThanKey(int key,Node root) {
            Node tmp = root;
            if (root != null) {
            if (key < root.key) return str;
            str = str.concat(String.valueOf(root.key) + ",");
            lessThanKey(key,root.right);
            lessThanKey(key,root.left); }
            return str;
        }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        //Constructing min heap
        minHeap.root = new Node(2);
        minHeap.root.right = new Node(7);
        minHeap.root.left = new Node(6);
        minHeap.root.left.left = new Node(9);
        minHeap.root.left.right = new Node(12);
        minHeap.root.right.left= new Node(11);
        minHeap.root.right.right = new Node(14);


        System.out.println(minHeap.lessThanKey(11,minHeap.root));



    }
}
