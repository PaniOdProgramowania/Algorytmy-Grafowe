package pl.paniodprogramowania.traversing.dfs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.paniodprogramowania.graph.nodes.Node;
import pl.paniodprogramowania.graph.nodes.NodeGraph;

class NodeDFSTest {

  private static Stream<Arguments> graphsAndAnswers() {
    return Stream.of(
        Arguments.of("tree", NodeGraph.tree(), 0, List.of(0, 1, 3, 7, 8, 4, 9, 10, 2, 5, 11, 12, 6, 13, 14)),
        Arguments.of("graph", NodeGraph.graph(), 0, List.of(0, 1, 3, 7, 8, 2, 5, 9, 6))
    );
  }

  @ParameterizedTest(name = "Nodes DFS - {0}")
  @MethodSource("graphsAndAnswers")
  public void shouldReturnProperDFSRouteForTreeNodes(
      String name, Node graph, int startingVertex,  List<Integer> expected
        ) {
    // given // when
    List<Node> result = NodeDFS.dfs(graph);

    // then
    List<Integer> actual = result.stream().map(Node::getNodeNumber).toList();
    assertEquals(expected, actual);
  }

}