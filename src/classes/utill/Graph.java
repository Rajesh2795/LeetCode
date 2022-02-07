package classes.utill;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int noOfVertices;
    public List<List<Integer>> graphData;

    public Graph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        graphData = new ArrayList<>();
    }

    public void initialize() {
        for (int i = 0; i < noOfVertices + 1; i++) {
            graphData.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int u) {
        if (v < graphData.size() && u < graphData.size()) {
            this.graphData.get(v).add(u);
            this.graphData.get(u).add(v);
        }
    }

    public void printGraph() {
        System.out.println("Size of graph: " + this.graphData.size());
        int vertex = 0;
        for (List<Integer> vertices : this.graphData) {
            System.out.println(vertex + " -> " + vertices.toString());
            vertex++;
        }
    }
}
