package deque;

import java.util.HashMap;

public class MyDeque<E> {

    Node<E> head, tail;

    void addToHead(E data){
        Node<E> tooAdd = new Node<>(data);
        if(head == null){
            head = tail = tooAdd;
            return;
        }
        head.next = tooAdd;
        tooAdd.prev = head;
        head = tooAdd;

    }
    E removeLast(){
        if(head == null){
            return null;
        }
        Node<E> toRemove = tail;
        tail = tail.next;
        tail.prev = null;
        if (tail == null){
            head = null;
        }
        return toRemove.data;
    }

    public static class Node<E>{
        E data;
        Node<E> next, prev;

        public Node(E data){
            this.data = data;
            next = prev = null;
        }
    }
}
