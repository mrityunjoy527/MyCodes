package stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    public static void main(String[] args) {

        StackUsingQueue s = new StackUsingQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
    public void push(int data){
        while (!q1.isEmpty()){
            q2.add(q1.poll());
        }
        q1.add(data);
        while (!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }
    public int pop(){
        return q1.poll();
    }
}
