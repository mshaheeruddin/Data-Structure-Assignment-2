package Q3LCA;

    class BinaryTree {
        public static class Node {
            int key; //key of the node
            Node left; //reference for the left child node
            Node right; //reference for the right child node

            Node(int key) {
                this.key = key;
                this.left = null;
                this.right = null;
            }
        }

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

        public Node LCA(int keyOfv, int keyOfw) {
            return LCA(root, keyOfv, keyOfw);
        }

        private Node LCA(Node node, int vKey, int wKey) {
            if (node == null) return null;
            if (node.key == vKey || node.key == wKey) {
                return node;
            }
            //LeftTraversal
            Node leftTraversal = LCA(node.left, vKey, wKey);
            //RightTraversal
            Node rightTraversal = LCA(node.right, vKey, wKey);

            if (leftTraversal != null && rightTraversal != null)
                return node;

            return (leftTraversal != null) ? leftTraversal : rightTraversal;

        }
    }

    public class LowestCommonAncestor {
        public static void main(String[] args) {
            /*


             Running Time: O(n)


             */





            BinaryTree bt = new BinaryTree();
            bt.root = new BinaryTree.Node(1);
            bt.root.right = new BinaryTree.Node(3);
            bt.root.left = new BinaryTree.Node(2);
            bt.root.left.left = new BinaryTree.Node(4);
            bt.root.left.right = new BinaryTree.Node(5);
            bt.root.right.left = new BinaryTree.Node(6);
            bt.root.right.right = new BinaryTree.Node(7);

            System.out.println(bt.LCA(4,6).key);
        }
    }





