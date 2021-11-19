package tree;

import java.util.Stack;
public class BinarySearchTree {

    public static class BSTNode{
        int data;
        BSTNode left, right;
        public BSTNode(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {

        
    }
    static BSTNode searchInBST(BSTNode root, int data){
        while (root != null && root.data != data){
            root = data < root.data ? root.left : root.right;
        }
        return root;
    }
    static int ceilBST(BSTNode root, int data){
        int ceil = -1;
        while (root != null){
            if(root.data == data) return root.data;
        }
        if(data > root.data) root = root.right;
        else{
            ceil = root.data;
            root = root.left;
        }
        return ceil;
    }
    static int florBST(BSTNode root, int key){
        int flor = -1;
        while (root != null){
            if(root.data == key){
                return root.data;
            }
            if(key > root.data){
                flor = root.data;
                root = root.right;
            }
            else root = root.left;
        }
        return flor;
    }
    static BSTNode insertBSTNodeBST(BSTNode root, int data){
        if(root == null) return new BSTNode(data);
        BSTNode cur = root;
        while (true){
            if(cur.data <= data){
                if(cur.right != null) cur = cur.right;
                else{
                    cur.right = new BSTNode(data);
                    break;
                }
            }else{
                if(cur.left != null) cur = cur.left;
                else{
                    cur.left = new BSTNode(data);
                    break;
                }
            }
        }
        return root;
    }
    static BSTNode deleteBSTNodeBST(BSTNode root, int key){
        if(root == null) return root;
        if(root.data == key) return helper(root);
        BSTNode cur = root;
        while(cur != null){
            if(cur.data > key){
                if(cur.left != null && cur.left.data == key) {
                    cur.left = helper(cur.left);
                    break;
                }
                else
                    cur = cur.left;
            }else{
                if(cur.right != null && cur.right.data == key) {
                    cur.right = helper(cur.right);
                    break;
                }
                else
                    cur = cur.right;
            }
        }
        return root;
    }
    static BSTNode helper(BSTNode root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
        BSTNode rightChild = root.right;
        BSTNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }
    static BSTNode findLastRight(BSTNode root){
        if(root.right == null) return root;
        return findLastRight(root.right);
    }
    static BSTNode createBST(int a[], int l, int r){
        int mid = l + (r - l)/2;
        BSTNode root = new BSTNode(a[mid]);
        root.left = createBST(a, l, mid - 1);
        root.right = createBST(a, mid + 1, r);
        return root;
    }
    static int kthsmallest(BSTNode root, int k){
        Stack<BSTNode> st = new Stack<>();
        int cnt = 0;
        while (true){
            if(root != null){
                st.push(root);
                root = root.left;
            }else{
                if(st.isEmpty()) break;
                BSTNode BSTNode = st.pop();
                cnt++;
                if(cnt == k) return BSTNode.data;
                BSTNode = BSTNode.right;
            }
        }
        return -1;
    }
    static boolean validateBST(BSTNode root, int min, int max){
        if(root == null) return true;
        if(root.data >= max || root.data <= min) return false;
        return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
    }
    static BSTNode lowestCommonAncestor(BSTNode root, BSTNode p, BSTNode q){
        if(root == null) return null;
        int cur = root.data;
        if(cur > p.data && cur > q.data){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(cur < p.data && cur < q.data){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
    static BSTNode createBST(int a[], int bound, int[] i){
        if(i[0] == a.length || a[i[0]] > bound) return null;
        BSTNode root = new BSTNode(a[i[0]++]);
        root.left = createBST(a, root.data, i);
        root.right = createBST(a, bound, i);
        return root;
    }
    BSTNode first, middle, last, prev;
    void findSwapped(BSTNode root){
        if(root == null) return;
        findSwapped(root.left);
        if(prev != null && root.data < prev.data){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        findSwapped(root.right);
    }
    public void recoverTree(BSTNode root) {
        first = middle = last = null;
        prev = new BSTNode(Integer.MIN_VALUE);
        findSwapped(root);
        if(first != null && last != null){
            int t = first.data;
            first.data = last.data;
            last.data = t;
        }
        else{
            int t = first.data;
            first.data = middle.data;
            middle.data = t;
        }
    }
    //// LARGEST BST SIZE \\\\
    class NodeValue{
        int minBSTNode, maxBSTNode, maxSize;
        NodeValue(int minBSTNode, int maxBSTNode, int maxSize){
            this.minBSTNode = minBSTNode;
            this.maxBSTNode = maxBSTNode;
            this.maxSize = maxSize;
        }
    }
    NodeValue largestBstHelper(BSTNode root){
        if(root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);
        if(left.maxBSTNode < root.data && root.data < right.minBSTNode)
            return new NodeValue(Math.min(root.data, left.minBSTNode), Math.max(root.data, right.maxBSTNode), left.maxSize + right.maxSize + 1);
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
    int largestBst(BSTNode root){
        return largestBstHelper(root).maxSize;
    }

}
