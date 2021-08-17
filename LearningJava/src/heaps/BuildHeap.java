package heaps;

public class BuildHeap {

    static void buildHeap(int a[], int n){
        for(int i = n/2 - 1; i >= 0; i--){
            DeletionOfRoot.heapify(a, n, i);
        }
    }

    public static void main(String[] args) {

        int a[] = {10, 30, 50, 20, 35, 15};
        buildHeap(a, a.length);
        DeletionOfRoot.printArray(a, a.length);
    }
}
