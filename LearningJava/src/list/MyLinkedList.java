package list;

 public class MyLinkedList<E> {

    Node<E> head;

    public void add(E data){
        Node<E> toAdd = new Node<E>(data);

        if(isEmpty()){
            head = toAdd;
            return;
        }
        Node<E> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = toAdd;
    }

    public void print(){
        Node<E> temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public E removeLast() throws Exception{
        Node<E> temp = head;
        if(temp == null){
            throw new Exception("Cannot remove last element from empty linked list");
        }
        if(temp.next == null){
            Node<E> toRemove = head;
            head = null;
            return toRemove.data;
        }
        while (temp.next.next != null){
            temp = temp.next;
        }
        Node<E> toRemove = temp.next;
        temp.next = null;
        return toRemove.data;
    }

    public E getLast() throws Exception{
        Node<E> temp = head;
        if(temp == null){
            throw new Exception("Cannot peek last element from empty linked list");
        }
        while (temp.next != null){
            temp = temp.next;
        }

        return temp.data;
    }

    public boolean isEmpty(){
        return head == null;
    }

    int size(){
        int size = 0;
        Node temp = head;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
    void insertNode(E data, Node<E> head, int pos){
        Node<E> toAdd = new Node<>(data);
        if(pos == 0){
            toAdd.next = head;
            head = toAdd;
            return;
        }
        Node<E> prev = head;
        for(int i = 0; i < pos - 1; i++){
            prev = prev.next;
        }
        toAdd.next = prev.next;
        prev.next = toAdd;
    }
    void deleteNode(Node<E> head, int pos){
        if(pos == 0){
            head = head.next;
            return;
        }
        Node<E> prev = head;
        for(int i = 0; i < pos - 1; i++){
            prev = prev.next;
        }
        prev = prev.next.next;
    }
}
