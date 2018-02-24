import java.util.List;

public class ShellSort {
    private int[] steps;

    ShellSort(int[] steps)
    {
        this.steps = steps;
    }

    public void shellSort(List<Integer> nums)
    {
        int count = 0;
        int len = nums.size();
        int stepSize = steps.length;
        for(int stepindex = 0; stepindex < stepSize; stepindex++)
        {
            int step = steps[stepindex];

            for(int i = 0; i < len; i++)
            {
                //int temp = i + step;
                for(int temp = i + step; temp < len && temp - step >= 0; temp-=step)
                {
                    if(nums.get(temp) < nums.get(temp - step))
                    {
                        count++;
                        int t = nums.get(temp);
                        nums.set(temp, nums.get(temp - step));
                        nums.set(temp - step, t);
                    }
                }
                count++;
            }

        }

        System.out.println("Comparisons in Shell Sort: " + count);

        int flag = 0;
        for(int i = 0; i < len; i++)
        {
            //System.out.println(Integer.toString(nums.get(i)));
            if(i + 1 < len && nums.get(i + 1) < nums.get(i))
            {
                flag = 1;
            }
        }
        System.out.println(Integer.toString(flag));

    }


}
