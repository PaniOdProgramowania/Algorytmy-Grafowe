package pl.paniodprogramowania.traversing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.paniodprogramowania.graph.AdjacencyMatrixGraph;
import pl.paniodprogramowania.graph.nodes.Node;
import pl.paniodprogramowania.graph.nodes.NodeGraph;

class DFSTest {


  @Test
  public void shouldReturnProperDFSRouteForTreeAdjacencyMatrix() {
    // given
    int[][] graph = AdjacencyMatrixGraph.tree();

    // when
    List<Integer> actual = DFS.dfs(graph, 0);

    // then
    List<Integer> expected = List.of(0, 1, 3, 7, 8, 4, 9, 10, 2, 5, 11, 12, 6, 13, 14);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldReturnProperDFSRouteForDirectedGraphAdjacencyMatrix() {
    // given
    int[][] graph = AdjacencyMatrixGraph.directedGraph();

    // when
    List<Integer> actual = DFS.dfs(graph,0);

    // then
    List<Integer> expected = List.of(0, 1, 2, 3, 4);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldReturnProperDFSRouteForTreeNodes() {
    // given
    Node graph = NodeGraph.tree();

    // when
    List<Node> result = DFS.dfs(graph);

    // then
    List<Integer> actual = result.stream().map(Node::getNodeNumber).toList();
    List<Integer> expected = List.of(0, 1, 3, 7, 8, 4, 9, 10, 2, 5, 11, 12, 6, 13, 14);
    assertEquals(expected, actual);
  }


  @Test
  public void shouldReturnProperDFSRouteForTreeNodesDirected() {
    // given
    Node graph = NodeGraph.graph();

    // when
    List<Node> result = DFS.dfs(graph);

    // then
    List<Integer> actual = result.stream().map(Node::getNodeNumber).toList();
    List<Integer> expected = List.of(0, 1, 3, 7, 8, 2, 5, 9, 6);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldReturnProperDFSRouteForNotDirectedGraphAdjacencyMatrix() {
    // given
    int[][] graph = AdjacencyMatrixGraph.notDirectedGraph();

    // when
    List<Integer> actual = DFS.dfs(graph, 1);

    // then
    List<Integer> expected = List.of(1, 2, 3, 4, 0, 5);
    assertEquals(expected, actual);
  }

}