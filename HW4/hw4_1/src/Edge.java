public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
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

    public double getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }
}