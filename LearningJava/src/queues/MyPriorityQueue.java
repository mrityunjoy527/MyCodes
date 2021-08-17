package queues;

import array.Array;
import oops.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MyPriorityQueue {

    public static void main(String[] args) {

    }
    static int kthLargest(int a[], int b){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < b; i++){
            pq.add(a[i]);
        }
        for(int i = b; i < a.length; i++){
            if(pq.peek() < a[i]){
                pq.poll();
                pq.add(a[i]);
            }
        }
        return pq.peek();
    }
    static int kthSmallest(int a[], int b){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < b; i++){
            pq.add(a[i]);
        }
        for(int i = b; i < a.length; i++){
            if(pq.peek() > a[i]){
                pq.poll();
                pq.add(a[i]);
            }
        }
        return pq.peek();
    }
    static ArrayList<Integer> topKElements(int a[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = a.length;
        for(int i = 0; i < n; i++){
            if(i < k){
                pq.add(a[i]);
            }else{
                if(pq.peek() < a[i]){
                    pq.poll();
                    pq.add(a[i]);
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>(pq);
        Collections.sort(arr, Collections.reverseOrder());
        return arr;
    }
    static int minCostNRopes(int a[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: a){
            pq.add(i);
        }
        int ans = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            ans += sum;
            pq.add(sum);
        }
        return ans;
    }
}
