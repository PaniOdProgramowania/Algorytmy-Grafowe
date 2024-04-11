package pl.paniodprogramowania.graph.nodes;

import java.util.Objects;

public class Node {
  private final Node leftNode;
  private final Node rightNode;
  private final int nodeNumber;

  public Node(Node leftNode, Node rightNode, int nodeNumber) {
    this.leftNode = leftNode;
    this.rightNode = rightNode;
    this.nodeNumber = nodeNumber;
  }

  public Node getLeftNode() {
    return leftNode;
  }

  public Node getRightNode() {
    return rightNode;
  }

  public int getNodeNumber() {
    return nodeNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {return true;}
    if (o == null || getClass() != o.getClass()) {return false;}
    Node node = (Node) o;
    return nodeNumber == node.nodeNumber && Objects.equals(
        leftNode,
        node.leftNode
    ) && Objects.equals(rightNode, node.rightNode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(leftNode, rightNode, nodeNumber);
  }
}
