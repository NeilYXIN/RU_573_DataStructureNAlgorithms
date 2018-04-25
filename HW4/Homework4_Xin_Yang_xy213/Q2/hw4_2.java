import java.io.IOException;
import java.util.List;

public class hw4_2 {
    public static void main(String[] args) throws IOException {
        DataLoader dataLoader = new DataLoader();
        List<String> data = dataLoader.loadData("./mediumEWG.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(data);

        Kruskal kmst = new Kruskal(G);
        Prim pmst = new Prim(G);
    }
}
