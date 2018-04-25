import java.util.Iterator;
import java.util.Stack;

public class DepthFirstSearch {

    private boolean[] visited;
    private int count;

    public DepthFirstSearch(EdgeWeightedGraph G, int s) {
        visited = new boolean[G.V()];

        int count = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);
        visited[s] = true;
        while (!stack.empty()) {
            int v = stack.pop();
            System.out.println(++count + " DFS Visited: " + v);

            for (Edge e : G.adj(v)) {
                int w = e.other(v);
                if (!visited[w]) {
                    //dfsEdgeTo[w] = v;
                    stack.push(w);
                    visited[w] = true;

                }
            }
        }
    }




}
