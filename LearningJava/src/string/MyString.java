package string;

import oops.A;

import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class MyString {

    public static void main(String[] args) {

      ////  PRINT ODD INDEX CHARACTERS \\\\
//        String a = "Mrityunjoy";
//
//        for(int i = 0; i < a.length(); i += 2){
//            System.out.print(a.charAt(i));
//        }
           // REMOVE SPACES \\\\
//        String a = "   Geeks for ge   eks";
//        int n = a.length();
//        String c = "";
//
//        for(int i = 0; i < n; i ++){
//            if(a.charAt(i) != ' '){
//                c += a.charAt(i);
//            }
//        }
//        System.out.println(c);

        //// RED OR GREEN \\\\
//        String S = "RRGGRR";
//        int n = S.length();
//
//        String add1 = "";
//        String add2 = "";
//
//        for(int i = 0; i < n; i ++) {
//            if(S.charAt(i) == 'R') {
//                add1 += 'R';
//            }else{
//                add2 += 'G';
//            }
//        }
//        if(add1.length() > add2.length()) {
//            System.out.println(add2.length());
//        } else{
//            System.out.println(add2.length());
//        }
    //// COUNT UPPERCASE LETTERS \\\\
//        String s = "ckjkUUYII";
//        int n = s.length();
//
//        int res = 0;
//        for (int i = 0; i < s.length (); i++){
//            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
//                res++;
//        }
//        System.out.println(res);

        //// COUNT WORDS \\\\
//        String a = "iAmShubam";
//        int n = a.length();
//        int sum = 0;
//
//        for(int i = 0; i < n; i++){
//            if(a.charAt(i) >= 'A' && a.charAt(i) <= 'Z'){
//                sum++;
//            }
//        }
//        sum += 1;
//        System.out.println(sum);

        //// CHNAGE STRING \\\\
//        String s = "eyNFX";
//        int n = s.length();
//
//        for(int i = 0; i < n; i++){
//            if(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z'){
//                s = s.toUpperCase();
//            }else{
//                s = s.toLowerCase();
//            }
//        }
//        System.out.println(s);

        //// CHECK IF A SENTENCE HAVE ALL ALPHABETS \\\\
//        String str = "Bawds jog, flick quartz, vex nymph";
//        boolean[] mark = new boolean[26];
//
//        int index = 0;
//
//        for (int i = 0; i < str.length(); i++) {
//            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
//                index = str.charAt(i) - 'A';
//
//            else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
//                index = str.charAt(i) - 'a';
//
//            else
//                continue;
//
//            mark[index] = true;
//        }
//
//        for (int i = 0; i <= 25; i++)
//            if (mark[i] == false)
//                System.out.println(0);
//
//        System.out.println(1);

        //// CHECK FOR PALINDROME STRING \\\\
//        String S = "aba";
//        String S2 = "";
//        int res = 1;
//        for(int i = 0; i < S.length(); i++){
//            S2 += S.charAt(S.length() - 1 - i);
//        }
//        for(int i = 0; i < S.length(); i++){
//            if(S2.charAt(i) != S.charAt(i)){
//                res = 0;
//            }
//        }
//        System.out.println(res);

        //// CHANGE STRINGS FROM STRING \\\
//        String command = "G()(al)";
//        System.out.println(command.replace("G", "g"));
//        System.out.println(command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al"));

        //// Check if strings are rotations of each other or not \\\\
//        String s1 = "geeksforgeeks";
//        String s2 = "forgeeksgeekg";
//
//        System.out.println(s1.length() == s2.length() && (s1+s1).contains(s2));

//        String s = "is2 sentence4 This1 a3";
//        String words[] = s.split(" "), ans[] = new String[words.length];
//        for(String wrd: words){
//            int i = wrd.length() - 1;
//            ans[wrd.charAt(i) - '1'] = wrd.substring(0, i);
//        }
//        System.out.println(String.join(" ", ans));

        //// CHECK HALF OF THE STRING IS EQUAL \\\\
//        String s = "book";
//        var vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
//        int a = 0, b = 0;
//        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
//            a += vowels.contains(s.charAt(i)) ? 1 : 0;
//            b += vowels.contains(s.charAt(j)) ? 1 : 0;
//        }
//        System.out.println(a == b);

        //// CHESSBOARD COLOUR \\\\
//        String a = "a1";
//        int b = a.charAt(0) + a.charAt(1);
//        System.out.println(b);


    }
    static char repeatedChar(String S){
        int arr[] = new int[26];

        for(int i = 0; i < S.length(); i++){
            arr[S.charAt(i) - 'a']++;
        }
        for(int i = 0; i < S.length(); i++){
            if(arr[S.charAt(i) - 'a'] > 1){
                return (S.charAt(i));
            }
        }
        return '#';
    }
    static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        char str[] = s.toCharArray();

        for(int i = 0; i < str.length; i++){
            if(i < str.length - 2 && str[i + 2] == '#'){
                int n = (str[i] - '0') * 10 + (str[i + 1] - '0');
                sb.append((char)('j' + n - 10));
                i += 2;
            }else
                sb.append((char)('a' + str[i] - '1'));
        }
        return sb.toString();
    }
    static int[] shortestDistant(String s, char c){
        int n = s.length(), pos = -n, res[] = new int[n];

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == c)
                pos = i;
            res[i] = i - pos;

        }
        for(int i = pos - 1; i >= 0; i--){
            if(s.charAt(i) == c)
                pos = i;
            res[i] = Math.min(res[i], pos - i);

        }
        return res;
    }
    public static String[] winner(String arr[], int n)
    {
        String ans[] = new String[2];
        Map<String, Integer> mp = new HashMap<>();
        for(String a: arr){
            mp.put(a, mp.getOrDefault(a, 0) + 1);
        }
        int votes = 0;
        String name = "";
        for(String s: mp.keySet()){
            if(mp.get(s) > votes){
                votes = mp.get(s);
                name = s;
            }
            else if (mp.get(s) == votes && name.compareTo(s) > 0)
                name = s;
        }
        ans[0] = name;
        ans[1] = String.valueOf(votes);

        return ans;
    }
}
