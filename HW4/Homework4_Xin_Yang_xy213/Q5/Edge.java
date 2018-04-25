public class Edge {
    private int v;
    private int w;
    private int weight;

    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int v) {
        if (this.v == v) {
            return this.w;
        }
        else if (this.w == v) {
            return this.v;
        }
        else {
            throw new IllegalArgumentException("No such vertex in this edge");
        }
    }

    public int getWeight() {
        return this.weight;
    }
}