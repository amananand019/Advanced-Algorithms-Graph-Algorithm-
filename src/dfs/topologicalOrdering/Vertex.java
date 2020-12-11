package dfs.topologicalOrdering;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String data;
    private boolean visited;
    private List<Vertex> neighbourList;

    public Vertex(String data){
        this.data = data;
        this.neighbourList = new ArrayList<>();
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void addNeighbour(Vertex neighbour) {
        this.neighbourList.add(neighbour);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return this.data;
    }
}
