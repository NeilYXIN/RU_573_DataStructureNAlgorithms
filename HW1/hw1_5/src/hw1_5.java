import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class hw1_5 {
    public static void main(String[] args) throws IOException {
        DataLoader dataLoader = new DataLoader();
        String filepath = "/Users/yx960203/Desktop/Code/DSA/HW1/hw1-1.data/";
        String filename = "self.txt";
        List<Integer> nums = null;
        if(args.length == 0)
        {
            nums = dataLoader.loadData(filepath + filename);
        }
        else if(args.length == 1)
        {
            nums = dataLoader.loadData(args[0]);
        }
        else
        {
            for(String i: args)
            {
                nums.add(Integer.valueOf(i));
            }
        }

        Fastest_3sum f3 = new Fastest_3sum();
        int result = f3.fastest_3sum(nums);
        System.out.println("The result of fastest 3-sum is: " + result);


    }
}
