import java.io.IOException;
import java.util.List;

public class DjikstraSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public DjikstraSP(EdgeWeightedDigraph G, int s) {
        for (DirectedEdge e: G.edges()) {
            if (e.getWeight() < 0) {
                throw new IllegalArgumentException("Edge "  + e + " has negative weight");
            }
        }

        distTo = new double[(int)G.V()];
        edgeTo = new DirectedEdge[(int)G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq = new IndexMinPQ<Double>((int)G.V());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e: G.adj(v)) {
                relax(e);
            }
        }

        for (int i = 0; i < distTo.length; i++) {
            System.out.println("distTo " + i + ": " + distTo[i]);
        }

        for (int i = 1; i < edgeTo.length; i++) {
            System.out.println("edgeTo " + i + ": " + edgeTo[i].from() + " to " + edgeTo[i].to());
        }
    }

    public void relax(DirectedEdge e) {
        double v = e.from();
        double w = e.to();
        if (distTo[(int)w] > distTo[(int)v] + e.getWeight()) {
            distTo[(int)w] = distTo[(int)v] + e.getWeight();
            edgeTo[(int)w] = e;
            if (pq.contains((int)w)) {
                pq.decreaseKey((int)w, distTo[(int)w]);
            }
            else {
                pq.insert((int)w, distTo[(int)w]);
            }
        }
    }




}
