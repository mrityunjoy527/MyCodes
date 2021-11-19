package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class ShortestDistanceFromSource {

    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(5).add(new Pair(3, 1));
        primsAlgo(n, adj);
    }
    static class Pair implements Comparator<Pair>{
        int V;
        int weight;
        Pair(int V, int weight){
            this.V = V;
            this.weight = weight;
        }
        public int getV() {
            return V;
        }
        public int getWeight() {
            return weight;
        }
        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.getWeight() < o2.getWeight()) return -1;
            if(o1.getWeight() > o2.getWeight()) return 1;
            return 0;
        }
    }
    static void findTopoSortDFS(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st){
        vis[node] = 1;
        for(Pair it: adj.get(node)){
            if(vis[it.getV()] == 0){
                findTopoSortDFS(it.getV(), adj, vis, st);
            }
        }
        st.push(node);
    }
    /** find shortest distance from src in an directed acyclic graph with edge weights **/
    static void shortestDistFromSDir(int V, ArrayList<ArrayList<Pair>> adj, int src){
        Stack<Integer> st = new Stack<>();
        int vis[] = new int[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                findTopoSortDFS(i, adj, vis, st);
            }
        }
        int dist[] = new int[V];
        for(int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        while (!st.isEmpty()){
            int node = st.pop();
            if(dist[node] != Integer.MAX_VALUE){
                for (Pair it: adj.get(node)){
                    if(dist[node] + it.getWeight() < dist[it.getV()]){
                        dist[it.getV()] = dist[node] + it.getWeight();
                    }
                }
            }
        }
        for(int i: dist){
            if(i == Integer.MAX_VALUE) System.out.print("INF ");
            else System.out.print(i + " ");
        }
    }
    /** find shortest distance from src in an undirected graph with edge weights //  Dijkstra's Algorithm **/
    static void dijkstaAlgo(int V, ArrayList<ArrayList<Pair>> adj, int src){
        int dist[] = new int[V];
        for(int i = 0; i < V; i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()){
            Pair node = pq.poll();
            for (Pair it: adj.get(node.getV())){
                if(node.getWeight() + it.getWeight() < dist[it.getV()]){
                    dist[it.getV()] = node.getWeight() + it.getWeight();
                    pq.add(new Pair(it.getV(), dist[it.getV()]));
                }
            }
        }
        for(int i: dist){
            if(i == Integer.MAX_VALUE) System.out.print("INF ");
            else System.out.print(i + " ");
        }
    }
    /** minimum spanning tree **/
    static void primsAlgo(int V, ArrayList<ArrayList<Pair>> adj) {
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];
        int parent[] = new int[V];
        for (int i = 0; i < V; i++) {
            key[i] = 100000;
            mstSet[i] = false;
            parent[i] = -1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        key[0] = 0;
        pq.add(new Pair(0, key[0]));
        for (int i = 0; i < V - 1; i++) {
            int node = pq.poll().getV();
            mstSet[node] = true;
            for (Pair it : adj.get(node)) {
                if (mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = node;
                    pq.add(new Pair(it.getV(), key[it.getV()]));
                }
            }
        }
        for (int i = 0; i < V; i++){
            System.out.println(parent[i] + "-" + i);
        }
    }
}
