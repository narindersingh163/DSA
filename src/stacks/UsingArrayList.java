package stacks;

import java.util.ArrayList;
import java.util.List;

public class UsingArrayList {

    public List<Integer> list;

    public UsingArrayList(){
        this.list = new ArrayList<>();
    }

    public void push(int val){
        list.add(val);
    }

    public int pop(){
        if(isEmpty())
            return -1;

        int i = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return i;
    }

    public int peek(){
        if(isEmpty())
            return -1;

        return list.get(list.size() - 1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
    public static void main(String[] args) {
        UsingArrayList stack = new UsingArrayList();
        stack.push(8);
        stack.push(7);
        stack.push(6);

        while(!stack.isEmpty()){
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }
}
