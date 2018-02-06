import java.sql.Time;
import java.util.Currency;
import java.util.List;

public class NaiveSearch {
   public int naiveSearch(List<Integer> nums)
   {
       int len = nums.size();
       int count = 0;
       Long startTime = System.currentTimeMillis();
       // naive search
       for(int i = 0; i < len - 2; i++)
       {
           for(int j = i + 1; j < len - 1; j++)
           {
               for(int k = j + 1; k < len; k++)
               {
                   if(nums.get(i) + nums.get(j) + nums.get(k) == 0)
                   {
                       count++;
                   }
               }
           }
       }
       Long stopTime = System.currentTimeMillis();
       Long duration = stopTime - startTime;
       System.out.println("Naive start time in ms: " + startTime);
       System.out.println("Naive stop time in ms: " + stopTime);
       System.out.println("Naive duration time in ms: " + duration);
       return count;
   }
}
