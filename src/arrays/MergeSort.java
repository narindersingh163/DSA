package arrays;

public class MergeSort {

    public static void mergeSort(int[] nums, int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSort(nums, si ,mid);
        mergeSort(nums, mid + 1, ei);
        merge(nums, si, mid, ei);
    }

    public static void merge(int[] nums, int si, int mid, int ei){
        int i = si;//left iterator
        int j = mid + 1;//right iterator
        int k = 0;//temp iterator
        int[] temp = new int[ei - si + 1];

        while(i <= mid && j <= ei){
            if(nums[i] < nums[j]){
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            temp[k++] = nums[i++];
        }

        while(j <= ei){
            temp[k++] = nums[j++];
        }

        for(k = 0, i = si; k < temp.length; k++, i++){
            nums[i] = temp[k];
        }
        print(nums);
    }

    public static void print(int [] nums){
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {6,3,9,5,2,8,1};
        mergeSort(nums, 0, nums.length - 1);
        print(nums);
    }
}
