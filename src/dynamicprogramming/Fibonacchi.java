package dynamicprogramming;

public class Fibonacchi {

    public static int fibo(int n, int[] f){
        if(n == 0 || n == 1) return f[n] = n;

        f[n] = f[n] != 0 ? f[n] : fibo(n - 1, f) + fibo(n -2, f);

        return f[n];
    }

    public static int tabuFibo(int n){
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for(int i = 2; i <= n; i++){
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
    public static void main(String[] args) {
        int n = 78;
        int[] f = new int[n + 1];
        System.out.println(fibo(n, f));
        System.out.println(tabuFibo(n));
    }
}
