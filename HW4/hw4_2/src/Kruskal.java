import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Kruskal {
    private double weight;
    private Queue<Edge> mst = new LinkedList<>();

    public Iterable<Edge> edges() {
        return mst;
    }

    public Kruskal(EdgeWeightedGraph G) {
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e: G.edges()) {
            pq.insert(e);
        }

        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v,w)) {
                uf.union(v,w);
                mst.add(e);
                weight+=e.getWeight();
            }
        }

        for (Edge e: mst) {
            System.out.println(e.either() + " " + e.other(e.either()) + " " + e.getWeight());
        }
        System.out.println();
        System.out.println("Total weight: " + weight);
    }


}
