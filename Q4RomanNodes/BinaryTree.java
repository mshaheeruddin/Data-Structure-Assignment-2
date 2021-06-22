package Q4RomanNodes;
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

    public class BinaryTree {

        public Node root;
        int size = 0;

        public BinaryTree() {
            root = null;
            size = 0;
        }

        public boolean isEmpty() {
            if (size == 0) return true;
            return false;
        }


        public int Traversal(Node root) {
           if (root == null) return 0;
           return Traversal(root.left) + Traversal(root.right) + 1;
        }


        public boolean isRoman(Node v) {
            if (v != null) {

            if (Math.abs(Traversal(v.left) - Traversal(v.right)) <= 5) return true; }

            return false;

        }
        public boolean isNotRomanButDescendantsAre(Node root) {
            boolean flag = false;

            if (!isRoman(root)) {

                  if (root.right == null) { flag = true; }
                           flag = isRoman(root.right);
                  if (root.left == null) { flag = true; }
                           else flag = isRoman(root.left);
            }
            return flag;
        }

            public static void main(String[] args) {
            BinaryTree bt = new BinaryTree();
            bt.root = new Node(1);
            bt.root.right = new Node(3);
            bt.root.left = new Node(2);
            bt.root.left.left = new Node (4);
            bt.root.left.right = new Node (5);
           // bt.root.right.left = new Node (6);
            bt.root.right.right = new Node (7);
            //bt.root.right.left.left = new Node (10);
            bt.root.left.right.right = new Node (9);
            bt.root.left.left.right = new Node (8);
            bt.root.right.right.right = new Node (11);
            bt.root.right.right.right.left = new Node (12);
            bt.root.right.right.right.right = new Node (13);
            bt.root.right.right.right.right.left = new Node (16);
            bt.root.right.right.right.left.right = new Node (17);




                System.out.println("Is the root roman?: "+bt.isRoman(bt.root.right));
                System.out.println("Is it's descendants roman? : "+ bt.isNotRomanButDescendantsAre(bt.root.right));





            }

    }
