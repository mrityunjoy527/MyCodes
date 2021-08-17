package bitManupulation;
import java.util.Scanner;
public class BitMagic {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //// RIGHT SHIFT \\\\
//        int a = 1;
//        int temp = 0;
//        if(a != 1) {
//            temp = a >> 1;
//        }else{
//            temp = a;
//        }
//        System.out.println(temp);

        //// SET KTH BIT \\\\
//        int N = 10;
//        int K = 2;
//        int mask = 1 << K;
//
//        N = N | mask;
//        System.out.println(N);

        //// CHECK FOR SET BITS \\\\
//        int N = 8;
//        int a = 1;
//        int binary[] = new int[1000];
//
//        int i = 0;
//        while(N > 0){
//            binary[i] = N % 2;
//            N /= 2;
//            i++;
//        }
//        for(int j = i - 1; j >= 0; j--){
//            if(binary[j] != 1){
//                a = 0;
//            }
//        }
//        System.out.println(a);

        //// 1' COMPLEMENT \\\\
//        int N = 3;
//        String a = "101";
//        String ans = "";
//
//        for(int i = 0; i < N; i++){
//            if(a.charAt(i) == '1'){
//                ans += '0';
//            }else{
//                ans += '1';
//            }
//        }
//        System.out.println(ans);

        //// MULTIPLY SET BITS \\\\
//        int a = 2;
//        int n = a;
//        int setBit = 0;
//        int binary[] = new int[1000];
//
//        int i = 0;
//        while(n > 0){
//            binary[i] = n % 2;
//            n /= 2;
//            i++;
//        }
//        for(int j = i - 1; j >= 0; j--){
//            if(binary[j] == 1){
//                setBit++;
//            }
//        }
//        int mul = a * setBit;
//
//        System.out.println(mul);

        //// COUNT SETBIT \\\\
//        int a = 10, b = 20;
//        int n = a ^ b;
//        int binary[] = new int[1000];
//        int setBit = 0;
//        int i = 0;
//        while(n > 0){
//            binary[i] = n % 2;
//            n /= 2;
//            i++;
//        }
//        for(int j = i - 1; j >= 0; j--){
//            if(binary[j] == 1){
//                setBit++;
//            }
//        }
//        System.out.println(setBit);

        //// KRISHNAMURTHY'S NUMBER \\\\
//        int a = 145;
//        int temp = a;
//        int lastDigit = 0;
//        int sum = 0;
//
//        while(temp > 0){
//            lastDigit = temp % 10;
//            sum += factorial(lastDigit);
//            temp /= 10;
//        }
//        if(sum == a){
//            System.out.println("Yes");
//        }else{
//            System.out.println("No");
//        }

        //// CHECK Kth BIT IS SET OR NOT \\\\
//        int n = 500;
//        int k = 3;
//        int binary[] = new int[1000];
//        int i = 0;
//        int temp = n;
//        while(temp > 0){
//            binary[i] = temp % 2;
//            temp /= 2;
//            i++;
//        }
//        if(binary[k] == 0){
//            System.out.println("No");
//        }else {
//            System.out.println("Yes");
//        }

        //// CHECK FOR CONSECUTIVE SETBITS \\\\
//        long n = 1;
//        long temp = n;
//        boolean res = false;
//        int binary[] = new int[1000];
//
//        int i = 0;
//        while(temp > 0){
//            binary[i] = (int)temp % 2;
//            temp /= 2;
//            i++;
//        }
//        if(binary[5] == 0){
//            res = true;
//        }
//        for(int j = 0; j < i - 1; j++){
//            if(binary[j] + binary[j + 1] == 2) {
//                res = false;
//            }else{
//                res = true;
//            }
//        }
//        System.out.println(res);

        //// SUM WITHOUT ANY OPERATOR \\\\
//        int a = 6, b = 6;
//        if(b > 0){
//            while(b > 0){
//                a++;
//                b--;
//            }
//        }else{
//            while(b < 0){
//                a--;
//                b++;
//            }
//        }
//        System.out.println(a);

        //// DELETED ELEMENT \\\\
//        int a[] = {1, 2, 3, 4, 5};
//        int b[] = {1, 2, 3, 4};
//        int sum1 = 0;
//        int sum2 = 0;
//        for(int i = 0; i < a.length; i++){
//            sum1 += a[i];
//        }
//        for(int i = 0; i < b.length; i++){
//            sum2 += b[i];
//        }
//        System.out.println(sum1 - sum2);

        //// LONGEST CONSECUTIVE 1s \\\\
//        int n = 222;
//        int res = 0;
//        while(n != 0){
//            n = n & (n << 1);
//            res++;
//        }
//        System.out.println(res);


    }
//    static void decimalToBinary(int n){
//        int binary[] = new int[1000];
//
//        int i = 0;
//        while(n > 0){
//            binary[i] = n % 2;
//            n /= 2;
//            i++;
//        }
//        for(int j = i - 1; j >= 0; j--){
//            System.out.print(binary[j]);
//        }
//    }

    static int defBits(int a, int b){
        int count = 0;
        int def = a ^ b;
        while (def > 0){
            def &= def - 1;
            count++;
        }
        return count;
    }

    static int factorial(int n){
        int sum = 1;
        for(int i = 1; i <= n; i++){
            sum *= i;
        }
        return sum;
    }

    static int findComplement(int num) {
        int mask = 1;
        while(mask < num){
            mask = (mask << 1) | 1;
        }
        return mask ^ num;
    }
    static boolean alternateBits(int a){
        a = a ^ (a >> 1);
        return (a & a + 1) == 0;
    }
}
