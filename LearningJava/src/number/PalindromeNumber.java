package number;

public class PalindromeNumber {

    public static void main(String[] args){

        int n = 12070506;
        int temp = n;
        int reverseNumber = 0;

        while (temp > 0){
            int lastdigit = temp % 10;
            temp /= 10;
            reverseNumber = reverseNumber * 10 + lastdigit;
        }
        System.out.println(reverseNumber);

    }
    static int convert0to5(int num) {
        // Base case for recursion termination
        if (num == 0) return 0;

        // Extract the last digit and change it if needed
        int digit = num % 10;
        if (digit == 0) digit = 5;

        // Convert remaining digits and append the last digit
        return convert0to5(num / 10) * 10 + digit;
    }
}
