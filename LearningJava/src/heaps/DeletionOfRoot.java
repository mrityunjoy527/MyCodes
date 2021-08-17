package heaps;

public class DeletionOfRoot {

    public static void main(String[] args) {

        int a[] = {10, 5, 3, 2, 4};
        int n = deletionRoot(a, a.length);
        printArray(a, n);

    }
    static void heapify(int a[], int n, int i){
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;
        if(left < n && a[left] > a[largest]){
            largest = left;
        }
        if(right < n && a[right] > a[largest]){
            largest = right;
        }
        if(largest != i){
            swap(a, largest, i);
            heapify(a, n, largest);
        }
    }
    static int deletionRoot(int a[], int n){
        a[0] = a[n - 1];
        n = n - 1;
        heapify(a, n, 0);
        return n;
    }
    static void swap(int ar[], int a, int b){
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }
    static void printArray(int a[], int n){
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
