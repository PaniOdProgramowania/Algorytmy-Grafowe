package pl.paniodprogramowania.height;

import static pl.paniodprogramowania.graph.nodes.NodeGraph.ROOT_INDEX;

import pl.paniodprogramowania.graph.nodes.Node;

public class HeightOfTree {
  public static int heightOfTree(Node rootNode){
    if (rootNode == null){
      return 0;
    }
    var leftSideHeight = heightOfTree(rootNode.getLeftNode());
    var rightSideHeight = heightOfTree(rootNode.getRightNode());
    return Integer.max(leftSideHeight, rightSideHeight) + 1;
  }
}
