package queues;

import java.net.PortUnreachableException;

public class MyQueue {

    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    Node front, rear;

    private void enqueue(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    private int dequeue() throws Exception {
        if(front == null){
            throw new Exception();
        }
        int res = front.data;
        front = front.next;
        return res;
    }

    public static void main(String[] args) throws Exception {
        MyQueue q = new MyQueue();
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
