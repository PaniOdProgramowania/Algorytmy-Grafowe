package pl.paniodprogramowania.traversing.bfs;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.paniodprogramowania.graph.AdjacencyMatrixGraph;
import pl.paniodprogramowania.graph.nodes.Node;
import pl.paniodprogramowania.graph.nodes.NodeGraph;

class NodeBFSTest {

  private static Stream<Arguments> graphsAndAnswers() {
    return Stream.of(
        Arguments.of("tree", NodeGraph.tree(), IntStream.range(0, 15).boxed().toList()),
        Arguments.of("directed graph", NodeGraph.graph(), List.of(0, 1, 2, 3, 5, 6, 7, 8, 9))
    );
  }

  @ParameterizedTest(name = "Nodes BFS - {0}")
  @MethodSource("graphsAndAnswers")
  public void shouldReturnProperBFSRouteForTreeAdjacencyMatrix(
      String name, Node graph,  List<Integer> expected
  ) {
    // given // when
    List<Integer> result = NodeBFS.bfs(graph);

    // then
    Assertions.assertEquals(expected, result);
  }
}