package queues;

import java.net.PortUnreachableException;

public class MyQueue<E> {

    Node<E> head, rear;

    public void enQueue(E data){
        Node<E> toAdd = new Node<>(data);
        if(head == null){
            head = rear = toAdd;
            return;
        }
        rear.next = toAdd;
        rear = rear.next;
    }

    public E deQueue(){
        if (head == null){
            return null;
        }
        Node<E> temp = head;
        head = head.next;
        if (head == null){
            rear = null;
        }
        return temp.data;
    }

    public E peek(){
        Node<E> first = head;
        if(head == null){
            return null;
        }
        return head.data;
    }

    static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data){
            this.data = data;
            next = null;
        }
    }
}
