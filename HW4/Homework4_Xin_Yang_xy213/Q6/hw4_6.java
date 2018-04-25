import java.io.IOException;
import java.util.List;

public class hw4_6 {
    public static void main(String[] args) throws IOException {
        DataLoader dataLoader = new DataLoader();
        List<String> data = dataLoader.loadData("./dataa.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(data);
        DjikstraSP djikstraSP = new DjikstraSP(G, 0);



    }
}
