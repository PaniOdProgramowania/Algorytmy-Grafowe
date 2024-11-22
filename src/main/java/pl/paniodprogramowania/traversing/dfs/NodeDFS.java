package pl.paniodprogramowania.traversing.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pl.paniodprogramowania.graph.nodes.Node;

public class NodeDFS {

  public static List<Node> dfs(Node node) {
    return dfsWithNodesHelper(node, new HashSet<>(), new ArrayList<>());
  }

  private static List<Node> dfsWithNodesHelper(Node node, Set<Node> visited, List<Node> path){
    if (node != null && !visited.contains(node)) {
      System.out.print(node.getNodeNumber() + " -> ");
      visited.add(node);
      path.add(node);
      dfsWithNodesHelper(node.getLeftNode(), visited, path);
      dfsWithNodesHelper(node.getRightNode(), visited, path);
    }
    return path;
  }
}
