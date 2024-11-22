package pl.paniodprogramowania.traversing.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import pl.paniodprogramowania.graph.nodes.Node;

public class NodeBFS {

  public static List<Integer> bfs(Node root) {
    List<Integer> path = new ArrayList<>();
    System.out.print(root.getNodeNumber() + " -> ");
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(root);
    Set<Node> visitedVertexesIds = new HashSet<>();

    while (!queue.isEmpty()) {
      Node nodeTemp = queue.poll();
      Node left = nodeTemp.getLeftNode();
      Node right = nodeTemp.getRightNode();

      if (left != null){
        queue.offer(left);
      }
      if (right != null) {
        queue.offer(right);
      }

      if (!visitedVertexesIds.contains(nodeTemp)) {
        System.out.print(nodeTemp.getNodeNumber() + " -> ");
        visitedVertexesIds.add(nodeTemp);
        path.add(nodeTemp.getNodeNumber());
      }
    }
    return path;
  }
}
