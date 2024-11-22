package pl.paniodprogramowania.traversing.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixDFS {

  public static List<Integer> dfs(int[][] graph, int startingNode){
    return visitNode(new HashSet<>(), new ArrayList<>(), graph, startingNode);
  }

  private static List<Integer> visitNode(Set<Integer> visited, List<Integer> path, int[][]graph, int i) {
    System.out.print("wierzcholek " + i +"-> ");
    visited.add(i);
    path.add(i);
    int n = graph.length;
    for (int v = 0, j = 0; j < n; j++, v++){
      if (v >= n) {
        v -= n;
      }
      if (graph[i][v] != 0){
        if (!visited.contains(v)){
          visitNode(visited, path, graph, v);
        }
      }
    }
    return path;
  }
}
