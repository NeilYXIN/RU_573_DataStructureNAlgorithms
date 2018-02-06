import java.util.ArrayList;
import java.util.List;

public class FarthestPair {
    public List findFathestPair(List<Double> nums)
    {
        double len = nums.size();
        List<Double> pair = new ArrayList<>();
        if(len < 2)
            return pair;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        // use one loop to maintain max and min
        for(int i = 0; i < len; i++)
        {
            if(nums.get(i) < min)
                min = nums.get(i);
            if(nums.get(i) > max)
                max = nums.get(i);
        }
        pair.add(min);
        pair.add(max);
        return pair;
    }
}
