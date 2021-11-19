package queues;

public class MainQueue {

    public static void main(String[] args) throws Exception {

        MyCirculerQueue q = new MyCirculerQueue(5);
        q.enqueue(12);
        q.enqueue(23);
        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
        q.enqueue(5);
        q.enqueue(43);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
