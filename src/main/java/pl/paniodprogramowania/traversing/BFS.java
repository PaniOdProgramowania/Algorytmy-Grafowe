package pl.paniodprogramowania.traversing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import pl.paniodprogramowania.graph.nodes.Node;

public class BFS {

  public static List<Integer> bfs(int[][] graph, int startingVertex) {
    int n = graph.length;
    Set<Integer> visited = new HashSet<>();
    List<Integer> path = new ArrayList<>();
    Queue<Integer> queue = new ArrayDeque<>();

    queue.offer(startingVertex);

    while (!queue.isEmpty()) {
      int u = queue.poll();
      for (int i = startingVertex, j = 0; j < n; i++, j++) {
        if (i >= n) {
          i -= n;
        }
        if (graph[u][i] != 0) {
          if (!visited.contains(i) && !queue.contains(i)) {
            queue.offer(i);
          }
        }
      }
      visited.add(u);
      path.add(u);
      System.out.print("wierzcholek " + u + "-> ");
    }
    return path;
  }

  public static List<Integer> bfsWithNodes(Node root) {
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
