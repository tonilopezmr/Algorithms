package dsa.graphs;

import java.util.List;

public abstract class Graph {

    protected static final double INFINITE = Double.POSITIVE_INFINITY;

    public abstract int vertexCount();
    public abstract int edgeCount();
    public abstract boolean isNodexistsEdge(Node node, Node node2);
    public abstract double getDistance(Node node, Node node2);

    public abstract boolean connect(Node origin, Node destination);
    public abstract boolean connect(Node origin, Node destination, double weight);

    public abstract List<Adjacent> getInwardEdges(Node vertex);
    public abstract List<Adjacent> getOutwardEdges(Node vertex);
    public abstract List<Adjacent> getConnectedVertices(Node origin);

    public abstract List<Adjacent> getPathBetween(Node origin, Node dest);
}
