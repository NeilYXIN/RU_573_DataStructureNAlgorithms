import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph {
    private int V; // number of vertices
    private int E; // number of edges
    private Bag<Edge>[] adj;




    public EdgeWeightedGraph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        }
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    public EdgeWeightedGraph(List<List<Integer>> data) {
        this(data.get(0).get(0));
        if (data.get(1).get(0) < 0) {
            throw new IllegalArgumentException("Number of edges must be nonnegative");
        }
        for (int i = 2; i < data.size(); i++) {
            Edge e = new Edge(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2));
            addEdge(e);
            // System.out.println(i);

        }

    }


    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }


    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        //adj[w].add(e);
        this.E++;
    }


    /**
    public static void main(String[] args) throws IOException {
        String filepath = "./NYC.txt";
        DataLoader dataLoader = new DataLoader();
        List<List<Integer>> data = dataLoader.loadData(filepath);
        EdgeWeightedGraph G = new EdgeWeightedGraph(data);
        System.out.println( String.valueOf(data.get(0).get(0))   + " " + String.valueOf(data.get(1).get(0))   + " " + String.valueOf(data.get(2).get(2))   + " ");

    }
     */
}
