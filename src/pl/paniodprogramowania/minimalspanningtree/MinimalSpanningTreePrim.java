package pl.paniodprogramowania.minimalspanningtree;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimalSpanningTreePrim {

  public static List<Edge> mst(int[][] graph) {
    List<Edge> mstVertexes = new LinkedList<>();
    int vertexFrom = 0;
    Queue<Edge> queue = new PriorityQueue<>();
    addRoutes(graph, mstVertexes, vertexFrom, queue);

    while (mstVertexes.size() != graph.length - 1) {
      Edge cheapestEdge = queue.poll();
      vertexFrom = cheapestEdge.getEndingVertex();
      mstVertexes.add(cheapestEdge);
      addRoutes(graph, mstVertexes, vertexFrom, queue);
    }
    System.out.println(mstVertexes);
    return mstVertexes;
  }

  private static void addRoutes(int[][] graph, List<Edge> mstVertexes, int vertexFrom, Queue<Edge> queue) {
    int n = graph.length;
    for (int i = 0; i < n; i++) {
      if (graph[vertexFrom][i] != 0 && !wasThisVertexVisited(i, mstVertexes)) {
        queue.add(new Edge(graph[vertexFrom][i], vertexFrom, i));
      }
    }
  }

  private static boolean wasThisVertexVisited(int vertex, List<Edge> mstVertexes) {
    return mstVertexes.stream()
        .anyMatch(edge -> edge.getStartingVertex() == vertex || edge.getEndingVertex() == vertex);
  }
}
