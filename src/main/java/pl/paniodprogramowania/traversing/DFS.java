package pl.paniodprogramowania.traversing;

import java.util.LinkedList;

public class DFS {

  public static void dfs(int[][] graph){
    int n = graph.length;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++){
      if (!visited[i]){
        visitNode(visited, graph, i);
      }
    }
  }

  private static void visitNode(boolean[] visited, int[][]graph, int i) {
    visited[i] = true;
    System.out.print("wierzcholek " + i +"-> ");
    for (int v = 0; v < visited.length; v++){
      if (graph[i][v] != 0){
        if (!visited[v]){
          visitNode(visited, graph, v);
        }
      }
    }
  }
}
