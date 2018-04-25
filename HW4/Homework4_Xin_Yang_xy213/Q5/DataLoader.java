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
        List<List<Integer>> nums = new ArrayList<>();
        //int count = 0;
        while((s = br.readLine()) != null)
        {
            String[] temp = s.split(" ");
            List<Integer> elements = new ArrayList<>();
            for (int i = 0; i < temp.length; i++) {
                elements.add(Integer.parseInt(temp[i]));
            }
            nums.add(elements);
            //System.out.println(nums.get(count));
            //count++;

        }

        System.out.println("Load done!");
        return nums;
    }
}