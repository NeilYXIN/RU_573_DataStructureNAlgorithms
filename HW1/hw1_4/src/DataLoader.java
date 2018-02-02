import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public List loadData(String filepath) throws IOException {
        File file = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = null;
        List<Double> nums = new ArrayList<>();
        while((s = br.readLine()) != null)
        {
            nums.add(Double.valueOf(s));
        }
        /*
        for(int i = 0; i < nums.size(); i++)
        {
            System.out.println(nums.get(i));
        }
        */
        return nums;
    }
}
