import java.util.List;

public class EdgeWeightedDigraph {
    private int V;
    private int E;
    private Bag<DirectedEdge>[] adj;
    private int[] indegree;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        this.indegree = new int[V];
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<DirectedEdge>();
        }

    }

    public EdgeWeightedDigraph(List<String> data) {
        this(Integer.parseInt(data.get(0)));
        int E = Integer.parseInt(data.get(1));
        for (int i = 2; i < E + 2; i++) {
            String[] temp = new String[3];
            temp = data.get(i).split(" ");
            DirectedEdge e = new DirectedEdge(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]), Double.parseDouble(temp[2]));
            addEdge(e);
        }

    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        indegree[w]++;
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> list = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e: adj(v)) {
                list.add(e);
            }
        }
        return list;
    }

    public int indegree(int v) {
        return indegree[v];
    }


}
