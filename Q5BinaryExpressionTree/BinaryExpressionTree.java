package Q5BinaryExpressionTree;

import java.util.ArrayList;
import java.util.Scanner;


public class BinaryExpressionTree extends StackAsArray {
    class Node {
        String key;
        Node left; //reference for the left child node
        Node right; //reference for the right child node

        Node(String key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }

        public void setNode(String key) {
            this.key = key;
        }
    }

    public Node root;
    int size = 0;

    public BinaryExpressionTree() {
        root = null;
        size = 0;
    }

    public void insertAtLeft(String key) {
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

    public void insertAtRight(String key) {
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

    public void insertNodeAtRight(Node node) {
        Node temp = root;
        if (temp == null) {
            root = node;
        } else {
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = node;
        }
        size++;
    }

    public void insertNodeAtLeft(Node node) {
        Node temp = root;
        if (temp == null) {
            root = node;
        } else {
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = node;
        }
        size++;
    }

    public boolean isOperator(char exp) {
        if (exp == '+' || exp == '-' || exp == '/' || exp == '*') return true;
        return false;
    }

    public boolean isOperand(char exp) {
        if (exp != '+' && exp != '-' && exp != '/' && exp != '*' && exp != ')' && exp != ')') return true;
        return false;
    }

    public void inOrderTrav(Node root) {
        if (root != null) {
            inOrderTrav(root.left);
            System.out.print(root.key + " ");
            inOrderTrav(root.right);
        }

    }
    String preFix = "";

    public String preOrderTrav(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preFix = preFix.concat(root.key + " ");
            preOrderTrav(root.left);
            preOrderTrav(root.right);
        }
        return preFix;
    }
    String postFix = "";
    public String postOrderTrav(Node root) {
        if (root != null) {
            postOrderTrav(root.left);
            postOrderTrav(root.right);
            postFix = postFix.concat(root.key + " ");

        }
        return postFix;
    }

    public double pfEvaluation(String seq) {

        String[] newStr = new String[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            newStr = seq.split(" ");
        }

        for (int i = 0; i < newStr.length; i++) {
            if (!newStr[i].equals("+") && !newStr[i].equals("-") && !newStr[i].equals("/") && !newStr[i].equals("*")) {
                push(Double.parseDouble(String.valueOf(newStr[i])));
            } else if (newStr[i].equals("+")) {
                double num1 = Double.parseDouble(String.valueOf(pop()));
                double num2 = Double.parseDouble(String.valueOf(pop()));
                push(num1 + num2);
            } else if (newStr[i].equals("-")) {
                double  num1 = Double.parseDouble(String.valueOf(pop()));
                double   num2 = Double.parseDouble(String.valueOf(pop()));
                push(Math.abs(num1 - num2));
            } else if (newStr[i].equals("/")) {
                double num1 = Double.parseDouble(String.valueOf(pop()));
                double num2 = Double.parseDouble(String.valueOf(pop()));
                if (num1 > num2) push(num1 / num2);
                else push(num2 / num1);
            } else if (newStr[i].equals("*")) {
                double num1 = Double.parseDouble(String.valueOf(pop()));
                double num2 = Double.parseDouble(String.valueOf(pop()));
                push(num2 * num1);
            }
        }
        System.out.println();
        System.out.println("Evaluating this expression...... Answer is: ");

        return Double.parseDouble(String.valueOf(pop()));
    }


     int index = 0;
    public void constructTree(String exp) {
             String pfExp = convertToPostfix(exp);
             for (int i =0;i<pfExp.length();i++) {
                 if(isOperand(pfExp.charAt(i))) push(String.valueOf(pfExp.charAt(i)));
                 else if(isOperator(pfExp.charAt(i))) {
                     index = i;
                     root = new Node(String.valueOf(pfExp.charAt(i)));
                     if (i != pfExp.length()-1) {
                     insertAtRight(String.valueOf(pop()));
                     insertAtLeft(String.valueOf(pop()));}
                     else {
                         try {
                             insertNodeAtRight(popNode());
                             insertNodeAtLeft(popNode()); }
                         catch (ClassCastException e) {}
                         }
                     point(root);
                   }
                 }

             int n =0;
             do {
                 System.out.println("Tree Has been created successfully!");
                 System.out.println("-------------------MENU------------------");
                 System.out.println("Press 1 and Enter for In-order Traversal");
                 System.out.println("Press 2 and Enter for Pre-order Traversal");
                 System.out.println("Press 3 and Enter for Post-order Traversal");
                 System.out.println("Press 4 and Enter for Expression Evaluation");
                 System.out.println("Press 0 and Enter to Exit");
                 Scanner sc = new Scanner(System.in);
                 n = sc.nextInt();
                 if (n == 1) {
                     System.out.println("Inorder traversal would give infix expression");
                     inOrderTrav(root);
                 } else if (n == 2) {
                     System.out.println("Pre-Order traversal would give prefix expression");
                      preOrderTrav(root);
                 } else if (n == 3) {
                     System.out.println("Post-Order traversal would give postfix expression");
                     String str = postOrderTrav(root);
                     System.out.println(str);
                 }
                 else if (n == 4) {
                     String str = postOrderTrav(root);
                     System.out.println(pfEvaluation(str));
                 }
                 else System.out.println("WRONG CHOICE... ENTER AGAIN!");
                 System.out.println();
             }
             while (n != 0);
             }



    public static void main(String[] args) {
        BinaryExpressionTree bt = new BinaryExpressionTree();
        //PLEASE ENSURE SPACES IN BETWEEN INFIX EXPRESSION OTHERWISE IT WON'T BE CONVERTED TO POSTFIX
        bt.constructTree("( 5 + 3 ) / ( 6 - 9 )");
    }
}
