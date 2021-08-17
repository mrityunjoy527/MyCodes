package vectorAndStack;

import java.util.Stack;
import java.util.Vector;

public class MainStack {

    public static void main(String[] args)throws Exception {

        Vector<String> v = new Vector<>();
        v.add("ab");
        v.add("aa");
        v.add("aa");
        v.add("abc");
        v.add("ab");
        Stack<String> st = new Stack<>();
        for(int i = 0; i < v.size(); i++){
            if(!st.isEmpty() && st.peek() == v.elementAt(i))
                st.pop();
            else st.push(v.elementAt(i));
        }
        System.out.println(st.size());
    }
    static void sortStack(Stack<Integer> s){
        if(s.size() == 1){
            return;
        }
        int temp = s.peek();
        s.pop();
        sortStack(s);
        insert(s, temp);
    }
    static void insert(Stack<Integer> st, int temp){
        if(st.isEmpty() || st.peek() <= temp){
            st.push(temp);
            return;
        }
        int val = st.pop();
        insert(st, temp);
        st.push(val);
    }
}
