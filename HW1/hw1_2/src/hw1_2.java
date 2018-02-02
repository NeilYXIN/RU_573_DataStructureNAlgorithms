import java.io.IOException;
import java.util.List;

public class hw1_2 {

    public static void main(String[] args) throws IOException {
        DataLoader dataLoader = new DataLoader();
        String filepath = "/Users/yx960203/Desktop/Code/DSA/HW1/hw1-2.data/";
        String filename = "8192pair.txt";
        List<List<Integer>> data = null;
        List<Integer> p = null;
        List<Integer> q = null;
        if(args.length == 0)
        {
            data = dataLoader.loadData(filepath + filename);
        }
        else
        {
            data = dataLoader.loadData(args[0]);
        }
        p = data.get(0);
        q = data.get(1);
        int len = p.size();

        // QuickFind
        Long qfStartTime = System.currentTimeMillis();
        QuickFindUF qf = new QuickFindUF(8192);
        for(int i = 0; i < len; i++)
        {
            if(!qf.connected(p.get(i), q.get(i)))
                qf.union(p.get(i), q.get(i));
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
            if(!qu.connected(p.get(i), q.get(i)))
                qu.union(p.get(i), q.get(i));
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
            if(!wu.connected(p.get(i), q.get(i)))
                wu.union(p.get(i), q.get(i));
        }
        Long wuStopTime = System.currentTimeMillis();
        Long wuduration = wuStopTime - wuStartTime;
        System.out.println("Weighted Union Duration time(ms): " + wuduration);
    }
}
