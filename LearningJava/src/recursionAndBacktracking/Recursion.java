package recursionAndBacktracking;
import java.util.*;
public class Recursion {

    public static void main(String[] args){

//        int a[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
//                    {1, 1, 1, 1, 1, 1, 0, 0},
//                    {1, 0, 0, 1, 1, 0, 1, 1},
//                    {1, 2, 2, 2, 2, 0, 1, 0},
//                    {1, 1, 1, 2, 2, 0, 1, 0},
//                    {1, 1, 1, 2, 2, 2, 2, 0},
//                    {1, 1, 1, 1, 1, 2, 1, 1},
//                    {1, 1, 1, 1, 1, 2, 2, 1}};
//
//        floodFill(a, 0, 0, 5, 1);
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[0].length; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }

        stringPermutation("abc", 0, 2);

        int a[] = {1, 5, 7, 3, 2, 4};
        System.out.println(coinMax(a, 0, a.length - 1));
    }
    static int power(int a, int b){
        if(b == 0){
            return 1;
        }
        return a * power(a, b - 1);
    }
    static void floodFill(int a[][], int r, int c, int toFill, int prevFill){
        int rows = a.length;
        int cols = a[0].length;
        if(r < 0 || r >= rows || c < 0 || c >= cols){
            return;
        }
        if(a[r][c] != prevFill){
            return;
        }
        a[r][c] = toFill;

        floodFill(a, r - 1, c, toFill, prevFill);
        floodFill(a, r, c - 1, toFill, prevFill);
        floodFill(a, r + 1, c, toFill, prevFill);
        floodFill(a, r, c + 1, toFill, prevFill);
    }
    static void stringPermutation(String a, int l, int r){
        if(l == r){
            System.out.println(a);
        }
        for(int i = l; i <= r; i++){
            a = interchange(a, l, i);
            stringPermutation(a, l + 1, r);
            a = interchange(a, l, i);
        }
    }
    static String interchange(String s, int l, int r){
        char a[] = s.toCharArray();
        char temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        return String.valueOf(a);
    }
    static int coinMax(int a[], int l, int r){
        if(l + 1 == r){
            return Math.max(a[l], a[r]);
        }
        return Math.max(a[l] + Math.min(coinMax(a, l + 2, r), coinMax(a, l + 1, r - 1)),
                        a[r] + Math.min(coinMax(a, l + 1, r - 1), coinMax(a, l, r - 2)));
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        subSetSumHelper(arr, ans, 0, N, 0);
        Collections.sort(ans);
        return ans;

    }
    void subSetSumHelper(ArrayList<Integer> arr, ArrayList<Integer> a,  int ind, int size, int sum){
        if(ind == size){
            a.add(sum);
            return;
        }
        //picking the element
        subSetSumHelper(arr, a, ind + 1, size, sum + arr.get(ind));
        //not picking the element
        subSetSumHelper(arr, a, ind + 1, size, sum);
    }
    static List<List<Integer>> combinationSum(int candidates[], int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinations(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
    static void combinations(int ind, int target, int arr[], List<List<Integer>> ans, List<Integer> ds){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind] <= target){
            ds.add(arr[ind]);
            combinations(ind, target - arr[ind], arr, ans, ds);
            ds.remove(ds.size() - 1);
        }
        combinations(ind + 1, target, arr, ans, ds);
    }
}
