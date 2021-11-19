package deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) {


    }
    List<Integer> maxInWindow(int a[], int n, int k){
        List<Integer> list = new ArrayList<>();
        Deque<Integer> qi = new ArrayDeque<>();
        int i;
        for (i = 0; i < k; i++){
            while (!qi.isEmpty() && a[i] >= a[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);
        }
        for(; i < n; i++){
            list.add(a[qi.peekFirst()]);
            while (!qi.isEmpty() && qi.peek() <= i - k)
                qi.removeFirst();
            while (!qi.isEmpty() && a[i] >= a[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);
        }
        list.add(qi.peek());
        return list;
    }
}
