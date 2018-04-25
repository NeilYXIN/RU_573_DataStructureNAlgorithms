import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class hw4_1 {
    public static void main(String[] args) throws IOException {

        DataLoader dataLoader = new DataLoader();
        List<String> data = dataLoader.loadData("./mediumEWG.txt");

        EdgeWeightedGraph G = new EdgeWeightedGraph(data);

        EdgeWeightedGraphCycle cycle = new EdgeWeightedGraphCycle(G);

    }



}
