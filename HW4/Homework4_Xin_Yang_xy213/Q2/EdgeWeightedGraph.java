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

    public EdgeWeightedGraph(List<String> data) {
        this(Integer.parseInt(data.get(0)));
        int E = Integer.parseInt(data.get(1));
        for (int i = 2; i < E + 2; i++) {
            String[] temp = new String[3];
            temp = data.get(i).split(" ");
            Edge e = new Edge(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]), Double.parseDouble(temp[2]));
            addEdge(e);
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
        adj[w].add(e);
        this.E++;
        //System.out.println(e.either()+" "+e.other(e.either())+" "+e.getWeight());
    }

    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
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
