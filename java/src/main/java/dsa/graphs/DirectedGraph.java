package dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DirectedGraph<E> extends Graph {

    private int numE;
    //List to keep all our vertex
    List<Node> vertices = new ArrayList<>(30);

    //A map to keep each vertex linked to their adjacents
    HashMap<Node, List<Adjacent>> vertexAdjacents = new HashMap<>();

    public DirectedGraph() {
    }

    @Override
    public int vertexCount() {
        return vertices.size();
    }

    @Override
    public int edgeCount() {
        return numE;
    }

    @Override
    public boolean isNodexistsEdge(Node node, Node node2) {
        List<Adjacent> l = vertexAdjacents.get(node);
        boolean alreadyExists = false;
        for (int i = 0; i < l.size() && !alreadyExists; i++) {
            if (l.get(i).destination == node2) {
                alreadyExists = true;
            }
        }
        return alreadyExists;
    }

    @Override
    public double getDistance(Node node, Node node2) {
        List<Adjacent> l = vertexAdjacents.get(node);
        for (Adjacent adjacent : l) {
            if (adjacent.destination == node2){
                return adjacent.weight;
            }
        }

        return 0;
    }

    @Override
    public boolean connect(Node origin, Node destination) {
        return connect(origin, destination, 1);
    }

    @Override
    public boolean connect(Node origin, Node destination, double weight) {
        boolean isConnect = false;
        add(origin);

        if (!isNodexistsEdge(origin, destination)){
            vertices.add(destination);
            vertexAdjacents.get(origin).add(new Adjacent(destination, weight));
            numE++;
            add(destination);
            isConnect = true;
        }
        return isConnect;
    }

    private void add(Node destination) {
        if (vertices.indexOf(destination) < 0){
            vertices.add(destination);
        }
    }

    @Override
    public List<Adjacent> getInwardEdges(Node vertex) {
        return null;
    }

    @Override
    public List<Adjacent> getOutwardEdges(Node vertex) {
        return null;
    }

    @Override
    public List<Adjacent> getConnectedVertices(Node origin) {
        return null;
    }

    @Override
    public List<Adjacent> getPathBetween(Node origin, Node dest) {
        return vertexAdjacents.get(origin);
    }
}
