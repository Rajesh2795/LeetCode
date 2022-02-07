package classes.Algo;

import classes.utill.Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Dfs {
    public void search(Graph graph) {
        if (graph.graphData.size() == 0) {
            return;
        }

        boolean[] visited = new boolean[graph.graphData.size()];
        for (int i = 0; i < graph.graphData.size(); i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    public void dfs(Graph graph, int startVertex, boolean[] visited) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(startVertex);

        while (!deque.isEmpty()) {
            int currentVertex = deque.pop();
            System.out.println("Vertex Visited: " + currentVertex);
            List<Integer> adjacentVertices = graph.graphData.get(currentVertex);
            for (Integer adjacentVertex : adjacentVertices) {
                if (!visited[adjacentVertex]) {
                    deque.push(adjacentVertex);
                    visited[adjacentVertex] = true;
                }
            }
        }
    }
}
