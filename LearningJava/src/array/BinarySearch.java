package array;

public class BinarySearch {

    public static void main(String[] args) {

        int a[] = {10, 5, 20};
        System.out.println(booksAllocation(a, 2));
    }
    static int binarySearch(int arr[], int key, int low, int high){
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == key){
                return mid;
            }else if(key > arr[mid]){
                low = mid + 1;
            }else if(key < arr[mid]){
                high = mid - 1;
            }
        }
        return -1;
    }
    static int searchInInfinite(int a[], int key){
        int low = 0, high = 1;
        while(a[low] < key){
            low = high;
            high = 2*high;
        }
        return binarySearch(a, key, low, high);
    }
    static int searchInRotatedArray(int a[], int key){
        int low = 0, high = a.length - 1;
        while (low  <= high){
            int mid = (low + high)/2;
            if(a[mid] == key){
                return mid;
            }
            if(a[low] < a[mid]){
                if(key >= a[low] && key < a[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else {
                if(key > a[mid] && key <= a[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    static int booksAllocation(int a[], int k){
        int min = maxOf(a);
        int max = sumOf(a);
        int res = 0;
        while(min <= max){
            int mid = (min + max)/ 2;
            if(isFeasible(a, k, mid)){
                res = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return res;
    }

    static boolean isFeasible(int[] a, int k, int res) {
        int student = 1, sum = 0;
        for(int i = 0; i < a.length; i++){
            if(sum + a[i] > res){
                student++;
                sum = a[i];
            }else{
                sum += a[i];
            }
        }
        return student <= k;
    }

    public static int sumOf(int[] a) {
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return sum;
    }

    public static int maxOf(int[] a) {
        int max = a[0];
        for(int i = 0; i < a.length; i++){
            if(a[i] > max) max = a[i];
        }
        return max;
    }
}
