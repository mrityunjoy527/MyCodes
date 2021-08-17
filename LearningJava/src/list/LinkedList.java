package list;
import java.util.*;
public class LinkedList {

    public static void main(String[] args) {


    }
    public String destCity(List<List<String>> paths) {

        Set<String> hs = new HashSet<>();

        for(List<String> a: paths) hs.add(a.get(1));
        for(List<String> a: paths) hs.remove(a.get(0));

        return hs.iterator().next();
    }

}
