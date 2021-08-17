package recursionAndBacktracking;

import oops.A;

import java.util.ArrayList;

public class Backtracking {

    public static void main(String[] args) {

        int a[] = {2, 1, 2, 3, 4, 8};
        int sum = 0;
        for(int i: a){
            sum += i;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        boolean isPossible = (sum & 1) == 0 && partition(a, sum/2, 0, ans);
        if(isPossible){
            for (int i: ans){
                System.out.print(i + " ");
            }
        }else{
            System.out.println("Not possible");
        }

    }
    static int shortestPath(int a[][], int i, int j, int x, int y){
        int rows = a.length;
        int cols = a[0].length;
        boolean vis[][] = new boolean[rows][cols];
        return shortestPath(a, i, j, x, i, vis);
    }
    static boolean isValid(int a[][], int i, int j, boolean vis[][]){
        int rows = a.length;
        int cols = a[0].length;
        return i >= 0 && j >= 0 && i < rows && j < cols && a[i][j] == 1 && !vis[i][j];
    }
    static int shortestPath(int a[][], int i, int j, int x, int y, boolean vis[][]){
        if(!isValid(a, i, j, vis)) return 1000000;
        if(i == x && j == y) return 0;
        vis[i][j] = true;
        int left = shortestPath(a, i, j - 1, x, y, vis) + 1;
        int bottom = shortestPath(a, i + 1, j, x, y, vis) + 1;
        int right = shortestPath(a, i, j + 1, x, y, vis) + 1;
        int top = shortestPath(a, i - 1, j, x, y, vis) + 1;
        vis[i][j] = false;
        return Math.min(Math.min(left, bottom), Math.min(right, top));
    }
    static boolean partition(int a[], int sum, int i, ArrayList<Integer> ans){
        if(i >= a.length || sum < 0) return false;
        if(sum == 0) return true;
        ans.add(a[i]);
        boolean leftPossible = partition(a, sum - a[i], i + 1, ans);
        if(leftPossible) return true;
        ans.remove(ans.size() - 1);
        return partition(a, sum, i + 1, ans);
    }
}
