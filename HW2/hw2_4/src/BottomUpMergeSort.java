import java.util.List;

public class BottomUpMergeSort {
    public int count = 0;
    public void bottomUpMergeSort(List<Integer> nums, List<Integer> temp) {
        int len = nums.size();

        for(int i = 1; i < len; i = i + i) {
            for(int lo = 0; lo < len - i; lo += i + i) {
                merge(nums, temp, lo, lo + i - 1, Math.min(lo + i + i - 1, len - 1));
            }
        }

    }

    public void merge(List<Integer> nums, List<Integer> temp, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            temp.set(k, nums.get(k));
        }

        for (int k = lo; k <= hi; k++) {
            count ++;
            if(i > mid) {
                nums.set(k, temp.get(j++));
            }
            else if(j > hi) {
                nums.set(k, temp.get(i++));
            }
            else if(temp.get(j) < temp.get(i)) {
                nums.set(k, temp.get(j++));
            }
            else {
                nums.set(k, temp.get(i++));
            }
        }
        count++;
    }
}
