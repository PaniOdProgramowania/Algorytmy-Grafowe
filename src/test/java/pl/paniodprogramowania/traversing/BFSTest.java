package pl.paniodprogramowania.traversing;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.paniodprogramowania.graph.AdjacencyMatrixGraph;
import pl.paniodprogramowania.graph.nodes.Node;
import pl.paniodprogramowania.graph.nodes.NodeGraph;

class BFSTest {

  @Test
  public void shouldReturnProperBFSRouteForTreeAdjacencyMatrix() {
    // given
    int[][] graph = AdjacencyMatrixGraph.tree();

    // when
    List<Integer> nodesInOrder = BFS.bfs(graph);

    // then
    for (int i = 0; i < 15; i++) {
      Assertions.assertEquals(nodesInOrder.get(i), i);
    }
  }

  @Test
  public void shouldReturnProperBFSRouteForDirectedGraphAdjacencyMatrix() {
    // given
    int[][] graph = AdjacencyMatrixGraph.directedGraph();

    // when
    List<Integer> nodesInOrder = BFS.bfs(graph);

    // then
    Assertions.assertEquals(nodesInOrder.get(0), 0);
    Assertions.assertEquals(nodesInOrder.get(1), 1);
    Assertions.assertEquals(nodesInOrder.get(2), 3);
    Assertions.assertEquals(nodesInOrder.get(3), 4);
    Assertions.assertEquals(nodesInOrder.get(4), 2);
  }

  @Test
  public void shouldReturnProperBFSRouteForTreeNodes() {
    // given
    Node graph = NodeGraph.tree();

    // when
    List<Integer> nodesInOrder = BFS.bfs(graph);

    // then
    for (int i = 0; i < 15; i++) {
      Assertions.assertEquals(nodesInOrder.get(i), i);
    }
  }

  // @Test
  public void shouldReturnProperBFSRouteForNotDirectedGraphAdjacencyMatrix() {
    // given
    int[][] graph = AdjacencyMatrixGraph.notDirectedGraph();

    // when
    List<Integer> nodesInOrder = BFS.bfs(graph);

    // then
    Assertions.assertEquals(nodesInOrder.get(0), 2);
    Assertions.assertEquals(nodesInOrder.get(1), 3);
    Assertions.assertEquals(nodesInOrder.get(2), 4);
    Assertions.assertEquals(nodesInOrder.get(3), 6);
    Assertions.assertEquals(nodesInOrder.get(4), 5);
    Assertions.assertEquals(nodesInOrder.get(5), 1);
  }

}