package Q8CPUJobSchedulingPriorityQueues;
/*
*PLEASE READ THIS!
* HOW DOES THIS PROGRAM WORKS?
* Firstly, for the first job scheduling, cpu won't consider priority since it is considered that
other jobs hasn't arrived yet.
* So, after 1st time slice, it will consider the priority and will get the highest priority task to be done.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Node {
    public String jobName;
    public int priority;
    public int length;


    public Node(String jobName,int priority,int length) {
        this.jobName = jobName;
        this.priority = priority;
        this.length = length;

    }

}
class comparePriority implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.priority > o2.priority) {
            return 1;
        }
        if (o1.priority < o2.priority) {
            return -1;
        }
        else return 0;
    }

}
class NamePriority implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.jobName.equals(o2.jobName)) {
            return 1;
        }
        if (o1.priority < o2.priority) {
            return -1;
        }
        else return 0;
    }

}
public class CPUJobScheduler extends PriorityQueue {
   public int timeSlice;



    public Node node;
    public CPUJobScheduler() {
    }

    public void setTimeSlice(int timeSlice) {
           this.timeSlice = timeSlice;
    }
    public int getTimeSlice() {
        return timeSlice;
    }
    public Node getHighestPriorityNode (ArrayList<Node> list) {
            Collections.sort(list,new comparePriority());
        return list.get(0);
    }


    public void cpuScheduler(ArrayList<Node> list,int totalLength) {
        PriorityQueue runningPq = new PriorityQueue();
        PriorityQueue readyPq = new PriorityQueue();
        comparePriority cp = new comparePriority();

        for(int i = 0; i<list.size();i++) {
            readyPq.insert(list.get(i));
        }
        for (int i = 0; i<= totalLength;i++) {
            if (i ==0) {
                Node tmp = readyPq.getNode();
                runningPq.insert(tmp);
            }
            else {
                Node tmp = getHighestPriorityNode(readyPq.arr);
                runningPq.insert(tmp);
            }
          for (int j = timeSlice;j>0;j--) {
                      if (runningPq.getNode().length <= 0) {
                          System.out.println("No new job this slice!");
                      }
                      if (runningPq.getNode().length > 0) {
                          System.out.println(runningPq.printNode());
                      }
                      runningPq.getNode().length--;
                      if (j==1) {
                          String name = runningPq.getNode().jobName;
                          if (runningPq.getNode().length <= 0) {
                              while (!runningPq.isEmpty()) {
                                  runningPq.remove();
                              }
                              if (name.equals(readyPq.getNode().jobName)) readyPq.remove();
                              else {
                                  int size = readyPq.getSize();
                                  for (int k = 0;k<readyPq.getSize();k++) {
                                      String watch = readyPq.getNode(k).jobName;
                                      if (readyPq.getNode(k).jobName.equals(name)) {
                                          readyPq.remove(k);
                                      }
                                  }
                              }
                          }
                          else {
                              Node check1 = runningPq.getNode();
                              Node check2 = readyPq.getNode(1);
                              if (cp.compare(runningPq.getNode(),readyPq.getNode(1))==1) {
                                  Node tmp1 = runningPq.remove();
                                  readyPq.remove();
                                  readyPq.insertSp(tmp1);
                              }

                          }
                      }
                }
        }

    }

    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node("j1" ,10,4));
        list.add(new Node("j2" ,-14,3));
        list.add(new Node("j3" ,-19,3));

        CPUJobScheduler cpuJobScheduler = new CPUJobScheduler();
        cpuJobScheduler.setTimeSlice(2);
        int totalLength =list.size()*cpuJobScheduler.getTimeSlice()-1;
        cpuJobScheduler.cpuScheduler(list,totalLength);
    }
}
