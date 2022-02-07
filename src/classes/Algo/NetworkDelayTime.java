package classes.Algo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] directedGraph = new int[n + 1][n + 1];

        for (int[] time : times) {
            directedGraph[time[0]][time[1]] = time[2];
        }

        for (int i = 0; i <= n; i++) {
            System.out.println(i + ": " + Arrays.toString(directedGraph[i]));
        }

        int maxTime = 0, time = 0;
        for(int i = 1; i <= n; i++) {
            if (i != k && directedGraph[k][i] != 0) {
                time = directedGraph[k][i];
            } else if (i != k) {
                boolean[] visited = new boolean[n + 1];
                time = doBfs(directedGraph, k, i, visited);
            }

            if (time == -1) return time;
            maxTime = Math.max(time, maxTime);
        }

        return maxTime;
    }

    public int doBfs(int[][] directedGraph, int source, int target, boolean[] visited) {
        Deque<Pair> deque = new ArrayDeque<>();

        deque.push(new Pair(source, 0));
        visited[source] = true;

        while(!deque.isEmpty()) {
            Pair current = deque.poll();
            System.out.println("current: " + current.element + ", time: " + current.time);

            if (current.element == target) {
                return current.time;
            }

            for (int i = 1; i < directedGraph.length; i++) {
                if (i != source && !visited[i] && directedGraph[current.element][i] != 0) {
                    deque.add(new Pair(i, directedGraph[current.element][i] + current.time));
                    visited[i] = true;
                }
            }
        }

        return -1;
    }

    static class Pair {
        int element;
        int time;

        public Pair(int element, int time) {
            this.element = element;
            this.time = time;
        }
    }
}
