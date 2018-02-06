import java.util.List;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }
    }

    // determine connected or not
    public boolean connected(int p, int q)
    {
        return id[p] == id[q];
    }

    // union two components
    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++)
        {
            if(id[i] == pid)
            {
                id[i] = qid;
                //System.out.println("changed index: " + i + " " + id[i] + " q: " + q + " " + id[q]);
            }
        }
    }
}
