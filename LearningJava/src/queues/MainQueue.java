package queues;

public class MainQueue {

    public static void main(String[] args) {

        MyQueue<Integer> mq = new MyQueue<>();

        mq.enQueue(23);
        mq.enQueue(2);
        mq.enQueue(56);


        System.out.println(mq.peek());
    }
}
