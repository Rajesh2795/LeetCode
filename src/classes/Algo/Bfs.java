package classes.Algo;

import classes.utill.Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Bfs {
    public void search(Graph graph, int startVertex) {
        if (graph.graphData.size() == 0) {
            return;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.graphData.size()];

        visited[startVertex] = true;
        deque.addLast(startVertex);

        while (!deque.isEmpty()) {
            int currentVertex = deque.pollFirst();
            System.out.println("vertex visited: " + currentVertex);
            List<Integer> vertices = graph.graphData.get(currentVertex);
            for (int vertex : vertices) {
                if (!visited[vertex]) {
                    deque.addLast(vertex);
                    visited[vertex] = true;
                }
            }
        }
    }
}
