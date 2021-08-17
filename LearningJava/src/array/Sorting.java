package array;

public class Sorting {

    public static void main(String[] args) {

        //// SELECTION SORT \\\\
//        int a[] = {2, 8, 12, 34, 56, 78, 54, 6};
//        int n = a.length;
//
//        for(int i = 0; i < n - 1; i++) {
//            int min = i;
//            for(int j = i; j < n; j++){
//                if(a[j] < a[min]){
//                    min = j;
//                }
//            }
//            int temp = a[i];
//            a[i] = a[min];
//            a[min] = temp;
//        }
//        for(int e : a) {
//            System.out.print(e + " ");
//        }

        //// BUBBLE SORT \\\\
//        int a[] = {2, 5, 1, 8, 3, 5, 6};
//        int n = a.length;
//        boolean swapped = false;
//
//        for(int i = 0; i < n - 1; i++){
//            for(int j = 0; j < n - 1 - i; j++){
//                if(a[j + 1] < a[j]){
//                    int temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                    swapped = true;
//                }
//            }
//            if(!swapped){
//                break;
//            }
//        }
//        for(int i : a){
//            System.out.print(i + " ");
//        }

        //// INSERTION SORT \\\\
//        int a[] = {5, 1, 8, 3, 6, 0, 2};
//        int n = a.length;
//
//        for(int i = 0; i < n; i++){
//            int temp = a[i];
//            int j = i - 1;
//            while(j >= 0 && a[j] > temp){
//                a[j + 1] = a[j];
//                j--;
//            }
//            a[j + 1] = temp;
//        }
//        for(int i : a){
//            System.out.print(i + " ");
//        }


    }
}
