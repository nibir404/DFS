import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v ; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v , int w){
        adj[v].add(w);
    }

    void DFSUtill(int v,boolean visited[]){
        visited[v] = true;
        System.out.println(v+" ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()){
            int n = i.next();
            if (!visited[n])
                DFSUtill(n,visited);
        }
    }

    void DFS(int v){
        boolean visited[] = new boolean[V];
        DFSUtill(v,visited);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(1,3);
        g.addEdge(3,0);
        g.addEdge(3,3);

        System.out.println("Following is Depth First Search Traversal"+"(Starting from vertex 2)");
        g.DFS(2);
    }
}
