package arrays;

public class Reverse {
    public static void reverse(int[] arr){
        int j = arr.length - 1;
        for (int i = 0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {8,7,6,5,4,3,2,1,0,10};

        reverse(arr);

        for (int k : arr) {
            System.out.print(k + " ");
        }
    }
}
