import java.io.IOException;
import java.util.List;

public class hw2_5 {
    public static void main(String[] args) throws IOException {
        DataLoader dl = new DataLoader();
        String filepath = "/Users/yx960203/Desktop/Code/DSA/HW2/dataset-problem2-hw2/";
        String filename = "data1.32768";
        List<Integer> nums = dl.loadData(filepath + filename);

        QuickSort qs = new QuickSort();
        qs.quickSort(nums, 0, nums.size() - 1);

        for(int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }

    }

}
