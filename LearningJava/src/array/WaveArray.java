package array;

public class WaveArray {

    public static void main(String[] args){

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        boolean visited[] = new boolean[n];

        for(int i = 0; i < n - 1; i ++) {
            if(arr[i] < arr[i + 1] && !visited[i]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                visited[i] = true;
                visited[i + 1] = true;
            }
        }

 		for(int e : arr) {
 			System.out.print(e + " ");
 		}

    }

}
