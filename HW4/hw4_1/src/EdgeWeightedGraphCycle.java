import java.util.Stack;

public class EdgeWeightedGraphCycle {
    private boolean[] visited;
    private Edge[] edgeTo;
    private boolean[] onStack;
    private Stack<Edge> cycle;

    public EdgeWeightedGraphCycle(EdgeWeightedGraph G) {
        visited = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        onStack = new boolean[G.V()];

        for (int v = 0; v  < G.V(); v++) {
            if (!visited[v]) {
                dfs(G, v);
            }
        }

        if (cycle == null) {
            System.out.println("No cycle!");
        }
        else {
            System.out.println("Cycle exists.");
        }
    }

    public void dfs(EdgeWeightedGraph G, int v) {
        onStack[v] = true;
        visited[v] = true;
        for (Edge e: G.adj(v)) {
            int w = e.other(v);
            if (cycle != null) {
                return;
            }

            else if (!visited[w]) {
                edgeTo[w] = e;
                dfs(G, w);
            }
            else if (onStack[w]){
                cycle = new Stack<>();
                Edge f = e;
                while (f.either() != w) {
                    cycle.push(f);
                    f = edgeTo[f.either()];
                }
                cycle.push(f);
                return;
            }
        }
        onStack[v] = false;
    }


}
