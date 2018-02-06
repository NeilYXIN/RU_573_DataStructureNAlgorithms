public class WeightedUnionUF {
    private int[] id;
    private int[] size;

    public WeightedUnionUF(int N)
    {
        id = new int[N];
        size = new int[N];
        for(int i = 0; i < N; i++)
        {
            id[i] = i;
            size[i] = 1;
        }
    }

    // find root
    public int root(int i)
    {
        while(i != id[i])
        {
            i = id[i];
        }
        return i;
    }

    // determine connected or not
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    // union two components
    public void union(int p, int q)
    {
        int proot = root(p);
        int qroot = root(q);
        if(size[proot] < size[qroot])
        {
            id[proot] = qroot;
            size[qroot] += size[proot];
        }
        else
        {
            id[qroot] = proot;
            size[proot] += size[qroot];
        }

        //System.out.println("proot: " + proot + ": " + id[proot] + " " + size[proot] + " qroot: " + qroot + ": " + id[qroot] + " " + size[qroot]);
    }
}
