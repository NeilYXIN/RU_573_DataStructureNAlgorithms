import java.util.List;

public class InsertionSort {
    private int count = 0;
    public List insertionSort(List<Integer> nums, int lo, int hi) {
        for(int i = lo + 1; i <= hi; i++) {
            for(int temp = i; temp > lo; temp--) {
                count++;
                if(nums.get(temp) < nums.get(temp - 1)){
                    swap(nums, temp, temp - 1);
                }
            }
        }
/*
        for(int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
*/
        return nums;
    }

    public List swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
        return nums;
    }

    public int getCount() {
        return count;
    }
}
