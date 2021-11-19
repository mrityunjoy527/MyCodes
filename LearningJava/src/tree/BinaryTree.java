package tree;

import java.util.*;

public class BinaryTree {

    static TreeNode prev = null;
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data = data;
        }
    }

    static class Pair{
        TreeNode node;
        int num;
        public Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }
    static class Tuple{
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        List<Integer> l = new ArrayList<>();
        l = preOrderTrav(root);
        String a = serialise(root);
        TreeNode b = deSerialise(a);
        inOrderTraversal(b);
        inOrderTraversal(root);
        System.out.println(l);
    }

    static void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    static void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }
    static void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    static ArrayList<Integer> inOrderTrav(TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (true){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else {
                if (st.isEmpty()) break;
                root = st.pop();
                inOrder.add(root.data);
                root = root.right;
            }
        }
        return inOrder;
    }
    static List<Integer> preOrderTrav(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            preorder.add(root.data);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left!= null){
                st.push(root.left);
            }
        }
        return preorder;
    }
    static ArrayList<Integer> postOrderTrav(TreeNode root){
        ArrayList<Integer> postOrder = new ArrayList<>();
        if(root == null) return postOrder;
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        TreeNode temp = null;
        while (cur != null || !st.isEmpty()){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            else {
                temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    postOrder.add(temp.data);
                    while (!st.isEmpty() && temp == st.pop().right){
                        temp = st.pop();
                        postOrder.add(temp.data);
                    }
                }else {
                    cur = temp;
                }
            }
        }
        return postOrder;
    }
    static List<List<Integer>> levelOrderTrav(TreeNode root){
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) return levelOrder;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                list.add(node.data);
            }
            levelOrder.add(list);
        }
        return levelOrder;
    }
    static List<List<Integer>> zigZagTrav(TreeNode root){
        List<List<Integer>> zigZag = new ArrayList<>();
        if(root == null) return zigZag;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                int index = (leftToRight) ? i : 0;
                list.add(index, node.data);
            }
            leftToRight = !leftToRight;
            zigZag.add(list);
        }
        return zigZag;
    }
    static ArrayList<Integer> preInPostTrav(TreeNode root){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        if (root == null) return null;
        while (!st.isEmpty()){
            Pair it = st.pop();
            if (it.num == 1){
                preOrder.add(it.node.data);
                it.num++;
                st.push(it);
                if(it.node.left != null) st.push(new Pair(it.node.left, 1));
            }else if(it.num == 2){
                inOrder.add(it.node.data);
                it.num++;
                st.push(it);
                if(it.node.right != null) st.push(new Pair(it.node.right, 1));
            }else {
                postOrder.add(it.node.data);
            }
        }
        return postOrder;
    }
    static int maxHeight(TreeNode root){
        if(root == null) return 0;
        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);
        return 1 + Math.max(lh, rh);
    }
    static boolean balancedTree(TreeNode root){
        return height(root) != -1;
    }
    static int height(TreeNode root){
        if(root == null) return 0;
        int lh = height(root.left);
        if(lh == -1) return -1;
        int rh = height(root.right);
        if(rh == -1) return -1;
        if(Math.abs(rh - lh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }
    int maxPath(TreeNode root, int a[]){
        if(root == null) return 0;
        int ls = Math.max(0, maxPath(root.left, a));
        int rs = Math.max(0, maxPath(root.right, a));
        a[0] = Math.max(a[0], ls + rs + root.data);
        return root.data + Math.max(ls, rs);
    }
    int maxDiameter(TreeNode root, int a[]){
        if(root == null) return 0;
        int lh = maxDiameter(root.left, a);
        int rh = maxDiameter(root.right, a);
        a[0] = Math.max(a[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
    static boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return p == q;
        }
        return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    static boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    static void addLeftBoundary(TreeNode root, ArrayList<Integer> res){
        root = root.left;
        if(root != null){
            if(!isLeaf(root)) res.add(root.data);
            if(root.left != null) root = root.left;
            else root = root.right;
        }
    }
    static void addRightBoundary(TreeNode root, ArrayList<Integer> res){
        root = root.right;
        ArrayList<Integer> l = new ArrayList<>();
        if(root != null){
            if(!isLeaf(root)) l.add(root.data);
            if(root.right != null) root = root.right;
            else root = root.left;
        }
        for (int i = l.size() - 1; i >= 0; i--){
            res.add(l.get(i));
        }
    }
    static void addLeaves(TreeNode root, ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left, res);
        if(root.right != null) addLeaves(root.right, res);
    }
    static List<Integer> boundaryTrav(TreeNode root){
        ArrayList<Integer> boundary = new ArrayList<>();
        if(!isLeaf(root)) boundary.add(root.data);
        addLeftBoundary(root, boundary);
        addLeaves(root, boundary);
        addRightBoundary(root, boundary);
        return boundary;
    }
    static List<List<Integer>> verticalTrav(TreeNode root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).add(node.data);
            if(node.left != null) q.add(new Tuple(node.left, x - 1, y + 1));
            if(node.right != null) q.add(new Tuple(node.right, x + 1, y + 1));
        }
        List<List<Integer>> vertical = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            vertical.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes: ys.values())
                while (!nodes.isEmpty())
                    vertical.get(vertical.size() - 1).add(nodes.poll());
        }
        return vertical;
    }
    static List<Integer> topView(TreeNode root){
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()){
            Pair it = q.poll();
            int line = it.num;
            TreeNode node = it.node;
            if(!map.containsKey(line)){
                map.put(line, node.data);
            }
            if(node.left != null) q.add(new Pair(node.left, line - 1));
            if(node.right != null) q.add(new Pair(node.right, line + 1));
        }
        List<Integer> topView = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            topView.add(entry.getValue());
        }
        return topView;
    }
    static List<Integer> bottomView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair it = q.poll();
            int line = it.num;
            TreeNode node = it.node;
            map.put(line, node.data);
            if (node.left != null) q.add(new Pair(node.left, line - 1));
            if (node.right != null) q.add(new Pair(node.right, line + 1));
        }
        List<Integer> bottomView = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bottomView.add(entry.getValue());
        }
        return bottomView;
    }
    static void leftSideView(TreeNode root, int level, List<Integer> res){
        if(root == null) return;
        if(level == res.size()) res.add(root.data);
        leftSideView(root.left, level + 1, res);
        leftSideView(root.right, level + 1, res);
    }
    static void rightSideView(TreeNode root, int level, List<Integer> res){
        if(root == null) return;
        if(level == res.size()) res.add(root.data);
        rightSideView(root.right, level + 1, res);
        rightSideView(root.left, level + 1, res);
    }
    static boolean isSymmetry(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null) return root1 == root2;
        if(root1.data != root2.data) return false;
        return isSymmetry(root1.left, root2.right) && isSymmetry(root1.right, root2.left);
    }
    static boolean getPath(TreeNode root, List<Integer> list, int a){
        if(root == null) return false;
        list.add(root.data);
        if(root.data == a) return true;
        if(getPath(root.left, list, a) || getPath(root.right, list, a)) return true;
        list.remove(list.size() - 1);
        return false;
    }
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
    static int maxWidth(TreeNode root){
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++){
                TreeNode node = q.peek().node;
                int curIndex = q.peek().num - min;
                q.poll();
                if(i == 0) first = curIndex;
                if(i == size - 1) last = curIndex;
                if(node.left != null) q.offer(new Pair(node.left, 2*curIndex + 1));
                if(node.right != null) q.offer(new Pair(node.right, 2*curIndex + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
    static void changeTree(TreeNode root){
        if(root == null) return;
        int child = 0;
        if(root.left != null) child += root.left.data;
        if(root.right != null) child += root.right.data;
        if(child >= root.data) root.data = child;
        else{
            if(root.left != null) root.left.data = root.data;
            else if(root.right != null) root.right.data = root.data;
        }
        changeTree(root.left);
        changeTree(root.right);
        int total = 0;
        if(root.left != null) total += root.left.data;
        if(root.right != null) total += root.right.data;
        if(root.left != null || root.right != null) root.data = total;
    }
    static void parent_track(TreeNode root, Map<TreeNode, TreeNode> parent_track){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                parent_track.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null){
                parent_track.put(node.right, node);
                q.offer(node.right);
            }
        }
    }
    static List<Integer> kDistantNodes(TreeNode root, TreeNode target, int k){
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        parent_track(root, parent_track);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target, true);
        int cur_lev = 0;
        while (!q.isEmpty()){
            if(cur_lev == k) break;
            cur_lev++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null && visited.get(node.left) == null){
                    q.add(node.left);
                    visited.put(node.left, true);
                }
                if(node.right != null && visited.get(node.right) == null){
                    q.add(node.right);
                    visited.put(node.right, true);
                }
                if(parent_track.containsKey(node) && visited.get(parent_track.get(node)) == null){
                    q.add(parent_track.get(node));
                    visited.put(parent_track.get(node), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().data);
        }
        return ans;
    }
    static int getLeftHeight(TreeNode root){
        int count = 0;
        while (root != null){
            count++;
            root = root.left;
        }
        return count;
    }
    static int getRightHeight(TreeNode root){
        int count = 0;
        while (root != null){
            count++;
            root = root.right;
        }
        return count;
    }
    static int countTotalNodes(TreeNode root){
        if (root == null) return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if(leftHeight == rightHeight) return (2 << leftHeight) - 1;
        return 1 + countTotalNodes(root.left) + countTotalNodes(root.right);
    }
    static TreeNode mapParents(TreeNode root, Map<TreeNode, TreeNode> parents, int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = new TreeNode(-1);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.data == start) res = node;
            if(node.left != null){
                parents.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null){
                parents.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
    static int timeToBurnTree(TreeNode root, int start){
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode target = mapParents(root, parents, start);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int time = 0;
        while (!q.isEmpty()){
            int size = q.size();
            int flag = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null && visited.get(node.left) == null){
                    q.offer(node.left);
                    visited.put(node.left, true);
                    flag = 1;
                }
                if(node.right != null && visited.get(node.right) == null){
                    q.offer(node.right);
                    visited.put(node.right, true);
                    flag = 1;
                }
                if(parents.containsKey(node) && visited.get(parents.get(node)) == null){
                    q.offer(parents.get(node));
                    visited.put(parents.get(node), true);
                    flag = 1;
                }
            }
            if(flag == 1) time++;
        }
        return time;
    }
    static TreeNode buildTreeInPre(int inOrder[], int is, int ie, int preOrder[], int ps, int pe, Map<Integer, Integer> map){
        if(is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(preOrder[ps]);
        int inRoot = map.get(preOrder[ps]);
        int numsLeft = inRoot - is;
        root.left = buildTreeInPre(inOrder, is, inRoot - 1, preOrder, ps + 1, ps + numsLeft, map);
        root.right = buildTreeInPre(inOrder, inRoot + 1, ie, preOrder, ps + numsLeft + 1, pe, map);
        return  root;
    }
    static TreeNode buildTreeInPost(int inOrder[], int is, int ie, int postOrder[], int ps, int pe, Map<Integer, Integer> map){
        if(is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(postOrder[pe]);
        int inRoot = map.get(postOrder[pe]);
        int numsLeft = inRoot - is;
        root.left = buildTreeInPost(inOrder, is, inRoot - 1, postOrder, ps, ps + numsLeft - 1, map);
        root.right = buildTreeInPost(inOrder, inRoot + 1, ie, postOrder, ps + numsLeft, pe - 1, map);
        return root;
    }
    static String serialise(TreeNode root){
        if(root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("n ");
                continue;
            }
            res.append(node.data + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }
    static TreeNode deSerialise(String data){
        if(data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String val[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        q.add(root);
        for(int i = 1; i < val.length; i++){
            TreeNode parent = q.poll();
            if(!val[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(val[i]));
                parent.left = left;
                q.add(left);
            }
            if(!val[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(val[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    //// MORRIS TRAVERSAL \\\\\
    static List<Integer> getInorder(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        if(root == null) return inorder;
        TreeNode cur = root;
        while (cur != null){
            if(cur.left == null){
                inorder.add(cur.data);
                cur = cur.right;
            }else{
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }else{
                    prev.right = null;
                    inorder.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }
    //// MORRIS TRAVERSAL \\\\\
    static List<Integer> getPreorder(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        TreeNode cur = root;
        while (cur != null){
            if(cur.left == null){
                preorder.add(cur.data);
                cur = cur.right;
            }else{
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    preorder.add(cur.data);
                    cur = cur.left;
                }else{
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }
    static void flatenTree(TreeNode root){
        TreeNode cur = root;
        while (cur != null){
            if(cur.left != null){
                TreeNode prev = cur.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = cur.right;
                cur.right = cur.left;
            }
            cur = cur.right;
        }
    }
    static void flatTree(TreeNode root){
        if(root == null) return;
        flatTree(root.right);
        flatTree(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    static void flatten(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode cur = st.pop();
            if(cur.right != null) st.push(cur.right);
            if(cur.left != null) st.push(cur.left);
            if(!st.isEmpty()){
                cur.right = st.peek();
            }
            cur.left = null;
        }
    }
}