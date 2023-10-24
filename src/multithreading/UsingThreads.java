package multithreading;

class Hello extends Thread {
    int[] arr = new int[5];
    public void run() {
        for(int i : arr){
            System.out.println("Hello");
            try { Thread.sleep(500);} catch (InterruptedException e) { }
        }
    }
}

class Hi extends Thread {
    int[] arr = new int[5];
    public void run() {
        for(int i : arr){
            System.out.println("Hiiiii");
            try { Thread.sleep(500); } catch (InterruptedException e) { }
        }
    }
}
public class UsingThreads {
    public static void main(String[] args) {
        Thread t1 = new Hello();
        Thread t2 = new Hi();

        t1.start();
        t2.start();
    }
}
