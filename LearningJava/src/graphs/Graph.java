package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.*;

public class Graph {

    public static void main(String[] args) {

        int n = 3;
        int m = 3;
        int adj[][] = new int[n + 1][n + 1];

        // edge 1 -- 2
        adj[1][2] = 1;
        adj[2][1] = 1;

        // edge 2 -- 3;
        adj[2][3] = 1;
        adj[3][2] = 1;

        // edge 1 -- 3;
        adj[1][3] = 1;
        adj[3][1] = 1;

        ArrayList<ArrayList<Integer>> adjecency = new ArrayList<>();

        for (int i = 0; i <= n; i++){
            adjecency.add(new ArrayList<>());
        }
        // edge 1 -- 2
        adjecency.get(1).add(2);
        adjecency.get(2).add(1);

        // edge 2 -- 3;
        adjecency.get(2).add(3);
        adjecency.get(3).add(2);

        // edge 1 -- 3;
        adjecency.get(1).add(3);
        adjecency.get(3).add(1);

        for (int i = 1; i < n; i++){
            for (int j = 0; j < adjecency.get(i).size(); j++){
                System.out.print(adjecency.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            for(Integer a: adj.get(node)){
                if(vis[a] == false){
                    vis[a] = true;
                    q.add(a);
                }
            }
        }
        return bfs;
    }
    void dfsGraph(int i, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer> storeDfs){
        storeDfs.add(i);
        vis[i] = true;
        for(Integer it: adj.get(i)){
            if(vis[it] == false){
                dfsGraph(it, adj, vis, storeDfs);
            }
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V + 1];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(checkCycleBFS(adj, i, vis))
                    return true;
            }
        }
        return false;
    }
    class Node{
        int cur;
        int pre;
        Node(int cur, int pre){
            this.cur = cur;
            this.pre = pre;
        }
    }
    boolean checkCycleBFS(ArrayList<ArrayList<Integer>> adj, int node, boolean vis[]){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(node, -1));
        vis[node] = true;
        while(!q.isEmpty()){
            int nd = q.peek().cur;
            int pa = q.peek().pre;
            q.poll();
            for(Integer it : adj.get(nd)){
                if(!vis[it]){
                    q.add(new Node(it, nd));
                    vis[it] = true;
                }
                else if(it != pa) return true;
            }
        }
        return false;
    }
    boolean checkCycleDFS(int nd, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[nd] = true;
        for(Integer it: adj.get(nd)){
            if(!vis[it]){
                if(checkCycleDFS(it, nd, vis, adj)) return true;
            }
            else if(it != parent) return true;
        }
        return false;
    }
    boolean checkBipartiteBFS(ArrayList<ArrayList<Integer>>adj, int nd, int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(nd);
        color[nd] = 0;
        while(!q.isEmpty()){
            Integer n = q.poll();
            for(Integer it: adj.get(n)){
                if(color[it] == -1){
                    color[it] = 1 - color[n];
                    q.add(it);
                }else if(color[it] == color[n]){
                    return false;
                }
            }
        }
        return true;
    }
    boolean checkBipartiteDFS(ArrayList<ArrayList<Integer>>adj, int nd, int color[]){
        if(color[nd] == -1) color[nd] = 0;
        for (Integer it: adj.get(nd)){
            if(color[it] == -1){
                color[it] = 1 - color[nd];
                if(!checkBipartiteDFS(adj, it, color)) return false;
            }
            else if(color[it] == color[nd]) return false;
        }
        return true;
    }
    boolean checkCycleDirGraphDFS(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]){
        vis[node] = dfsVis[node] = 1;
        for(Integer it: adj.get(node)){
            if(vis[it] == 0){
                if(checkCycleDirGraphDFS(it, adj, vis, dfsVis)) return true;
            }
            else if(dfsVis[it] == 1) return true;
        }
        dfsVis[node] = 0;
        return false;
    }
    int[] topoSortDirGraphBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[V];
        int indegree[] = new int[V];
        for(int i = 0; i < V; i++){
            for(Integer it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0) q.add(i);
        }
        int index = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            topo[index++] = node;
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return topo;
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int vis[] = new int[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                findTopoSortDFS(i, adj, vis, st);
            }
        }
        int ans[] = new int[V];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }
    static void findTopoSortDFS(int node, ArrayList<ArrayList<Integer>> adj, int vis[], Stack<Integer> st){
        vis[node] = 1;
        for(Integer it: adj.get(node)){
            if(vis[it] == 0){
                findTopoSortDFS(it, adj, vis, st);
            }
        }
        st.push(node);
    }
    ///undirected\\\\
    static void shortestDistFromS(int V, ArrayList<ArrayList<Integer>> adj, int src) {
        int dist[] = new int[V];
        for(int i = 0; i < V; i++)
            dist[i] = 10000;
        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.add(src);
        while(!q.isEmpty()){
            Integer node = q.poll();
            for(Integer it: adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }
        for(int i: dist)
            System.out.print(i + " ");
    }
    boolean checkCycleDirGraphBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[V];
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            cnt++;
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        if (cnt == V) return false;
        return true;
    }
}
