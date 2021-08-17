package array;
import oops.A;

import java.util.*;
public class Array<a> {

//    static int maximumProfit(int a[]){
//
//        int maxProfit = 0;
//        int minPrice = a[0];
//
//        for(int i = 0; i < a.length; i++){
//            minPrice = Math.min(minPrice, a[i]);
//            int profit = a[i] - minPrice;
//            maxProfit = Math.max(profit, maxProfit);
//        }
//        return maxProfit;
//    }
//    static int totalProfit(int a[]){
//
//        int profit = 0;
//        for(int i = 1; i < a.length; i++){
//            if(a[i] > a[i - 1]){
//                profit += a[i] - a[i - 1];
//            }
//        }
//        return profit;
//    }
//    static int rainWaterDrop(int a[]){
//        int n = a.length;
//        int leftBuild[] = new int[n];
//        int rightBuild[] = new int[n];
//        int totalWater = 0;
//        leftBuild[0] = a[0];
//
//        for(int i = 1; i < n; i++){
//            leftBuild[i] = Math.max(leftBuild[i - 1], a[i]);
//        }
//        rightBuild[n - 1] = a[n - 1];
//        for(int i = n - 2; i >= 0; i--){
//            rightBuild[i] = Math.max(rightBuild[i + 1], a[i]);
//        }
//        for(int i = 0; i < n; i++){
//            totalWater += (Math.min(leftBuild[i], rightBuild[i]) - a[i]);
//        }
//        return totalWater;
//    }

    public static void main(String[] args) {

        //// MULTIPLY BOATH HALFS OF AN ARRAY \\\\
//        int a[] = new int[sc.nextInt()];
//        int n = a.length;
//
//        int sum1 = 0;
//        int sum2 = 0;
//        int sum = 0;
//
//        for(int i = 0; i < n; i ++){
//            a[i] = sc.nextInt();
//        }
//        for(int i = 0; i < n/2; i ++){
//            sum1 += a[i];
//        } for(int j = n/2; j < n; j ++){
//            sum2 += a[j];
//        }
//        sum = sum1 * sum2;
//
//        System.out.println(sum);

//        int a[] = {5, 7, 9, 3, 6, 2};
//        int b[] = {1, 2, 6, -1, 0, 9};
//        int n1 = a.length;
//        int n2 = b.length;
//        int c = a[0];
//        int d = b[0];
//        int sum = 0;
//
//
//        for(int i = 0; i < n1; i++){
//            if(a[i] > c){
//                c = a[i];
//            }
//        }
//        for(int i = 0; i < n2; i++){
//            if(b[i] < d){
//                d = b[i];
//            }
//        }
//        sum = c * d;
//        System.out.println(sum);

        //// K LARGEST ELEMENT \\\\
//        int a[] = {2, 8, 12, 34, 56, 78, 54, 6};
//        int n = a.length;
//        int k = 2;
//
//        for (int i = 0; i < n - 1; i++) {
//            int min = i;
//            for (int j = i; j < n; j++) {
//                if (a[j] < a[min]) {
//                    min = j;
//                }
//            }
//            int temp = a[i];
//            a[i] = a[min];
//            a[min] = temp;
//        }
//        for(int i = n - 1; i >= n - k; i--){
//            System.out.print(a[i] + " ");
//        }

        //// CYLENDRICAL ROTATE ARRAY \\\\
//        int arr[] = {1, 2, 3, 4, 5};
//        int n = arr.length;
//        int x = arr[n - 1];
//
//        for (int i = n-1; i > 0; i--) {
//            arr[i] = arr[i - 1];
//        }
//            arr[0] = x;
//
//        for(int e : arr){
//            System.out.print(e + " ");
//        }

        //// MIN AND MAX ELEMENT \\\\
//        long a[] = {12, 21, 67, 888, 2};
//        long n = a.length;
//
//        long a2 = a[0];
//        long a3 = a[0];
//        String min = "min = ", max = ", max = ";
//
//        for(int i = 0; i < n; i++){
//            if(a[i] > a2){
//                a2 = a[i];
//            }if(a[i] < a3){
//                a3 = a[i];
//            }
//        }
//        System.out.println(min+ a3 + max + a2);

        //// FIND XOR OF CONCECUTIVE ELEMENTS \\\\
//        int a[] = {10, 11, 1, 2, 3};
//        int n = a.length;
//
//        int i = 0;
//        while(i < n - 1){
//            a[i] = a[i] ^ a[i + 1];
//            i ++;
//        }
//
//        for(int e : a){
//            System.out.print(e + " ");
//        }

        //// SEGREGATE 0's AND 1's \\\\
//        int arr[] = {0, 0, 1, 1, 0, 0, 1};
//        int n = arr.length;
//        int a[] = new int[n];
//        int zero = 0;
//
//        Arrays.fill(a, 1);
//        for(int i = 0; i < n; i++){
//            if(arr[i] != 1){
//                zero++;
//            }
//        }
//        for(int i = 0; i < zero; i++){
//            a[i] = 0;
//        }
//        for(int i : a){
//            System.out.print(i + " ");
//        }

//        int a[] = {3, 1, 2, 4, 0, 1, 3, 2};
//        System.out.println(rainWaterDrop(a));

        //// NUMBER OF NUMBERS \\\\
//        int a[] = {11, 12, 13, 14, 15};
//        int k = 1;
//        int n = a.length;
//        int res = 0;
//        for(int i = 0; i < n; i++){
//            res += numberOfNumbers(a[i], k);
//        }
//        System.out.println(res);

        //// COUNT TOTAL PAIRS \\\\
//        int arr[] = {1, 3, 4, 1, 4};
//        int n = arr.length;
//        int count = 0;
//        for(int i = 0; i < n; i++){
//            for(int j = i + 1; j < n; j++){
//                if(arr[i] == arr[j]){
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);

//        table(20);

        //// MAJORITY ELEMENT \\\\
//        int a[] = {1, 5, 3, 4, 2};
//        int n = a.length;
//        int ansInd = 0;
//        int count = 1, count2 = 0;
//
//        for(int i = 1; i < n; i++){
//            if(a[i] == a[ansInd]){
//                count++;
//            }else{
//                count--;
//            }if(count == 0){
//                ansInd = i;
//                count = 1;
//            }
//        }
//        for(int i = 0; i < n; i++){
//            if(a[i] == a[ansInd]){
//                count2++;
//            }
//        }
//        if(count2 > n/2) {
//            System.out.println(a[ansInd]);
//        }else{
//            System.out.println("No element");
//        }

        //// MAXIMUM SUM OF SUBARRAY \\\\
//        int a[] = {5, -4, -2, 6, -1};
//        int n = a.length;
//        int currSum = 0;
//        int maxSum = 0;
//
//        for(int i = 0; i < n; i++){
//            currSum += a[i];
//            if(currSum > maxSum){
//                maxSum = currSum;
//            }
//            if(currSum < 0){
//                currSum = 0;
//            }
//        }
//        System.out.println(maxSum);

//        int a[] = {1, 4, 0};
//        System.out.println(leaders(a, a.length));

            //// SHUFFLE ARRAY \\\\
//        int nums[] = {3, 1, 7, 5, 0, 2, 5, 3};
//        int n = nums.length/2;
//        int res[] = new int[2*n];
//
//        for(int i = 0, j = n, idx = 0; idx < nums.length; i++, j++){
//            res[idx++] = nums[i];
//            res[idx++] = nums[j];
//        }
//        for(int e : res){
//            System.out.print(e + " ");
//        }

//        int a[] = {8,1,2,2,3};
//        smallerThanCurrent(a);

        //// GET MAX NUM NY CHANGING ONE VALUE \\\\
//        int num = 9669;
//        String a = String.valueOf(num);
//        char b[] = a.toCharArray();
//        for(int i = 0; i < b.length; i++){
//            if(b[i] == '6'){
//                b[i] = '9';
//                break;
//            }
//        }
//        System.out.println(Integer.parseInt(String.valueOf(b)));

//        int a[] = {1, 3, 4, 5, -3, -2};
//        System.out.println(subarraySumEqualsK(a, 9));

//        int a[] = sumZero(5);
//        for(int i: a) System.out.print(i + " ");

//        ArrayList<Integer> ans = new ArrayList<>();
//        int left = 66, right = 708;
//        for(int i = left; i <= right; i++){
//            if(selfDivided(i)){
//                ans.add(i);
//            }
//        }
//        System.out.println(ans);


    }
//    static int numberOfNumbers(int a, int k){
//        int count = 0;
//        while(a > 0){
//            int last = a % 10;
//            if(last == k){
//                count++;
//            }
//            a /= 10;
//        }
//        return count;
//    }

//    static void table(int a){
//
//        for(int i = 1; i <= a; i++){
//            for(int j = 1; j <= 10; j++){
//                System.out.print(i * j + " ");
//
//            }
//            System.out.println();
//        }
//    }

    //// LEADERS IN AN ARRAY \\\\
//    static ArrayList<Integer> leaders(int arr[], int n){
//
//        ArrayList<Integer> lead = new ArrayList<>();
//        lead.add(arr[n - 1]);
//        int max = arr[n - 1];
//
//        for(int i = n - 2; i >= 0; i--){
//            if(arr[i] > max){
//                max = arr[i];
//                lead.add(max);
//            }
//        }
//        Collections.reverse(lead);
//        return lead;
//
//    }

    static void smallerThanCurrent(int a[]){
        int n = a.length;
        int buck[] = new int[101];

        for(int i = 0; i < n; i++){
            buck[a[i]] += 1;
        }
        for(int i = 1; i <= 100; i++){
            buck[i] += buck[i - 1];
        }
        for(int i = 0; i < n; i++){
            if(a[i] != 0){
                a[i] = buck[a[i] - 1];
            }
        }
        for(int e : a) System.out.print(e + " ");
    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for(int i = 1; i < points.length; i++){
            int cur[] = points[i], prev[] = points[i - 1];
            ans += Math.max(Math.abs(cur[0] - prev[0]), Math.abs(cur[1] - prev[1]));
        }
        return ans;
    }
    static boolean evenDigits(int a){
        int t = a;
        int count = 0;
        while(t != 0){
            int last = t % 10;
            t /= 10;
            count++;
        }
        return (count % 2 == 0);
    }
    static int diagonalSumOfMatrix(int mat[][]){
        int sum = 0;
        int n = mat.length;
        for(int i = 0; i < n; i++){
            sum += mat[i][i];
            sum += mat[n - 1 - i][i];
        }
        return n % 2 == 0? sum: sum - mat[n/2][n/2];
    }
    static boolean zeroSumSubarray(int a[]){
        Set<Integer> set = new HashSet<>();
        boolean found = false;
        int sum = 0;
        for(int i: a){
            set.add(sum);
            sum += i;
            if(set.contains(sum)) {
                found = true;
                break;
            }
        }
        return found;
    }
    static boolean subarraySumEqualsK(int a[], int k){
        Set<Integer> set = new HashSet<>();
        boolean found = false;
        int sum = 0;
        for(int i: a){
            set.add(sum);
            sum += i;
            if(set.contains(sum - k)) {
                found = true;
                break;
            }
        }
        return found;
    }
    static int[] sumZero(int n) {
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = i * 2 - n + 1;
        }
        return a;
    }
    static boolean selfDivided(int a){
        int n = a;
        while(n > 0){
            int last = n % 10;
            if(last == 0 || a % last != 0){
                return false;
            }
            n /= 10;
        }
        return true;
    }
    static int negElementsIn2DSSortedMatrix(int a[][]){
        int count = 0;
        for(int i = 0, end = a[i].length; i < a.length; i++){
            int start = 0;
            while (start <= end){
                int mid = (start + end)/2;
                if(a[i][mid] < 0){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
            count = count + a[i].length - start;
        }
        return count;
    }
    static void matrixMultiply(int a[][], int b[][]){
        int r1 = a.length, c1 = a[0].length, r2 = b.length, c2 = b[0].length;
        if(c1 != r2){
            System.out.println("Multiplying not possible");
        }
        int ans[][] = new int[r1][c2];
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                for(int k = 0; k < r2; k++){
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        for(int i = 0; i < r1; i++){
            for (int j = 0; j < c2; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[] sortArrayByParity(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
    static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i: arr){
            count.put(i, 1 + count.getOrDefault(i, 0));
        }
        return count.size() == new HashSet<>(count.values()).size();
    }
    static void candiesDistribution(int candies, int numPeople){
        int res[] = new int[numPeople];
        int ind = 0, candyCount = 1;
        while (candies > 0){
            res[ind++] += candyCount;
            candies -= candyCount++;
            if (ind == numPeople) ind = 0;
            if (candyCount > candies) candyCount = candies;
        }
        for (int i: res){
            System.out.print(i + " ");
        }
    }
    static int[] defuseBomb(int code[], int key){
        int n = code.length;
        int res[] = new int[n];
        if(key == 0) return res;
        int start = 1, end = key, sum = 0;
        if(key < 0){
            key = -key;
            start = n - key;
            end = n - 1;
        }
        for(int i = start; i <= end; i++){
            sum += code[i];
        }
        for(int i = 0; i < n; i++){
            res[i] = sum;
            sum -= code[start++ % n];
            sum += code[++end % n];
        }
        return res;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}
