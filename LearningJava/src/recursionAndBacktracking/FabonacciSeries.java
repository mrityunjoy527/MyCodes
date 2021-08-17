package recursionAndBacktracking;

public class FabonacciSeries {
    static int a = 0, b = 1, c;
    public static void main(String[] args) {

        System.out.print(a + " " + b);
        fabonacci(20);
    }

    static void fabonacci(int n){
        if(n >= 1) {
            c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
            fabonacci(n - 1);
        }
    }
}
