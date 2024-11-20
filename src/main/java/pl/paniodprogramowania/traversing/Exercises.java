package pl.paniodprogramowania.traversing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pl.paniodprogramowania.graph.nodes.Node;

public class Exercises {

  public static boolean checkIfNodesConnected(int from, int to, int[][] graph) {
    List<Integer> vertexesConnectedToStarting = DFS.dfs(graph, from);
    return vertexesConnectedToStarting.contains(to);
  }

  public static boolean checkIfNodesConnectedOptimised(int from, int to, int[][] graph) {
    return findNode(new HashSet<>(), graph, from, to);
  }

  public static boolean checkIfNodesConnected(Node from, Node to) {
    List<Integer> vertexesConnectedToStarting = DFS.dfs(from).stream().map(Node::getNodeNumber).toList();
    return vertexesConnectedToStarting.contains(to.getNodeNumber());
  }

  public static boolean checkIfNodesConnectedOptimised(Node from, Node to) {
    return dfsWithNodesHelper(from, to, new HashSet<>(), false);
  }

  private static boolean findNode(Set<Integer> visited, int[][]graph, int i, int to) {
    System.out.print("wierzcholek " + i +"-> ");
    visited.add(i);
    int n = graph.length;
    for (int v = 0, j = 0; j < n; j++, v++){
      if (v >= n) {
        v -= n;
      }
      if (graph[i][v] != 0){
        if (v == to) return true;
        if (!visited.contains(v)){
          findNode(visited, graph, v, to);
        }
      }
    }
    return false;
  }

  private static boolean dfsWithNodesHelper(Node node, Node to, Set<Node> visited, boolean result){
    if (node != null && !visited.contains(node)) {
      if (node.getNodeNumber() == to.getNodeNumber()) {
        return true;
      } else {
        System.out.println(node.getNodeNumber() + " -> ");
        visited.add(node);
        result = dfsWithNodesHelper(node.getLeftNode(), to, visited, result);
        result = dfsWithNodesHelper(node.getRightNode(), to, visited, result);
      }
    }
    return result;
  }
}
