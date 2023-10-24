package arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeSort1 {

    public static void mergeSort(int[] arr, int si, int ei){
        if(si >= ei)
            return;

        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei){
        int i = si;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[ei - si + 1];

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j])
                temp[k] = arr[i++];
            else
                temp[k] = arr[j++];
            k++;
        }

        while(i <= mid) temp[k++] = arr[i++];

        while(j <= ei) temp[k++] = arr[j++];

        for(k = 0, i = si; k < temp.length; i++, k++)
            arr[i] = temp[k];
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6,3,2,7,9,8};
        mergeSort(arr, 0, arr.length - 1);
        print(arr);
        List<Integer> l = new ArrayList<>();
    }
}
