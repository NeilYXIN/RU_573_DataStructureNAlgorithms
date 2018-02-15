import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hw2_4 {
    public static void main(String[] args) throws IOException {
        DataLoader dl = new DataLoader();
        String filepath = "/Users/yx960203/Desktop/Code/DSA/HW2/dataset-problem2-hw2/";
        String filename = "data1.2048";
        List<Integer> nums1 = dl.loadData(filepath + filename);
        List<Integer> temp1 = new ArrayList<>(nums1);
        List<Integer> nums2 = new ArrayList<>(nums1);
        List<Integer> temp2 = new ArrayList<>(nums1);
        List<Integer> nums3 = new ArrayList<>(nums1);
        List<Integer> temp3 = new ArrayList<>(nums1);

        /*
        // MergeSort
        MergeSort ms = new MergeSort();
        ms.mergeSort(temp1, nums1, 0, nums1.size() - 1);

        System.out.println("MergeSort: ");
        for(int i = 0; i < nums1.size(); i++)
        {
            System.out.println(nums1.get(i));
        }
        System.out.println("Comparison MergeSort: " + ms.count);

        System.out.println();

        // BottomUpMergeSort
        BottomUpMergeSort bms = new BottomUpMergeSort();
        bms.bottomUpMergeSort(nums2, temp2);

        System.out.println("BottomUpMergeSort: ");
        for(int i = 0; i < nums2.size(); i++)
        {
            System.out.println(nums2.get(i));
        }

        System.out.println("Comparison BottomUpMergeSort: " + bms.count);

        System.out.println();
*/

        // MergeSortWithInsertionSort
        MergeSortWithInsertion msi = new MergeSortWithInsertion();
        msi.mergeSortWithInsertion(nums3, temp3, 0, nums3.size() - 1);
        for(int i = 0; i < nums3.size(); i++)
        {
            System.out.println(nums3.get(i));
        }
        System.out.println("Comparison MergeSortWithInsertionSort: " + msi.count);

    }
}
