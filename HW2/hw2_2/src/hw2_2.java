import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hw2_2 {

    public static void main(String[] args) throws IOException {
        DataLoader dataLoader = new DataLoader();
        // load data
        String filepath = "/Users/yx960203/Desktop/Code/DSA/HW2/dataset-problem2-hw2/";
        String filename1 = "data0.1024";
        String filename2 = "data1.1024";

        List<Integer> nums0 = null;
        List<Integer> nums1 = null;

        nums0 = dataLoader.loadData(filepath + filename1);
        nums1 = dataLoader.loadData(filepath + filename2);
        if(args.length == 0)
        {
            nums0 = dataLoader.loadData(filepath + filename1);
            nums1 = dataLoader.loadData(filepath + filename2);

        }
        else if (args.length == 2)
        {
            nums0 = dataLoader.loadData(args[0]);
            nums1 = dataLoader.loadData(args[1]);

        }
        else {
            System.out.println("Invalid argumenrs!");
        }

        long startTime = System.currentTimeMillis();
        KendallTauDistance ktd = new KendallTauDistance();
        ktd.kendallTauDistance(nums0, nums1);
        long stopTime = System.currentTimeMillis();

        System.out.println("Time duration: " + (stopTime - startTime));

    }
}
