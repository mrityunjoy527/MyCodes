package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Node{
    int u, v, weight;
    Node(int _u, int _v, int _weight){
        _u = u;
        _v = v;
        _weight = weight;
    }
    public int getU() {
        return u;
    }
    public int getV() {
        return v;
    }
    public int getWeight() {
        return weight;
    }
}
class SortComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        if(o1.getWeight() < o2.getWeight()) return -1;
        if(o1.getWeight() > o2.getWeight()) return 1;
        return 0;
    }
}

/** union by rank and path compression **/
public class DisjointSet {
    static int[] parent = new int[100000];
    static int[] rank = new int[100000];
    static int n;
    static void makeSet(){
        for(int i = 1; i <= n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    static int findParent(int n, int parent[]){
        if(parent[n] == n){
            return n;
        }
        // path compression
        return parent[n] = findParent(parent[n], parent);
    }
    //union by rank
    static void union(int u, int v, int parent[], int rank[]){
        u = findParent(u, parent);
        v = findParent(v, parent);
        if(rank[u] < rank[v]){
            parent[u] = v;
        }else if(rank[v] < rank[u]){
            parent[v] = u;
        }else{
            parent[v] = u; // parent[u] = v; rank[v]++;
            rank[u]++;
        }
    }
    static void KruskalsAlgo(ArrayList<Node> adj, int N){
        Collections.sort(adj, new SortComparator());
        int[] parent = new int[N];
        int[] rank = new int[N];
        for(int i = 0; i < N; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        int costMST = 0;
        ArrayList<Node> mst = new ArrayList<>();
        for (Node it: adj){
            if(findParent(it.getU(), parent) != findParent(it.getV(), parent)){
                costMST += it.getWeight();
                mst.add(it);
                union(it.getU(), it.getV(), parent, rank);
            }
        }
        System.out.println(costMST);
        for (Node it: mst){
            System.out.print(it.getU() + "-" + it.getWeight());
        }
    }
    public static void main(String[] args) {

    }
}
