import java.util.LinkedList;
import java.util.Queue;

public class Prim {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] visited;
    private IndexMinPQ<Double> pq;


    public Prim(EdgeWeightedGraph G) {
        Long start = System.currentTimeMillis();

        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        visited = new boolean[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.MAX_VALUE;

        for (int v = 0; v < G.V(); v++)
            if (!visited[v]) prim(G, v);

        Long end = System.currentTimeMillis();

        System.out.println("Prim total weight: " + weight() + " Duration: " + (end - start));
    }

    private void prim(EdgeWeightedGraph G, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }

    private void scan(EdgeWeightedGraph G, int v) {
        visited[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (visited[w]) continue;
            if (e.getWeight() < distTo[w]) {
                distTo[w] = e.getWeight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new LinkedList<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.add(e);
            }
        }
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.getWeight();
        return weight;
    }

}

