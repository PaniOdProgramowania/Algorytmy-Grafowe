package pl.paniodprogramowania.traversing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

  public static List<Integer> bfs(Node startingNode) {
    Map<Integer, Boolean> visitedNode = new HashMap<>();
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(startingNode);
    List<Integer> path = new ArrayList<>();

    while (!queue.isEmpty()) {
      Node u = queue.poll();
      Node leftNode = u.getLeftNode();
      Node rightNode = u.getRightNode();

      if (leftNode != null &&
          (!visitedNode.containsKey(leftNode.getNodeNumber()) || !visitedNode.get(leftNode.getNodeNumber()))) {
        queue.offer(leftNode);
      }
      if (rightNode != null &&
          (!visitedNode.containsKey(rightNode.getNodeNumber()) || !visitedNode.get(rightNode.getNodeNumber()))) {
        queue.offer(rightNode);
      }
      visitedNode.put(u.getNodeNumber(), true);
      path.add(u.getNodeNumber());
      System.out.print("wierzcholek " + u.getNodeNumber() + "-> ");
    }
    return path;
  }
}
