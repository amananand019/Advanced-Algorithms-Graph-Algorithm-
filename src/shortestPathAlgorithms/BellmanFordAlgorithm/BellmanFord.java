package shortestPathAlgorithms.BellmanFordAlgorithm;

import java.util.List;

public class BellmanFord {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;

    public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
        this.edgeList = edgeList;
        this.vertexList = vertexList;
    }

    public void bellmanFord(Vertex sourceVertex, Vertex targetVertex) {

        sourceVertex.setDistance(0);

        for (Vertex vertex : vertexList) {
            for (Edge edge : edgeList) {

                if ( edge.getStartVertex().getDistance() == Integer.MAX_VALUE ) {
                    continue;
                }

                int newDistance = (int) (edge.getStartVertex().getDistance() + edge.getWeight());

                if (newDistance < edge.getTargetVertex().getDistance()) {
                    edge.getTargetVertex().setDistance(newDistance);
                    edge.getTargetVertex().setPreviousVertex(edge.getStartVertex());
                }
            }
        }

        for (Edge edge : edgeList) {
            if (edge.getStartVertex().getDistance() != Integer.MAX_VALUE) {
                if ( hasCycle(edge) ) {
                    System.out.println("Negative edge weight cycles detected!");
                    return;
                }
            }
        }

        if (targetVertex.getDistance() != Integer.MAX_VALUE) {
            System.out.println("There is a shortest path from sourco to target, with cost: " + targetVertex.getDistance());

            Vertex actualVErtex = targetVertex;
            while( actualVErtex.getPreviousVertex() != null ){
                System.out.print(actualVErtex+"-");
                actualVErtex=actualVErtex.getPreviousVertex();
            }

        } else {
            System.out.println("There is no path from source to target...");
        }
    }

    private boolean hasCycle(Edge edge){
        return edge.getTargetVertex().getDistance() > edge.getStartVertex().getDistance() + edge.getWeight();
    }
}
