package number;

public class TrailingZeros {

    public static void main (String[] args){

        int n = 12;
        int res = 0;

        for(int i = 5; i <= n; i *= 5){
            res += n/i;
        }
        System.out.println(res);
    }
}
