import java.io.IOException;
import java.util.List;

public class hw4_5 {
    public static void main(String[] args) throws IOException {
        String filepath = "./NYC.txt";
        DataLoader dataLoader = new DataLoader();
        List<List<Integer>> data = dataLoader.loadData(filepath);
        EdgeWeightedGraph G = new EdgeWeightedGraph(data);
        //System.out.println( String.valueOf(data.get(0).get(0))   + " " + String.valueOf(data.get(1).get(0))   + " " + String.valueOf(data.get(2).get(2))   + " ");
        //System.out.println(G.adj(0));

        // DepthFirstSearch dfs = new DepthFirstSearch(G, 0);

        BreadthFirstSearch bfs = new BreadthFirstSearch(G, 0);


    }
}
