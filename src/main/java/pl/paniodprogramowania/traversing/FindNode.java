package pl.paniodprogramowania.traversing;

import java.util.List;
import pl.paniodprogramowania.graph.nodes.Node;

public class FindNode {

  public static Node findElement(Node k, Node root){
    List<Node> dfsResult = DFS.dfs(root);
    int index = dfsResult.indexOf(k);
    return dfsResult.get(index);
  }

}
