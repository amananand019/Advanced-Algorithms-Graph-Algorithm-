package shortestPathAlgorithms.BellmanFordAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFord {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;

    private List<Vertex> returnList;

    public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
        this.edgeList = edgeList;
        this.vertexList = vertexList;
        this.returnList = new ArrayList<>();
    }

    public List<Vertex> bellmanFord(Vertex sourceVertex, Vertex targetVertex) {

        sourceVertex.setDistance(0);

        for (int i = 0; i < vertexList.size() - 1; ++i) {
            for (Edge edge : edgeList) {
                if (edge.getStartVertex().getDistance() == Double.MAX_VALUE) {
                    continue;
                }

                double newDistance = edge.getStartVertex().getDistance() + edge.getWeight();

                if (newDistance < edge.getTargetVertex().getDistance()) {
                    edge.getTargetVertex().setDistance(newDistance);
                    edge.getTargetVertex().setPreviousVertex(edge.getStartVertex());
                }
            }
        }

        for (Edge edge : edgeList) {
            if (edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
                if (hasCycle(edge)) {
                    System.out.println("Negative edge weight cycles detected!");
                    return null;
                }
            }
        }

        if (targetVertex.getDistance() != Double.MAX_VALUE) {
            System.out.println("There is a shortest path from sourco to target, with cost: " + targetVertex.getDistance());

            Vertex actualVertex = targetVertex;
            while (actualVertex.getPreviousVertex() != null) {
                returnList.add(actualVertex);
                actualVertex = actualVertex.getPreviousVertex();
            }

            if (actualVertex == sourceVertex)
                returnList.add(actualVertex);

        } else {
            System.out.println("There is no path from source to target...");
        }
        Collections.reverse(returnList);
        return returnList;
    }

    private boolean hasCycle(Edge edge) {
        return edge.getTargetVertex().getDistance() > edge.getStartVertex().getDistance() + edge.getWeight();
    }
}
