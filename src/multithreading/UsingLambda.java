package multithreading;

public class UsingLambda {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = () -> {
                int[] arr = new int[5];
                System.out.println("The " + Thread.currentThread().getName() + " is Running");
                for(int i = 0; i < arr.length; i++) {
                    System.out.println("Hello" + " " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        };

        Runnable runnable2 = () -> {
                int[] arr = new int[5];
                System.out.println("The " + Thread.currentThread().getName() + " is Running");
                for(int i = 0; i < arr.length; i++){
                    System.out.println("Hiiiii" + " " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        };

        Thread t1 = new Thread(runnable1, "Hello Thread");
        Thread t2 = new Thread(runnable2, "Hi Thread");

        t1.start();
        t2.start();

        System.out.println(t1.isAlive());

        t1.join();
        t2.join();

        System.out.println(t1.isAlive());

        System.out.println("Bye form Main thread");
    }
}
