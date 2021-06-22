package Q8CPUJobSchedulingPriorityQueues;

import java.util.ArrayList;

public class PriorityQueue {
    private int MAX;
public ArrayList<Node> arr;
private int nItems;
private int size;

    public PriorityQueue() {
        MAX=100;
        arr = new ArrayList<>();
        nItems = 0;
        size = 0;
    }
    public PriorityQueue(int size) {
        MAX=size;
        arr = new ArrayList<>();
        nItems = 0;
        this.size = 0;
    }
    public void insertSp (Node node) {
        arr.add(node);
    }
    public void insert(Node node) {
        int i;
        if(nItems == 0) {
            arr.add(node);
            nItems++;
            return;
        }
        for (i = nItems-1;i>=0;i--) {
            if(node.priority > arr.get(i).priority) {
                arr.add(i+1,arr.get(i));
            }
            else {
                break;
            }
        }
        arr.add(i+1,node);
        size++;
        nItems++;
    }
    public int getSize() {
        return size;
    }
    public void printPriorityQueue() {
        for (int i = 0;i<nItems;i++) {
            System.out.println(arr.get(i).jobName + " " +arr.get(i).length+ " " +arr.get(i).priority);
        }
    }
    public Node remove(int index) {
        nItems--;
        return arr.remove(index);

    }
    public Node remove() {
        nItems--;
        return arr.remove(0);

    }
    public boolean isEmpty() {
        return  nItems == 0;
    }
    public Node getNode() {
        return arr.get(0);
    }
    public Node getNode(int index) {
        return arr.get(index);
    }

    public String printNode() {
        return "Job Name: " + arr.get(nItems-1).jobName + " Length is: " + arr.get(nItems-1).length + " Priority is: " + arr.get(nItems-1).priority;
    }

}
