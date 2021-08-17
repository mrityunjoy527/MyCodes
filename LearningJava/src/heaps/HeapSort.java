package heaps;

public class HeapSort {

    static void heapSort(int a[]){
        BuildHeap.buildHeap(a, a.length);
        for(int i = a.length - 1; i >= 0; i--){
            DeletionOfRoot.swap(a, 0, i);
            DeletionOfRoot.heapify(a, i, 0);
        }
    }

    public static void main(String[] args) {

        int a[] = {12, 11, 13, 5, 6, 7 };
        heapSort(a);
        for(int i: a){
            System.out.print(i + " ");
        }
    }
}
