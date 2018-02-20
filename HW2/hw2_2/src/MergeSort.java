import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public int count = 0;
    public int counter = 0;
    private List<Integer> temp;

    public MergeSort(List<Integer> nums1)
    {
        this.temp = new ArrayList<>(nums1);
    }
    public void mergeSort(List<Integer> nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2; // prevent overflow
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);

        merge(nums, lo, mid, hi);
    }

    public void merge(List<Integer> nums, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            temp.set(k, nums.get(k));
        }

        for (int k = lo; k <= hi; k++) {
            count++;
            if(i > mid) {
                nums.set(k, temp.get(j++));
            }
            else if(j > hi) {
                nums.set(k, temp.get(i++));
            }
            else if(temp.get(j) < temp.get(i)) {
                nums.set(k, temp.get(j++));
                counter += mid - i + 1;

            }
            else {
                nums.set(k, temp.get(i++));
            }
        }
        count++;
    }

}
