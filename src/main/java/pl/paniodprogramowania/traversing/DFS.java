package pl.paniodprogramowania.traversing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import pl.paniodprogramowania.graph.nodes.Node;

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

  public static List<Node> dfs(Node node) {
    return dfsWithNodesHelper(node, new HashSet<>(), new ArrayList<>());
  }


  private static List<Node> dfsWithNodesHelper(Node node, Set<Node> visited, List<Node> path){
    if (node != null && !visited.contains(node)) {
      System.out.println(node.getNodeNumber() + " -> ");
      visited.add(node);
      path.add(node);
      dfsWithNodesHelper(node.getLeftNode(), visited, path);
      dfsWithNodesHelper(node.getRightNode(), visited, path);
    }
    return path;
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
