package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapsDemo {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student that) {
            return this.rank - that.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Narinder", 2));
        pq.add(new Student("Harman",3));
        pq.add(new Student("Pargat", 6));
        pq.add(new Student("Aviraj", 1));
        pq.add(new Student("Aradhna", 5));
        pq.add(new Student("Daddy", 9));
        pq.add(new Student("Mummy", 8));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}
