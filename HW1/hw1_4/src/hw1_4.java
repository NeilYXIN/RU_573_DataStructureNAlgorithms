import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hw1_4 {
    public static void main(String[] args) throws IOException {
        DataLoader dataLoader = new DataLoader();
        // set default path
        String filepath = "/Users/yx960203/Desktop/Code/DSA/HW1/";
        String filename = "1_4.txt";
        List<Double> nums = new ArrayList<>();
        // load data
        // use txt, default path
        if(args.length == 0)
        {
            nums = dataLoader.loadData(filepath + filename);
        }
        // use txt, path input by user
        else if(args.length == 1)
        {
            nums = dataLoader.loadData(args[0]);
        }
        // use input data
        else
        {
            for(String i: args)
            {
                nums.add(Double.valueOf(i));
            }
        }
        /*
        // print loaded data
        for(double i :nums)
        {
            System.out.println(i);
        }
        */
        FarthestPair fp = new FarthestPair();
        List<Double> result = fp.findFathestPair(nums);
        System.out.println("Farthest pair: " + result.get(0) + ", " + result.get(1));
    }
}
