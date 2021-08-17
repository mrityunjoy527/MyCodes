package mathemaitcs;
import javax.swing.text.DefaultEditorKit;
import java.util.*;
public class Mathematics {

//    static boolean[] seiveOfEratoSthenes (int n){
//
//        boolean isPrime[] = new boolean[n + 1];
//
//        Arrays.fill(isPrime, true);
//
//        isPrime[0] = false;
//        isPrime[1] = false;
//
//        for(int i = 2; i * i <= n; i++){
//            for(int j = 2*i; j <= n; j += i){
//                isPrime[j] = false;
//            }
//        }
//
//
//        return isPrime;
//    }
//
//    static int gcd(int a, int b){
//        if(b == 0)
//            return a;
//
//        return gcd(b, a % b);
//    }
//
//    static long fastPower(long a, long b, long n){
//
//        long res = 1;
//
//        while(b > 0){
//            if((b & 1) != 0){
//                res = (res * a % n) % n;
//            }
//            a = (a % n * a % n) % n;
//            b = b >> 1;
//        }
//        return res;
//    }
    
    public static void main(String[] args) {

//        boolean isPrime[] = seiveOfEratoSthenes(20);
//
//        for(int i = 0; i <= 20; i++){
//            System.out.println(i + " " + isPrime[i]);
//        }

//        System.out.println(gcd(24, 60));

//        System.out.println(fastPower(3875342, 5, 1000000009));

        //// THIS IS A SERIES 9, 33, 73, 129...  FIND THE Nth TERM \\\\
//        int n = 5;
//        System.out.println((8 * n * n) + 1);

        //// MAXIMUM PIECES BY N CUTS \\\\
//        int n = 3;
//        int a = (n * (n + 1)/ 2) + 1;
//        System.out.println(a);

        //// LAZY CATERER'S PROBLEM \\\\
//        int n = 5;
//        System.out.println((n * (n + 1) / 2) + 1);

        //// MAXIMUM MONEY \\\\
//        int N = 2;
//        int K = 12;
//
//        int res = 0;
//
//        for(int i = 0; i < N; i += 2){
//            res += K;
//        }
//        System.out.println(res);

        //// PERFECT SQUARE \\\\
//        long n = 35;
//        int a = 0;
//        for(int i = 1; i <= n; i++){
//            if(i * i == n){
//                a = 1;
//                break;
//            } else {
//                a = 0;
//            }
//        }
//        System.out.println(a);

        //// CHECK IF THE NUMBERS ARE BALANCED \\\\
//        String n = "12345";
//        int a = n.length();
//        int sum1 = 0, sum2 = 0;
//        for(int i = 0; i < a/2; i++){
//            sum1 += n.charAt(i);
//        }
//        for(int i = a/2 + 1; i < a; i++){
//            sum2 += n.charAt(i);
//        }
//        if(sum1 == sum2){
//            System.out.println(1);
//        }else{
//            System.out.println(0);
//        }

        //// SPCIAL SERIES SUM \\\\
//        int n = 5;
//        int res = (n * (n + 1) * (2 * n + 4)) / 12;
//        System.out.println(res);


    }
//    static boolean prime(int a){
//        boolean isPrime = true;
//        for(int i = 2; i * i <= a; i++){
//            if(a % i == 0){
//                isPrime = false;
//                break;
//            }
//        }
//        if(a < 2) isPrime = false;
//
//        return isPrime;
//    }

//    static void print(int a){
//        if(a > 0){
//            print(a - 1);
//        }
//        System.out.print(a + " ");
//    }
//    static int power(int a, int b){
//        if(b == 0){
//            return 1;
//        }
//        return a * power(a, b - 1);
//    }

    static int square(int a, int b){
        int ans = 1;
        while(b > 0){
            ans *= a;
            b--;
        }
        return ans;
    }
}
