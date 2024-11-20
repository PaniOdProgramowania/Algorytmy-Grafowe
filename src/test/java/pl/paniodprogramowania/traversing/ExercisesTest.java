package pl.paniodprogramowania.traversing;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.paniodprogramowania.graph.AdjacencyMatrixGraph;
import pl.paniodprogramowania.graph.nodes.Node;
import pl.paniodprogramowania.graph.nodes.NodeGraph;

class ExercisesTest {

  private static Stream<Arguments> provideArraysAndResultsTree() {
    return Stream.of(
        Arguments.of(new int[]{0, 3}, true),
        Arguments.of(new int[]{1, 5}, true),
        Arguments.of(new int[]{3, 6}, true)
    );
  }

  private static Stream<Arguments> provideArraysAndResultsUnconnectedEdges() {
    return Stream.of(
        Arguments.of(new int[]{0, 1}, true),
        Arguments.of(new int[]{0, 2}, false)
    );
  }

  @ParameterizedTest(name = "MATRIX based exercise results for example")
  @MethodSource("provideArraysAndResultsTree")
  public void shouldReturnTrueMatrix(int[] vertex, boolean result){
    // when
    boolean actualOld = Exercises.checkIfNodesConnected(vertex[0], vertex[1], AdjacencyMatrixGraph.binaryTree3Levels());
    boolean actualOpt = Exercises.checkIfNodesConnectedOptimised(vertex[0], vertex[1], AdjacencyMatrixGraph.binaryTree3Levels());

    //then
    Assertions.assertEquals(result, actualOld);
    Assertions.assertEquals(result, actualOpt);
  }

  @ParameterizedTest(name = "MATRIX based exercise results from book")
  @MethodSource("provideArraysAndResultsUnconnectedEdges")
  public void shouldReturnDifferentResultsMatrix(int[] vertex, boolean result){
    // when
    boolean actualOld = Exercises.checkIfNodesConnected(vertex[0], vertex[1], AdjacencyMatrixGraph.fourVertexesTwoEdges());
    boolean actualOpt = Exercises.checkIfNodesConnectedOptimised(vertex[0], vertex[1], AdjacencyMatrixGraph.fourVertexesTwoEdges());

    //then
    Assertions.assertEquals(result, actualOld);
    Assertions.assertEquals(result, actualOpt);
  }

  @ParameterizedTest(name = "NODE based exercise results for example")
  @MethodSource("provideArraysAndResultsTree")
  public void shouldReturnTrueNode(int[] vertex, boolean result){
    // when
    boolean actualOld = Exercises.checkIfNodesConnected(vertex[0], vertex[1], AdjacencyMatrixGraph.binaryTree3Levels());
    boolean actualOpt = Exercises.checkIfNodesConnectedOptimised(vertex[0], vertex[1], AdjacencyMatrixGraph.binaryTree3Levels());

    //then
    Assertions.assertEquals(result, actualOld);
    Assertions.assertEquals(result, actualOpt);
  }

  @ParameterizedTest(name = "NODE based exercise results from book - only true")
  @MethodSource("provideArraysAndResultsUnconnectedEdges")
  public void shouldReturnDifferentResultsNode(int[] vertex, boolean result){
    // given
    Node from = NodeGraph.fourVertexesTwoEdgesAsList().get(vertex[0]);
    Node to = NodeGraph.fourVertexesTwoEdgesAsList().get(vertex[1]);

    //when
    boolean actualOld = Exercises.checkIfNodesConnected(from, to);
    boolean actualOpt = Exercises.checkIfNodesConnectedOptimised(from, to);

    //then
    Assertions.assertEquals(result, actualOld);
    Assertions.assertEquals(result, actualOpt);
  }

}