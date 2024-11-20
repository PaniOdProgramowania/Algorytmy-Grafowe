package pl.paniodprogramowania.traversing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pl.paniodprogramowania.graph.nodes.Node;

public class DFS {

  public static List<Integer> dfs(int[][] graph, int startingNode){
    return visitNode(new HashSet<>(), new ArrayList<>(), graph, startingNode);
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
