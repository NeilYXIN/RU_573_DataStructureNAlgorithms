import java.util.List;

public class MergeSortWithInsertion {
    public static int CUTOFF = 7;
    public int count = 0;
    public void mergeSortWithInsertion(List<Integer> nums, List<Integer> temp, int lo, int hi) {
        InsertionSort is = new InsertionSort();
        int mid = lo + (hi - lo) / 2;

        if ((hi - lo) < CUTOFF) {
            is.insertionSort(nums, lo, hi);
            count+=is.getCount();
        }
        else {
            mergeSortWithInsertion(nums, temp, lo, mid);
            mergeSortWithInsertion(nums, temp, mid + 1, hi);
            merge(nums, temp, lo, mid, hi);

        }

    }

    public void merge(List<Integer> nums, List<Integer> temp, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            temp.set(k, nums.get(k));
        }

        for (int k = lo; k <= hi; k++) {
            if(i > mid) {
                nums.set(k, temp.get(j++));
            }
            else if(j > hi) {
                nums.set(k, temp.get(i++));
            }
            else if(temp.get(j) < temp.get(i)) {
                nums.set(k, temp.get(j++));
                count++;
            }
            else {
                nums.set(k, temp.get(i++));
                count++;
            }
        }
    }

    public void setCUTOFF(int i) {
        CUTOFF = i;
    }

}
