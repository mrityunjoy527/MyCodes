package array;

public class QuickSort {

    public static void main(String[] args){

        int a[] = {2, 7, 1, 4, 2, 8};
        int n = a.length;

        quickSort(a, 0, n);
        for(int i : a){
            System.out.print(i + " ");
        }
    }
    static int partition (int a[], int l, int h){

        int Pivot = a[l];
        int i = l, j = h - 1;
        while(i < j){
            while(a[i] <= Pivot) i++;
            while(a[j] > Pivot) j--;
            if(i < j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[j];
        a[j] = a[l];
        a[l] = temp;
        return j;
    }
    static void quickSort(int a[], int l, int h){

        if(l < h){
            int pivot = partition(a, l, h);

            quickSort(a, l, pivot - 1);
            quickSort(a, pivot + 1, h);
        }
    }
}
