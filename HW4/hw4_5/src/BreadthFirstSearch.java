import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public BreadthFirstSearch(EdgeWeightedGraph G, int s) {
        boolean visited[] = new boolean[G.V()];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (Edge e: G.adj(v)) {
                if (!visited[e.other(v)]) {
                    q.add(e.other(v));
                    visited[e.other(v)] = true;
                    System.out.println("BFS Visited: " + e.other(v));
                }
            }
        }

    }
}
