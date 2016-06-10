package dsa.graphs;

public class Adjacent {

    public double weight;
    public Node destination;

    public Adjacent(Node destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
