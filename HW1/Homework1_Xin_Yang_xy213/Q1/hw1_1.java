import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

import static java.lang.Thread.sleep;

public class hw1_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        DataLoader dataLoader = new DataLoader();
        // load data
        String filepath = "./hw1-1.data/";
        String filename = "8int.txt";
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

        // run naive search
        NaiveSearch naiveSearch = new NaiveSearch();
        int naiveCount = naiveSearch.naiveSearch(nums);
        System.out.println("The result of naive count is: " + naiveCount);

        // run binary search
        BinarySearch binarySearch = new BinarySearch();
        int binaryCount = binarySearch.binarySearch(nums);
        System.out.println("The result of binary count is: " + binaryCount);


    }
}
