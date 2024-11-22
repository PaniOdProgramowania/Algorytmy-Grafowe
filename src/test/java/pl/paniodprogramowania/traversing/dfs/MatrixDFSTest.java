package pl.paniodprogramowania.traversing.dfs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.paniodprogramowania.graph.AdjacencyMatrixGraph;

class MatrixDFSTest {

  private static Stream<Arguments> graphsAndAnswers() {
    return Stream.of(
        Arguments.of("tree", AdjacencyMatrixGraph.tree(), 0, List.of(0, 1, 3, 7, 8, 4, 9, 10, 2, 5, 11, 12, 6, 13, 14)),
        Arguments.of("directed graph", AdjacencyMatrixGraph.directedGraph(), 0, List.of(0, 1, 2, 3, 4)),
        Arguments.of("undirected graph", AdjacencyMatrixGraph.notDirectedGraph(), 1, List.of(1, 2, 3, 4, 0, 5))
    );
  }

  @ParameterizedTest(name = "Matrix DFS - {0}")
  @MethodSource("graphsAndAnswers")
  public void shouldReturnProperDFSRouteForTreeAdjacencyMatrix(
      String name, int[][] graph, int startingVertex,  List<Integer> expected
  ) {
    // given // when
    List<Integer> actual = MatrixDFS.dfs(graph, startingVertex);

    // then
    assertEquals(expected, actual);
  }
}