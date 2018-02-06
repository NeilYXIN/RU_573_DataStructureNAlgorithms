import java.io.IOException;
import java.util.List;

public class hw1_2 {

    public static void main(String[] args) throws IOException {
        DataLoader dataLoader = new DataLoader();
        String filepath = "/Users/yx960203/Desktop/Code/DSA/HW1/hw1-2.data/";
        String filename = "8pair.txt";
        List<List<Integer>> data = null;
        List<Integer> p1 = null;
        List<Integer> q1 = null;
        List<Integer> p2 = null;
        List<Integer> q2 = null;
        List<Integer> p3 = null;
        List<Integer> q3 = null;
        if(args.length == 0)
        {
            data = dataLoader.loadData(filepath + filename);
        }
        else
        {
            data = dataLoader.loadData(args[0]);
        }
        p1 = data.get(0);
        q1 = data.get(1);
        p2 = data.get(0);
        q2 = data.get(1);
        p3 = data.get(0);
        q3 = data.get(1);
        int len = p1.size();

        // QuickFind
        Long qfStartTime = System.currentTimeMillis();
        QuickFindUF qf = new QuickFindUF(8192);
        for(int i = 0; i < len; i++)
        {
            if(!qf.connected(p1.get(i), q1.get(i)))
                qf.union(p1.get(i), q1.get(i));
        }
        Long qfStopTime = System.currentTimeMillis();
        Long qfduration = qfStopTime - qfStartTime;
        System.out.println("Quick Find Duration time(ms): " + qfduration);
        System.out.println();

        // QuickUnion
        Long quStartTime = System.currentTimeMillis();
        QuickUnionUF qu = new QuickUnionUF(8192);
        for(int i = 0; i < len; i++)
        {
            if(!qu.connected(p2.get(i), q2.get(i)))
                qu.union(p2.get(i), q2.get(i));
        }
        Long quStopTime = System.currentTimeMillis();
        Long quduration = quStopTime - quStartTime;
        System.out.println("Quick Union Duration time(ms): " + quduration);
        System.out.println();

        // WeightedUnion
        Long wuStartTime = System.currentTimeMillis();
        WeightedUnionUF wu = new WeightedUnionUF(8192);
        for(int i = 0; i < len; i++)
        {
            if(!wu.connected(p3.get(i), q3.get(i)))
                wu.union(p3.get(i), q3.get(i));
        }
        Long wuStopTime = System.currentTimeMillis();
        Long wuduration = wuStopTime - wuStartTime;
        System.out.println("Weighted Union Duration time(ms): " + wuduration);
    }
}
