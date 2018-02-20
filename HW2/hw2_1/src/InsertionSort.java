import java.util.List;

public class InsertionSort {

    public void insertionSort(List<Integer> nums)
    {
        int len = nums.size();
        int count = 0;
        for(int i = 0; i < len - 1; i++)
        {
            int temp = i + 1;
            while(temp - 1 >= 0 && nums.get(temp) < nums.get(temp - 1))
            {
                count++;
                int t = nums.get(temp);
                nums.set(temp, nums.get(temp - 1));
                nums.set(temp - 1, t);
                temp--;
            }
            count++;

        }
        System.out.println("Comparisons in Insertion Sort: " + count);
        int flag = 0;
        for(int i = 0; i < len; i++)
        {
            //System.out.println(nums.get(i));
            if(i + 1 < nums.size() && nums.get(i + 1) < nums.get(i))
            {
                flag = 1;
            }
        }
        System.out.println(Integer.toString(flag));

    }
}
