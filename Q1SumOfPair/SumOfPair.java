package Q1SumOfPair;

public class SumOfPair {
   boolean flag;
    public void getSumIntegers(int[] array, int num, int low) {
        sumOfPair(array, num, array.length - 1, low);
    }
    private void sumOfPair(int[] array, int num, int high, int low) {
        //{1,3,4,6} --- 10

        if (array[low] + array[high] == num) {
            flag = true;
            System.out.println(String.valueOf(array[low]) + " and " + String.valueOf(array[high]));
        } else if (high > low) {
            high--;
            sumOfPair(array, num, high, low);
        } else if (high <= low) {
            low++;
            if (low != array.length) {
                getSumIntegers(array, num, low);
            }
            else {
                System.out.println("Not Found!");
            }
        }

     }

     public static void main(String[] args) {
                 SumOfPair sumOfPair = new SumOfPair();
                 int[] array = {1,3,4,7};
       sumOfPair.getSumIntegers(array,3,0);
    }
}
