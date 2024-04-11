package pl.paniodprogramowania.traversing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import pl.paniodprogramowania.graph.nodes.Node;

public class BFS {

  public static List<Integer> bfs(int[][] graph) {
    int n = graph.length;
    boolean[] visited = new boolean[n];
    List<Integer> path = new ArrayList<>();
    Queue<Integer> queue = new ArrayDeque<>();

    int startingVertex = 0;
    queue.offer(startingVertex);

    while (!queue.isEmpty()) {
      int u = queue.poll();
      for (int i = 0; i < n; i++) {
        if (graph[u][i] != 0) {
          if (!visited[i]) {
            queue.offer(i);
          }
        }
      }
      visited[u] = true;
      path.add(u);
      System.out.print("wierzcholek " + u + "-> ");
    }
    return path;
  }

  public static List<Integer> bfs2(Node root) {
    List<Integer> path = new ArrayList<>();
    path.add(root.getNodeNumber());
    System.out.print(root.getNodeNumber() + " -> ");
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(root);
    Set<Node> visitedVertexesIds = new HashSet<>();

    while (!queue.isEmpty()) {
      Node nodeTemp = queue.poll();
      Node left = nodeTemp.getLeftNode();
      Node right = nodeTemp.getRightNode();

      if (!visitedVertexesIds.contains(left) && left != null) {
        System.out.print(left.getNodeNumber() + " -> ");
        queue.offer(left);
        visitedVertexesIds.add(left);
        path.add(left.getNodeNumber());
      }
      if (!visitedVertexesIds.contains(right) && right != null) {
        System.out.print(right.getNodeNumber() + " -> ");
        queue.offer(right);
        visitedVertexesIds.add(right);
        path.add(right.getNodeNumber());
      }
    }
    return path;
  }
}
