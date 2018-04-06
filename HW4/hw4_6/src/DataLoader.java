import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataLoader {
    public List loadData(String filepath) throws IOException {
        File file = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = null;
        List<String> lines = new ArrayList<>();
        while((s = br.readLine()) != null)
        {
            lines.add(s);
        }

        System.out.println("Load done!");
        return lines;
    }
}