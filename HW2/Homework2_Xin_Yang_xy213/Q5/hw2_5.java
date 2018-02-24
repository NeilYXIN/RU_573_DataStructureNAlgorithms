import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class hw2_5 {
    public static void main(String[] args) throws IOException {
        DataLoader dl = new DataLoader();
        String filepath = "../dataset-problem2-hw2/";
        String filename = "data1.32768";

        List<Integer> nums;

        if(args.length == 0)
        {
            nums = dl.loadData(filepath + filename);
        }
        else
        {
            nums = dl.loadData(args[0]);
        }
        List<Integer> nums1 = new ArrayList<>(nums);


        /**
         * Quick Sort with median-of-three
         */
        QuickSort qs = new QuickSort();
        long startTime = System.currentTimeMillis();
        qs.quickSort(nums, 0, nums.size() - 1);
        long stopTime = System.currentTimeMillis();
        System.out.println("Duration Time of QuickSort with median-of-three: " + (stopTime - startTime));
        System.out.println("Comparison: " + qs.count);



        /**
         * Quick Sort with median-of-three and cut-off
         */
        QuickSortCutOff qsco = new QuickSortCutOff();
        qsco.setCUTOFF(10); // change to set cut off
        long startTime2 = System.currentTimeMillis();
        qsco.quickSort(nums1, 0, nums.size() - 1);
        long stopTime2 = System.currentTimeMillis();
        System.out.println("Duration Time of QuickSort with median-of-three and cutoff: " + (stopTime2 - startTime2));
        System.out.println("Comparison: " + qsco.count);

    }


}
