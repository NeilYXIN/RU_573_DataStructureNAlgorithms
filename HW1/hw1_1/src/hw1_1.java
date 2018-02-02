import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner6;
public class hw1_1 {
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

        NaiveSearch naiveSearch = new NaiveSearch();
        int naiveCount = naiveSearch.naiveSearch(nums);
        System.out.println("The result of naive count is: " + naiveCount);

        BinarySearch binarySearch = new BinarySearch();
        int binaryCount = binarySearch.binarySearch(nums);
        System.out.println("The result of binary count is: " + binaryCount);


    }
}
