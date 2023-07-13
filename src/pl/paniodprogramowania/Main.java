package pl.paniodprogramowania;

import pl.paniodprogramowania.graph.AdjacencyMatrixGraph;
import pl.paniodprogramowania.graph.nodes.NodeGraph;
import pl.paniodprogramowania.height.HeightOfTree;
import pl.paniodprogramowania.minimalspanningtree.MinimalSpanningTreePrim;
import pl.paniodprogramowania.shortestpath.Dijkstra;
import pl.paniodprogramowania.traversing.BFS;
import pl.paniodprogramowania.traversing.DFS;

public class Main {

  public static void main(String[] args) {
    int[][] tree = AdjacencyMatrixGraph.tree();
    AdjacencyMatrixGraph.printGraph(tree);

    System.out.println("\n BFS");
    BFS.bfs(tree);

    System.out.println("\n DFS: ");
    DFS.dfs(tree);

    int[][] graph = AdjacencyMatrixGraph.notDirectedGraph();
    AdjacencyMatrixGraph.printGraph(graph);
    System.out.println("**----- Minimalne Drzewo Rozpinajace - Algorytm Prima -----**");
    MinimalSpanningTreePrim.mst(graph);

    System.out.println("**----- Najrkotsza sciezka od jednego wierzcholka do innych - Algorytm Dijkstry -----**");
    int[][] dijkstra = Dijkstra.dijkstra(AdjacencyMatrixGraph.directedGraph());
    System.out.println("koszt | poprzedni wierzcholek");
    AdjacencyMatrixGraph.printGraph(dijkstra);

    System.out.println("**----- Wysokość drzewa binarnego -----**");
    System.out.println("Drzewo: \n" + NodeGraph.treeVisual);
    var treeInNodes = NodeGraph.tree();
    var height = HeightOfTree.heightOfTree(treeInNodes);
    System.out.println("Jego wysokość wynosi: " + height);
  }
}
