package pl.paniodprogramowania.traversing.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MatrixBFS {

  public static List<Integer> bfs(int[][] graph, int startingVertex) {
    int n = graph.length;
    Set<Integer> visited = new HashSet<>();
    List<Integer> path = new ArrayList<>();
    Queue<Integer> queue = new ArrayDeque<>();

    queue.offer(startingVertex);

    while (!queue.isEmpty()) {
      int u = queue.poll();
      for (int i = startingVertex, j = 0; j < n; i++, j++) {
        if (i >= n) {
          i -= n;
        }
        if (graph[u][i] != 0) {
          if (!visited.contains(i) && !queue.contains(i)) {
            queue.offer(i);
          }
        }
      }
      visited.add(u);
      path.add(u);
      System.out.print("wierzcholek " + u + "-> ");
    }
    return path;
  }

}
