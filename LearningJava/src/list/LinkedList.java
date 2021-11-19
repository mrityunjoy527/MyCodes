package list;
import java.util.*;
public class LinkedList {

    public static void main(String[] args){

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirteen = new Node(13);
        Node fourteen = new Node(14);
        Node fifteen = new Node(15);

        // set head node
        Node head = one;

        // set next pointers
        one.next = four;
        four.next = fourteen;
        fourteen.next = fifteen;
        five.next = nine;
        nine.next = ten;
        seven.next = eight;
        eleven.next = thirteen;

        // set child pointers
        one.child = two;
        two.child = three;
        four.child = five;
        five.child = six;
        six.child = seven;
        ten.child = eleven;
        eleven.child = twelve;
        flattenList(head);
        while (head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
    }
    public String destCity(List<List<String>> paths) {
        Set<String> hs = new HashSet<>();
        for (List<String> a : paths) hs.add(a.get(1));
        for (List<String> a : paths) hs.remove(a.get(0));
        return hs.iterator().next();
    }
    static class Node{
        int data;
        Node next, child;
        public Node(int data){
            this.data = data;
        }
    }
    static Node flattenList(Node head){
        if (head == null) {
            return null;
        }

        // keep track of the next pointer
        Node next = head.next;

        // process the down list first
        head.next = flattenList(head.child);

        // go to the last node
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // process the next list after the down list
        tail.next = flattenList(next);

        // return head node
        return head;
    }
}
