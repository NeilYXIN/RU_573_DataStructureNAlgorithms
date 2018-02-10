import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hw2_1 {


    public static void main(String[] args) throws IOException {
        DataLoader dataLoader = new DataLoader();
        // load data
        String filepath = "/Users/xinyang/Desktop/Code/DSA/HW1/hw1-1.data/";
        String filename = "8192int.txt";
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

        List<Integer> numsCopy = new ArrayList<>(nums);
        int steps[] = { 7, 3, 1 };
        ShellSort ss = new ShellSort(steps);
        ss.shellSort(nums);

        InsertionSort is = new InsertionSort();
        is.insertionSort(numsCopy);

    }
}
