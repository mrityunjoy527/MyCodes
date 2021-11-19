package stack;

import list.MyLinkedList;
import queues.MyQueue;

public class MyStack {

    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    Node head;
    int size;
    public MyStack(){
        head = null;
        size = 0;
    }
    private void push(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        size++;
        head = newHead;
    }
    private int peek() throws Exception {
        if(head == null){
            throw new Exception();
        }
        return head.data;
    }
    private int pop() throws Exception {
        if(head == null){
            throw new Exception();
        }
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }
    private int size(){
        return size;
    }
    private boolean isEmpty(){
        return head == null;
    }

    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

    }
}
