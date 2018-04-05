
public class DepthFirstSearch {

    private boolean[] visited;
    private int count;

    public DepthFirstSearch(EdgeWeightedGraph G, int s) {
        visited = new boolean[G.V()];
        dfs(G, s);
    }

    public void dfs(EdgeWeightedGraph G, int v) {
        count++;
        visited[v] = true;
        System.out.println(count + " Visited: " + v);

        for (Edge e: G.adj(v)) {
            if (!visited[e.other(v)]) {
                dfs(G, e.other(v));
            }
        }
    }

}
