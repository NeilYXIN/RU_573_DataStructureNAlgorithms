public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N)
    {
        id = new int[N];
        for(int i = 0; i < N; i++)
        {
            id[i] = i;
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

    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    public void union(int p, int q)
    {
        int proot = root(p);
        int qroot = root(q);
        id[proot] = qroot;
        //System.out.println("proot: " + proot + " " + id[proot] + " qroot: " + qroot + " " + id[qroot]);
    }
}
