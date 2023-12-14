package pl.paniodprogramowania.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

  public static final int COST_INDEX = 0;
  public static final int PREVIOUS_ELEMENT_INDEX = 1;

  public static int[][] dijkstra(int[][] graph) {
    int n = graph.length;
    int[][] helperTable = new int[n][2];

    List<Integer> notVisitedVertexes = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      notVisitedVertexes.add(i);
    }

    setUpHelperTable(n, helperTable);

    while (!notVisitedVertexes.isEmpty()) {
      int startingVertex = getCheapestElement(notVisitedVertexes, helperTable);
      for (int column = 0; column < n; column++) {
        if (graph[startingVertex][column] != 0) {
          updateCost(helperTable[startingVertex][0] + graph[startingVertex][column], helperTable, startingVertex, column);
        }
      }
      notVisitedVertexes.remove((Integer) startingVertex);
    }
    return helperTable;
  }

  private static void setUpHelperTable(int n, int[][] dijkstraTable) {
    dijkstraTable[0][COST_INDEX] = 0;
    dijkstraTable[0][PREVIOUS_ELEMENT_INDEX] = -1;
    for (int j = 1; j < n; j++) {
      dijkstraTable[j][COST_INDEX] = Integer.MAX_VALUE;
      dijkstraTable[j][PREVIOUS_ELEMENT_INDEX] = -1;
    }
  }

  private static void updateCost(int cost, int[][] dijkstraTable, int startingVertex, int coloumn) {
    if (dijkstraTable[coloumn][COST_INDEX] > cost) {
      dijkstraTable[coloumn][PREVIOUS_ELEMENT_INDEX] = startingVertex;
      dijkstraTable[coloumn][COST_INDEX] = cost;
    }
  }

  private static int getCheapestElement(List<Integer> notVisitedVertexes, int[][] dijkstraTable) {
    int minimalValue = Integer.MAX_VALUE;
    int minimalIndex = -1;
    for (Integer notVisitedVertex : notVisitedVertexes) {
      if (minimalValue > dijkstraTable[notVisitedVertex][0]) {
        minimalValue = dijkstraTable[notVisitedVertex][0];
        minimalIndex = notVisitedVertex;
      }
    }
    return minimalIndex;
  }
}
