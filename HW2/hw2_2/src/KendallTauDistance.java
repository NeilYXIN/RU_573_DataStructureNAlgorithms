import java.util.ArrayList;
import java.util.List;

public class KendallTauDistance {
    public void kendallTauDistance(List<Integer> nums0, List<Integer> nums1) {
        int len = nums0.size();
        List<Integer> nums0Index = new ArrayList<>(nums0);
        for (int i = 0; i < len; i++) {
            nums0Index.set(nums0.get(i) - 1, i);
        }
        List<Integer> nums1Index = new ArrayList<>(nums0);
        for (int i = 0; i < len; i++) {
            nums1Index.set(i, nums0Index.get(nums1.get(i) - 1));
        }
        MergeSort ms = new MergeSort(nums0);
        ms.mergeSort(nums1Index,0, len - 1);
        System.out.println("distance： " + ms.counter);
    }
}
