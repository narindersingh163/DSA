package multithreading;

public class UsingLambda {
    public static void main(String[] args) {
        Runnable hello = () -> {
                int[] arr = new int[5];
                for(int i : arr) {
                    System.out.println("Hello");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
        };

        Runnable hi = () -> {
                int[] arr = new int[5];
                for(int i : arr){
                    System.out.println("Hiiiii");
                    try { Thread.sleep(500); } catch (InterruptedException e) { }
                }
        };

        new Thread(hello).start();
        new Thread(hi).start();
    }
}
