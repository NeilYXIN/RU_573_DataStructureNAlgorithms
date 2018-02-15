import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public int count = 0;
    public void mergeSort(List<Integer> nums, List<Integer> res, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2; // prevent overflow
        mergeSort(res, nums, lo, mid);
        mergeSort(res, nums, mid + 1, hi);

        merge(res, nums, lo, mid, hi);
    }

    public void merge(List<Integer> nums, List<Integer> res, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            count++;
            if(i > mid) {
                res.set(k, nums.get(j++));
            }
            else if(j > hi) {
                res.set(k, nums.get(i++));
            }
            else if(nums.get(j) < nums.get(i)) {
                res.set(k, nums.get(j++));
            }
            else {
                res.set(k, nums.get(i++));
            }
        }
        count++;
    }

}
