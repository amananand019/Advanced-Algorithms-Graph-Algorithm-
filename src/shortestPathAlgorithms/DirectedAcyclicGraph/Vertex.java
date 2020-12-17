package shortestPathAlgorithms.DirectedAcyclicGraph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String Name;
    private Vertex predecessor;
    private boolean visited;
    private List<Edge> adjacencyList;
    private double distance = Double.MAX_VALUE;

    public Vertex(String name) {
        this.Name = name;
        this.adjacencyList = new ArrayList<Edge>();
    }

    public void addNeighbour(Edge edge){
        this.adjacencyList.add(edge);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<shortestPathAlgorithms.DirectedAcyclicGraph.Edge> getAdjacenciesList() {
        return this.adjacencyList;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacencyList = adjacenciesList;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.Name;
    }
}
