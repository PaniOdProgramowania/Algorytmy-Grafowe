package pl.paniodprogramowania.traversing;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

  public static void bfs(int[][] graph){
    int n = graph.length;
    boolean[] visited = new boolean[n];

    for (int i = 0; i <n; i++){
      visited[i] = false;
    }

    Queue<Integer> queue = new ArrayDeque<>();

    int startingVertex = 0;
    queue.offer(startingVertex);

    while (!queue.isEmpty()){
      int u = queue.poll();
      for (int i = 0; i < n; i++){
        if (graph[u][i] != 0) {
          if (!visited[i]){
            queue.offer(i);
          }
        }
      }
      visited[u] = true;
      System.out.print("wierzcholek " + u + "-> ");
    }
  }
}
