package list;

import java.util.*;

public class PascalTriangle {

    public static void main(String[] args) {

        System.out.println(generatePascal(5));
    }

    static List<List<Integer>> generatePascal(int numRows){

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            l.add(0, 1);
            for(int j = 1; j < l.size() - 1; j++)
                l.set(j, l.get(j) + l.get(j + 1));
            ans.add(new ArrayList<>(l));
        }
        return ans;
    }
}

