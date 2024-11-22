package pl.paniodprogramowania.graph.nodes;

import java.util.List;

public class NodeGraph {
  public static final int ROOT_INDEX = 0;

  /**
   *                  0
   *               /     \
   *             /        \
   *           /           \
   *         /              \
   *       1   ___________>  2
   *     /                 /  \
   *    3                 5    6
   *   / \               / \
   *  7  8 <-------------   -- 9
   *
   *
   **/
  public static Node graph() {
    var node9 = new Node(null, null, 9);
    var node8 = new Node(null, null, 8);
    var node7 = new Node(null, null, 7);
    var node6 = new Node(null, null, 6);
    var node5 = new Node(node8, node9, 5);
    var node3 = new Node(node7, node8, 3);
    var node2 = new Node(node5, node6, 2);
    var node1 = new Node(node3, node2, 1);
    return new Node(node1, node2,  0);
  }


  /**
   *                  0
   *               /     \
   *             /        \
   *           /           \
   *         /              \
   *       1                2
   *     /   \            /  \
   *    3     4         5      6
   *   / \   /  \     / \     / \
   *  7  8  9   10  11  12  13  14
   *
   *
   **/
  public static Node tree(){
    var node14 = new Node(null, null, 14);
    var node13 = new Node(null, null, 13);
    var node12 = new Node(null, null, 12);
    var node11 = new Node(null, null, 11);
    var node10 = new Node(null, null, 10);
    var node9 = new Node(null, null, 9);
    var node8 = new Node(null, null, 8);
    var node7 = new Node(null, null, 7);
    var node6 = new Node(node13, node14, 6);
    var node5 = new Node(node11, node12, 5);
    var node4 = new Node(node9, node10, 4);
    var node3 = new Node(node7, node8, 3);
    var node2 = new Node(node5, node6, 2);
    var node1 = new Node(node3, node4, 1);
    return new Node(node1, node2, ROOT_INDEX);
  }

  public static String treeVisual = """
      *                  0
      *               /     \\
      *             /        \\
      *           /           \\
      *         /              \\
      *       1                2
      *     /   \\            /  \\
      *    3     4         5      6
      *   / \\   /  \\     / \\     / \\
      *  7  8  9   10  11  12  13  14""";



  /**
   *                  0
   *               /     \
   *             /        \
   *           /           \
   *         /              \
   *       1                2
   *     /   \            /  \
   *    3     4         5      6
   *
   *
   **/
  public static Node binaryTree3Levels(){
    var node6 = new Node(null, null, 6);
    var node5 = new Node(null, null, 5);
    var node4 = new Node(null, null, 4);
    var node3 = new Node(null, null, 3);
    var node2 = new Node(node5, node6, 2);
    var node1 = new Node(node3, node4, 1);
    return new Node(node1, node2, ROOT_INDEX);
  }

  public static List<Node> binaryTree3LevelsAsList(){
    var node6 = new Node(null, null, 6);
    var node5 = new Node(null, null, 5);
    var node4 = new Node(null, null, 4);
    var node3 = new Node(null, null, 3);
    var node2 = new Node(node5, node6, 2);
    var node1 = new Node(node3, node4, 1);
    Node root = new Node(node1, node2, ROOT_INDEX);
    return List.of(root, node1, node2, node3, node4, node5, node6);
  }


  /**
   *            0
   *          /
   *        1
   *
   *        2
   *         \
   *          3
   *
   **/
  public static List<Node> fourVertexesTwoEdgesAsList(){
    var node3 = new Node(null, null, 3);
    var node2 = new Node(node3, null, 2);
    var node1 = new Node(null, null, 1);
    Node node0 = new Node(node1, null, 0);
    return List.of(node0, node1, node2, node3);
  }
}


