package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {

        MyDeque<Integer> md = new MyDeque<>();

        md.addToHead(12);
        md.addToHead(56);
        md.addToHead(21);
        md.addToHead(76);


        System.out.println(md.removeLast());
        System.out.println(md.removeLast());
        System.out.println(md.removeLast());
        System.out.println(md.removeLast());
    }
}
