package heaps;

public class InsertionInRoot {

    public static void main(String[] args) {

        int a[] = {10, 5, 3, 2, 4};
        int key = 15;
        insertRoot(a, a.length, key);
        printArray(a, a.length);
    }

    static void heapify(int a[], int n, int i){
        int parent = i/2;
        if(a[parent] > 0){
            if(a[i] > a[parent]){
                swap(a, i, parent);
                heapify(a, n, parent);
            }
        }
    }
    static void insertRoot(int a[], int n, int key){
        n = n + 1;
        a[n - 1] = key;
        heapify(a, n, n - 1);
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
