package Q7HeapII;

import java.util.Arrays;

public class CombineHeap<T> {
    public Integer[] mergeArrays (Integer[] arr1,Integer[] arr2) {
            int arr1Length = arr1.length;
            int arr2Length = arr2.length;
            Integer[] mergedArray = new Integer[arr1Length+arr2Length];
            System.arraycopy(arr1, 0, mergedArray, 0, arr1Length);
            System.arraycopy(arr2, 0, mergedArray, arr1Length, arr2Length);
            return mergedArray;
    }
    public T[] heapify(T[] list, int low, int high) {
        int largeIndex;
        Comparable<T> temp =
                (Comparable<T>) list[low];  //copy the root node of the subtree
        largeIndex = 2 * low + 1;  //index of the left child
        while (largeIndex <= high) {
            if (largeIndex < high) {
                Comparable<T> compElem =
                        (Comparable<T>) list[largeIndex];
                if (compElem.compareTo(list[largeIndex + 1]) < 0)
                    largeIndex = largeIndex + 1; //index of the largest child
            }

            if (temp.compareTo(list[largeIndex]) > 0) //subtree
                //is already in a heap
                break;
            else {
                list[low] = list[largeIndex]; //move the larger
                //child to the root
                low = largeIndex;    //go to the subtree to
                //restore the heap
                largeIndex = 2 * low + 1;
            }

        }//end while
        list[low] = (T) temp; //insert temp into the tree,
        //that is, list
        return list;
    }//end heapify
    public T[] buildHeap(T[] list, int length) {
        T[] arr = null;
        for (int index = length / 2 - 1; index >= 0; index--) {

            arr = heapify(list, index, length - 1);
        }
        return arr;
    }
    public static void main(String[] args) {
        //Heap-Array1
        Integer[] arr1 = {2,3,4,5,6,7,8};
        //Heap-Array2
        Integer[] arr2 = {9,10,11,12,13,14,15};

        CombineHeap<Integer> cH = new CombineHeap<>();
        System.out.println("Successfully merged two heaps and built it into a heap!");
        System.out.print("Merged Heap's Array: ");
        System.out.println(Arrays.toString(cH.buildHeap(cH.mergeArrays(arr1,arr2),cH.mergeArrays(arr1,arr2).length)));
    }
}
