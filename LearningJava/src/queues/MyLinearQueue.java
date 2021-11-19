package queues;

public class MyLinearQueue {

    int q[];
    int capacity;
    int rear;

    public MyLinearQueue(int size){
        capacity = size;
        q = new int[size];
        rear = -1;
    }
    public void enqueue(int data) throws Exception {
        if(rear == capacity - 1){
            return;
        }
        q[++rear] = data;
    }
    public int dequeue() throws Exception {
        if(rear == -1){
            throw new Exception();
        }
        int res = q[0];
        for(int i = 0; i < rear; i++){
            q[i] = q[i + 1];
        }
        rear--;
        return res;
    }
    public int getFront() throws Exception {
        if(rear == -1){
            throw new Exception();
        }
        return q[0];
    }
}
