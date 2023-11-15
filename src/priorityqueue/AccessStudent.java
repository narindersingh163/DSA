package priorityqueue;

import java.util.PriorityQueue;

public class AccessStudent {
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("Narinder", 29, 6));
        pq.add(new Student("Harman", 25, 4));
        pq.add(new Student("Pargat", 30, 3));
        pq.add(new Student("Aradhna", 31, 7));
        pq.add(new Student("Aviraj", 4, 1));
        pq.add(new Student("Fuldev", 57, 2));
        pq.add(new Student("Rajwinder", 52, 8));

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
