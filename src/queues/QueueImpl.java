package queues;

public class QueueImpl {
    static class Queue{
        int[] queue;
        int size;
        int rear;
        Queue(int size){
            this.size = size;
            this.rear = -1;
            this.queue = new int[size];
        }

        public boolean isEmpty(){
            return rear == -1;
        }

        public void add(int data){
            if(rear == size - 1){
                System.out.println("Queue is full");
                return;
            }

            rear = rear + 1;
            queue[rear] = data;
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int front = queue[0];
            for(int i = 0; i < rear; i++){
                queue[i] = queue[i + 1];
            }
            rear--;
            return front;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return queue[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(8);
        q.add(7);
        q.add(6);
        System.out.println(q.remove());
        System.out.println(q.peek());
    }
}
