package array;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int a[] = {4, 3, 1, 2, 5, 3, 4, 7, 1, 9};
        int ans[] = slidingWindowMax(a, 4);
        for(int i: ans){
            System.out.print(i + " ");
        }
    }

    static int[] slidingWindowMax(int a[], int k){
        int n = a.length;
        int ans[] = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        int i = 0;
        for(; i < k; i++){
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(; i < n; i++){
            ans[i - k] = a[dq.peekFirst()];

            while (!dq.isEmpty() && dq.peekLast() <= i - k){
                dq.removeFirst();
            }

            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans[i - k] = a[dq.peekFirst()];

        return ans;
    }
}
