package pl.paniodprogramowania.traversing;

import java.util.List;
import pl.paniodprogramowania.graph.nodes.Node;
import pl.paniodprogramowania.traversing.dfs.NodeDFS;

public class FindNode {

  public static Node findElement(Node k, Node root){
    List<Node> dfsResult = NodeDFS.dfs(root);
    int index = dfsResult.indexOf(k);
    return dfsResult.get(index);
  }

}
