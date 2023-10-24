package heaps;

import java.util.ArrayList;

public class Insert {
    ArrayList<Integer> list = new ArrayList<>();
    public void insert(int val){
        list.add(val);

        int childIndex = list.size() - 1;
        int parentIndex = (childIndex - 1)/2;

        while (list.get(childIndex) < list.get(parentIndex)){
            int temp = list.get(parentIndex);
            list.add(parentIndex, list.get(childIndex));
            list.add(childIndex, temp);
        }
    }

    public static void main(String[] args) {

    }
}
