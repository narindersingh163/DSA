package multithreading;

class Hello1 implements Runnable{
    int[] arr = new int[5];
    @Override
    public void run(){
        for(int i : arr){
            System.out.println("Hello");
            try { Thread.sleep(500); } catch (InterruptedException e) { }
        }
    }
}

class Hi1 implements Runnable{
    int[] arr = new int[5];
    @Override
    public void run(){
        for(int i : arr){
            System.out.println("Hiiiii");
            try { Thread.sleep(500); } catch (InterruptedException e) { }
        }
    }
}

public class UsingRunnable {
    public static void main(String[] args) {
        Runnable r1 = new Hello1();
        Runnable r2 = new Hi1();

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
