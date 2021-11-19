package queues;

public class MyCirculerQueue {

    int rear, front;
    int capacity;
    int q[];
    public MyCirculerQueue(int size){
        capacity = size;
        q = new int[size];
        rear = front = -1;
    }
    public void enqueue(int data){
        if((rear + 1) % capacity == front){
            return;
        }
        if(front == -1) front = 0;
        rear = (rear + 1) % capacity;
        q[rear] = data;
    }
    public int dequeue() throws Exception {
        if(front == -1){
            throw new Exception();
        }
        int res = q[front];
        if(front == rear) front = rear = -1;
        else front = (front + 1) % capacity;
        return res;
    }
}
