package binarySearch;

public class BinarySearch {

    public static void main(String[] args) {


    }
    static int find_height(int tree[], int n, int k)
    {

        int l = 0, h = 0;
        for(int i: tree){
            if(i > h){
                h = i;
            }
        }
        while(l <= h){
            int mid = (l + h)/2;
            int wood = wood_collected(tree, mid);
            if(wood == k) return mid;
            if(wood > k) l = mid + 1;
            else h = mid - 1;
        }
        return -1;
    }
    static int wood_collected(int a[], int h){
        int wood = 0;
        for(int i: a){
            if(i > h){
                wood += i - h;
            }
        }
        return wood;
    }
}
