package queues;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public static void main(String[] args) {

        QueueUsingStack q = new QueueUsingStack();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
    public void enqueue(int data){
        st1.push(data);
    }
    public int dequeue(){
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }
        int res = st2.pop();
        while (!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return res;
    }
}
