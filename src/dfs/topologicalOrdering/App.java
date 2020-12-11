package dfs.topologicalOrdering;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
        List<Vertex> graph = new ArrayList<>();

        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).addNeighbour(graph.get(3));

        graph.get(3).addNeighbour(graph.get(1));

        graph.get(4).addNeighbour(graph.get(0));
        graph.get(4).addNeighbour(graph.get(1));

        graph.get(5).addNeighbour(graph.get(0));
        graph.get(5).addNeighbour(graph.get(2));

        /* here for loop is used soo that is there are more than one clusters
         * then the program can be iterated through them.
        **/
        for (int i=0; i<graph.size(); i++){
            if(!graph.get(i).isVisited())
                topologicalOrdering.dfs(graph.get(i));
        }

        Stack<Vertex> stack = topologicalOrdering.getStack();

        for(int i=0; i<graph.size(); i++){
            Vertex vertex = stack.pop();
            if(i == graph.size()-1){
                System.out.print(vertex);
                break;
            }
            System.out.print(vertex + " -> ");
        }
    }
}
