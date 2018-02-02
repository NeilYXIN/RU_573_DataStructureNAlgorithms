import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public int binarySearch(List<Integer> nums)
    {
        int count = 0;
        Collections.sort(nums);
        int len = nums.size();
        Long startTime = System.currentTimeMillis();

        for(int i = 0; i < len - 1; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                int left = j + 1;
                int right = len - 1;
                while(left <= right)
                {
                    int mid = (left + right) / 2;
                    if(nums.get(mid) + nums.get(i) + nums.get(j) == 0)
                    {
                        if(nums.get(mid) >= nums.get(j))
                        {
                            count++;
                            int tempplus = mid;
                            int tempminus = mid;
                            while(tempplus + 1 < len && nums.get(tempplus + 1) + nums.get(i) + nums.get(j) == 0)
                            {
                                tempplus = tempplus + 1;
                                count++;
                            }
                            while(tempminus - 1 >= 0 && nums.get(tempminus - 1) + nums.get(i) + nums.get(j) == 0 && tempminus - 1 != j)
                            {
                                tempminus = tempminus - 1;
                                count++;
                            }
                        }
                        break;
                    }
                    else if(nums.get(mid) + nums.get(i) + nums.get(j) > 0)
                    {
                        right = mid - 1;
                    }
                    else if(nums.get(mid) + nums.get(i) + nums.get(j) < 0)
                    {
                        left = mid + 1;
                    }
                }
            }

        }
        Long stopTime = System.currentTimeMillis();
        Long duration = stopTime - startTime;
        System.out.println("Binary start time in nano secs: " + startTime);
        System.out.println("Binary stop time in nano secs: " + stopTime);
        System.out.println("Binary duration time in nano secs: " + duration);

        return count;
    }
}
