import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public List<List<Integer>> loadData(String filepath) throws IOException {
        File file = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = null;
        List<List<Integer>> data = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        List<Integer> q = new ArrayList<>();
        while((s = br.readLine()) != null)
        {
            String[] temp = s.split(" ");
            p.add(Integer.valueOf(temp[0]));
            q.add(Integer.valueOf(temp[1]));
        }
        for(int i = 0; i < p.size(); i++)
        {
            //System.out.println(p.get(i) + " " + q.get(i));
        }
        System.out.println();
        data.add(p);
        data.add(q);
        return data;
    }
}

