package array;

public class MergeSort {

    public static void main(String[] args) {

        int a[] = {5, 2, 9, 0, 3, 7, 12, 34 ,8, 1};
        mergeSort(a, 0, 9);

    }

    static int[] mergeSort(int a[], int l, int r){

        if(l < r){
            int mid = (l + r) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            merge(a, l, mid, r);
        }
        return a;
    }

    static void merge(int[] a, int l, int mid, int r) {
        int b[] = new int[a.length];
        int i = l;
        int j = mid + 1;
        int k = l;

        while (i <= mid && j <= r){
            if(a[i] < a[j]){
                b[k] = a[i];
                i++;
            }else{
                b[k] = a[j];
                j++;
            }
            k++;
        }
        if(i > mid){
            while (j <= r){
                b[k] = a[j];
                k++; j++;
            }
        }else {
            while (i <= mid){
                b[k] = a[i];
                k++; j++;
            }
        }
        for (k = l; k <= r; k++){
            a[k] = b[k];
        }
    }
}
