package shortestPathAlgorithms.DirectedAcyclicGraph;

import java.util.ArrayList;
import java.util.List;

public class App {
    /**
     * Bellman-ford algorithm: O(E+V)       Slower but able to detect negative edge cycle
     * Dijsktra algorithm: O(E+V*logV)      Faster but not able to detect negative edge cycle
     * DAG shortest Path method: O(E+V)     Fastest but not able to handle negative edge weight and also Directed Acyclic graph is needed
     * @param args
     */
    public static void main(String[] args) {
        Vertex vertex0 = new Vertex("A");
        Vertex vertex1 = new Vertex("B");
        Vertex vertex2 = new Vertex("C");

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(vertex0);
        vertexList.add(vertex1);
        vertexList.add(vertex2);

        vertex0.addNeighbour(new Edge(1,vertex0, vertex1));
        vertex0.addNeighbour(new Edge(1,vertex0, vertex2));
        vertex1.addNeighbour(new Edge(1,vertex1, vertex2));

        AcyclicShortestPath acyclicShortestPath = new AcyclicShortestPath();
        acyclicShortestPath.shortestPath(vertexList, vertex0, vertex2);
        acyclicShortestPath.showShortestPathTo(vertex2);
    }
}
