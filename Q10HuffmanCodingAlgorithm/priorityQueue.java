package Q10HuffmanCodingAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;

class compareNodes implements Comparator<HuffNode> {

    @Override
    public int compare(HuffNode o1, HuffNode o2) {
        return 0;
    }
}

public class priorityQueue {
    private int MAX;
    public HuffNode[] arr;
    private int nItems;
    private int size;

    public priorityQueue() {
        MAX=100;
        arr = new HuffNode[MAX];
        nItems = 0;
        size = 0;
    }
    public priorityQueue(int size) {
        MAX=size;
        arr = new HuffNode[MAX];
        nItems = 0;
        this.size = 0;
    }

    public void insert(HuffNode node) {
        int i;
        if(size == 0) {
            arr[0] = node ;
            size++;
            return;
        }
        for (i = size-1;i>=0;i--) {
            if(node.myFrequency < arr[i].myFrequency) {
                arr[i+1]=arr[i];
            }
            else {
                break;
            }
        }
        arr[i+1]= node;
        size++;
    }
    public int getSize() {
        return size;
    }
    public void printPriorityQueue() {
        for (int i = 0;i<nItems;i++) {
        }
    }
    public HuffNode remove() {
        HuffNode ret = arr[0];
        System.arraycopy(arr, 1, arr, 0, arr.length - 2);
        size--;
        return ret;

    }

    public boolean isEmpty() {
        return  size == 0;
    }
    public HuffNode getNode() {
        return arr[0];
    }
    public HuffNode getNode(int index) {
        return arr[index];
    }


}
