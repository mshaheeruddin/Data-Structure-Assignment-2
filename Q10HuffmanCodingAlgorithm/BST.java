package Q10HuffmanCodingAlgorithm;

import java.util.Stack;

class HuffNode {
    public char myChar;
    public int myFrequency;
    public HuffNode myLeft, myRight;
    public HuffNode(char data,int frequency) {
        myChar = data;
        myFrequency = frequency;
        myLeft = null;
        myRight = null;
    }
    public HuffNode() {


    }
    public void  setMyFrequency(int myFrequency) {
        this.myFrequency = myFrequency;
    }
}

public class BST extends priorityQueue {
    HuffNode root;

public  BST() {
    root = null;
}
     String str = "";
    public String characterCode(HuffNode root,String code)
    {
        if (root!=null)
        {
            if (root.myLeft!=null)
                characterCode(root.myLeft, code+"0");
            if (root.myRight!=null)
                characterCode(root.myRight,code+"1");
            if (root.myLeft==null && root.myRight==null)
                str = str.concat(code + "\n");
        }
        return str;
    }



public void HuffmanTree() {
    while (getSize() >= 2) {
        HuffNode tmp = new HuffNode();
        tmp.myLeft = remove();
        tmp.myRight = remove();
        int freqLeft  = tmp.myLeft.myFrequency;
        int freqRight = tmp.myRight.myFrequency;

        tmp.setMyFrequency(freqLeft + freqRight);
        insert(tmp);
    }
    root = arr[0];
    remove();
}

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(new HuffNode('E',1));
        bst.insert(new HuffNode('n',2));
        bst.insert(new HuffNode('i',1));
        bst.insert(new HuffNode('y',1));
        bst.insert(new HuffNode('l',1));
        bst.insert(new HuffNode('k',1));
        bst.insert(new HuffNode('.',1));
        bst.insert(new HuffNode('r',2));
        bst.insert(new HuffNode('s',2));
        bst.insert(new HuffNode('a',2));
        bst.insert(new HuffNode(' ',4));
        bst.insert(new HuffNode('e',8));
        bst.HuffmanTree();
        String str = "";
        System.out.println(bst.characterCode(bst.root,str));







    }
}


