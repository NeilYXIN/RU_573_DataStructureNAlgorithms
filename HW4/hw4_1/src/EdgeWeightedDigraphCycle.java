import java.util.Stack;

public class EdgeWeightedDigraphCycle {
    private boolean[] visited;
    private DirectedEdge[] edgeTo;
    private boolean[] onStack;
    private Stack<DirectedEdge> cycle;

    public EdgeWeightedDigraphCycle(EdgeWeightedDigraph G) {
        visited = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];
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

    public void dfs(EdgeWeightedDigraph G, int v) {
        onStack[v] = true;
        visited[v] = true;
        for (DirectedEdge e: G.adj(v)) {
            int w = e.to();
            if (cycle != null) {
                return;
            }

            else if (!visited[w]) {
                edgeTo[w] = e;
                dfs(G, w);
            }
            else if (onStack[w]){
                cycle = new Stack<>();
                DirectedEdge f = e;
                while (f.from() != w) {
                    cycle.push(f);
                    f = edgeTo[f.from()];
                }
                cycle.push(f);
                return;
            }
        }
        onStack[v] = false;
    }


}
