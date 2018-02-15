import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hw2_2 {

    public static void main(String[] args) throws IOException {
        DataLoader dataLoader = new DataLoader();
        // load data
        String filepath = "/Users/yx960203/Desktop/Code/DSA/HW2/dataset-problem2-hw2/";
        String filename1 = "data0.2048";
        String filename2 = "data1.2048";


        List<Integer> nums0 = null;
        List<Integer> nums1 = null;

        nums0 = dataLoader.loadData(filepath + filename1);
        nums1 = dataLoader.loadData(filepath + filename2);

        FindDistance fd = new FindDistance();
        fd.findDistance(nums0, nums1);



    }
}
