import java.util.List;

public class FindDistance {
    public void findDistance(List<Integer> nums0, List<Integer> nums1)
    {
        int len = nums0.size();
        int[] index = new int[len + 1];

        for(int i = 0; i < len; i++)
        {
            index[nums0.get(i)] = i;
        }
        int count = 0;
        for(int i = 0; i < len - 1; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                if(index[nums1.get(i)] > index[nums1.get(j)])
                {
                    count++;
                }
            }
        }

        System.out.println("count: " + count);
    }
}
// 0 1 2 3 4
// 2 3 1 4 5 - 1
// 3 2 4 5 1