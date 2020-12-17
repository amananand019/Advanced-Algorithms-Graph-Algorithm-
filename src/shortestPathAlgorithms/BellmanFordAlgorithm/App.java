package shortestPathAlgorithms.BellmanFordAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));
        vertexList.add(new Vertex("D"));
        vertexList.add(new Vertex("E"));
//
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(vertexList.get(0),vertexList.get(1),5));
        edgeList.add(new Edge(vertexList.get(0),vertexList.get(3),-4));
        edgeList.add(new Edge(vertexList.get(0),vertexList.get(2),8));
        edgeList.add(new Edge(vertexList.get(1),vertexList.get(0),-2));
        edgeList.add(new Edge(vertexList.get(2),vertexList.get(1),-3));
        edgeList.add(new Edge(vertexList.get(2),vertexList.get(3),9));
        edgeList.add(new Edge(vertexList.get(3),vertexList.get(1),7));
        edgeList.add(new Edge(vertexList.get(4),vertexList.get(0),6));
        edgeList.add(new Edge(vertexList.get(4),vertexList.get(2),7));

//        edgeList.add(new Edge(vertexList.get(0), vertexList.get(1),1));
//        edgeList.add(new Edge(vertexList.get(0), vertexList.get(2),-1));
//        edgeList.add(new Edge(vertexList.get(1), vertexList.get(2),1));

        BellmanFord bellmannFordAlgorithm = new BellmanFord(vertexList,edgeList);
        List<Vertex> vertexList1= bellmannFordAlgorithm.bellmanFord(vertexList.get(4),vertexList.get(3));

        for(Vertex v:vertexList1){
            System.out.print(v+" ");
        }

    }
}
