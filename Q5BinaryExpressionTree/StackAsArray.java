package Q5BinaryExpressionTree;

import java.util.ArrayList;

public class StackAsArray  {

    static final int MAX = 1000;
    int top;
    Object a[]= new Object[MAX];

    boolean isEmpty()
    {
        return (top < 0);
    }
    StackAsArray()
    {
        top = -1;
        for (int i=0;i<MAX;i++)
            a[i]="";
    }

    public boolean push(Object x)
    {
        if (top >= (MAX - 1)){
            return false;
        }
        else {
            top++; a[top] = x;
            return true;
        }
    }
    public boolean point(BinaryExpressionTree.Node node)
    {
        if (top >= (MAX - 1)){
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            top++; a[top] = node;
            return true;
        }
    }


    public Object pop()
    {   String str = "";
        if (top < 0)
            System.out.println("Stack Underflow");
        else {
            str = String.valueOf(a[top]);
            a[top]="";
            top--;
        }
        return str;
    }
    public BinaryExpressionTree.Node popNode()
    {
        BinaryExpressionTree.Node temp = null;
        if (top < 0)
            System.out.println("Stack Underflow");
        else {
            temp = (BinaryExpressionTree.Node) a[top];
            a[top]="";
            top--;
        }
        return temp;
    }

    public Object peek()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return "";
        }
        else {
            Object x = a[top];
            return x;
        }
    }
    public boolean isOperator(String exp) {
        if (exp.equals("+") || exp.equals("-")  || exp.equals("/") || exp.equals("*") ) return true;
        return false;
    }
    public String convertToPostfix(String infix) {
        String[] newStr = new String[infix.length()];
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0;i<infix.length();i++) {
            newStr = infix.split(" ");
        }
        for (int i = 0;i<newStr.length;i++) {
            if (!newStr[i].equals("+") && !newStr[i].equals("-") && !newStr[i].equals("/") && !newStr[i].equals("*") &&
                    !newStr[i].equals(")")&& !newStr[i].equals("(")) {
                arrayList.add(newStr[i]);
            }
            else if (newStr[i].equals("(") || newStr[i].equals("+") || newStr[i].equals("-")
                    || newStr[i].equals("/") || newStr[i].equals("*")) {
                push(newStr[i]);
            }
            else if (newStr[i].equals(")")) {
                boolean flag = false;
                do {
                    String pop = (String)pop();
                    if (pop.equals("(")) {
                        flag = false;
                    }
                    else {
                        flag = true;}
                    if (!pop.equals("(") && !pop.equals(")")) arrayList.add(pop);
                    if (i == newStr.length-1) {
                        if (!isEmpty()) {
                            while (!isEmpty()) {
                                String pop1 = (String) pop();
                                if (isOperator(pop1)) {
                                arrayList.add(pop1);}
                            }
                        }
                    }
                }
                while(flag == false);

            }
        }
        String postFix = "";
        for (int i = 0;i<arrayList.size();i++) {
            postFix = postFix.concat(arrayList.get(i));
        }
        return postFix;
    }

}
