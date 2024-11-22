package pl.paniodprogramowania.traversing.bfs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.paniodprogramowania.graph.AdjacencyMatrixGraph;

class MatrixBFSTest {

  private static Stream<Arguments> graphsAndAnswers() {
    return Stream.of(
        Arguments.of("tree", AdjacencyMatrixGraph.tree(), 0, IntStream.range(0, 15).boxed().toList()),
        Arguments.of("directed graph", AdjacencyMatrixGraph.directedGraph(), 0, List.of(0, 1, 3, 4, 2)),
        Arguments.of("undirected graph starting from 0", AdjacencyMatrixGraph.notDirectedGraph(), 0, List.of(0, 4, 5, 3, 2, 1)),
        Arguments.of("undirected graph starting from 1", AdjacencyMatrixGraph.notDirectedGraph(), 1, List.of(1, 2, 3, 5,4, 0))
    );
  }

  @ParameterizedTest(name = "Matrix BFS - {0}")
  @MethodSource("graphsAndAnswers")
  public void shouldReturnProperBFSRouteForTreeAdjacencyMatrix(
      String name, int[][] graph, int startingVertex,  List<Integer> expected
  ) {
    // given // when
    List<Integer> result = MatrixBFS.bfs(graph, startingVertex);

    // then
    Assertions.assertEquals(expected, result);
  }
}