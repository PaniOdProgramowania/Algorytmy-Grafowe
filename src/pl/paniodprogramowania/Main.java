package pl.paniodprogramowania;

import pl.paniodprogramowania.graph.Graph;
import pl.paniodprogramowania.minimalspanningtree.MinimalSpanningTreePrim;
import pl.paniodprogramowania.shortestpath.Dijkstra;
import pl.paniodprogramowania.traversing.BFS;
import pl.paniodprogramowania.traversing.DFS;

public class Main {

  public static void main(String[] args) {
    int[][] tree = Graph.tree();
    Graph.printGraph(tree);

    System.out.println("\n BFS");
    BFS.bfs(tree);

    System.out.println("\n DFS: ");
    DFS.dfs(tree);

    int[][] graph = Graph.notDirectedGraph();
    Graph.printGraph(graph);
    System.out.println("**----- Minimalne Drzewo Rozpinajace - Algorytm Prima -----**");
    MinimalSpanningTreePrim.mst(graph);

    System.out.println("**----- Najrkotsza sciezka od jednego wierzcholka do innych - Algorytm Dijkstry -----**");
    int[][] dijkstra = Dijkstra.dijkstra(Graph.directedGraph());
    System.out.println("koszt | poprzedni wierzcholek");
    Graph.printGraph(dijkstra);
  }
}
