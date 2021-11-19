package tree;

import java.util.Stack;

class BSTIterator {
    public static class BSTNode{
        int data;
        BSTNode left, right;
        public BSTNode(int data){
            this.data = data;
        }
    }
    private Stack<BSTNode> st = new Stack<>();
    boolean reverse;

    public BSTIterator(BSTNode root, boolean isReversed) {
        reverse = isReversed;
        pushAll(root);
    }

    public int next() {
        BSTNode res = st.pop();
        if(reverse == false) pushAll(res.right);
        else pushAll(res.left);
        return res.data;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(BSTNode node){
        while(node != null){
            st.push(node);
            if(reverse == true){
                node = node.right;
            }else{
                node = node.left;
            }
        }
    }
    public boolean findTarget(BSTNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k) return true;
            else if(i + j > k) j = r.next();
            else i = l.next();
        }
        return false;
    }
}