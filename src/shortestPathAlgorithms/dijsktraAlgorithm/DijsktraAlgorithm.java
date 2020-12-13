package shortestPathAlgorithms.dijsktraAlgorithm;

import java.util.*;

public class DijsktraAlgorithm {

    public void computePaths(Vertex sourceVertex) {
        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex actualVertex = priorityQueue.poll();

            for (Edge edge : actualVertex.getAdjacenciesList()) {
                Vertex v = edge.getTargetVertex();

                double newDistance = actualVertex.getDistance() + edge.getWeight();

                if (newDistance < v.getDistance()) {
                    priorityQueue.remove(v);
                    v.setDistance(newDistance);
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex) {

        List<Vertex> shortestPathToTarget = new ArrayList<>();

        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
            shortestPathToTarget.add(vertex);
        }

        Collections.reverse(shortestPathToTarget);
        //List has been reversed bcz the getShortestPathTo method is taking targetVertex as it's input soo it will find a shortest path to the source vertex.
        //Soo it will be in reverse order... since we need path from source vertex to target vertex.

        return shortestPathToTarget;
    }
}
