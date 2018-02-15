import java.util.List;

public class QuickSort {
    public void quickSort(List<Integer> nums, int lo, int hi){
        if (lo < hi) {
            medianOfThree(nums, lo, hi);
            int pivotIndex = hi - 1;

            int i = lo + 1;
            int j = pivotIndex - 1;

            while (i < j) {
                while (nums.get(i) < nums.get(pivotIndex)) {
                    i++;
                }

                while (j > lo && nums.get(j) > nums.get(pivotIndex)) {
                    j--;
                }
                if (i < j) {
                    swap(nums, i, j);
                }
                else {
                    break;
                }
            }
            if(i < pivotIndex) {
                swap(nums, i, pivotIndex);
            }

            quickSort(nums, lo, i - 1);
            quickSort(nums, i + 1, hi);


        }

    }

    public void medianOfThree(List<Integer> nums, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums.get(lo) > nums.get(mid)) {
            swap(nums, lo, mid);
        }
        if (nums.get(lo) > nums.get(hi)) {
            swap(nums, lo, hi);
        }
        if (nums.get(mid) > nums.get(hi)) {
            swap(nums, mid, hi);
        }

        swap(nums, mid, hi - 1);
    }

    public void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }


}
