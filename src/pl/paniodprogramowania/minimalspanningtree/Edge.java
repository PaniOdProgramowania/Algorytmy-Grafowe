package pl.paniodprogramowania.minimalspanningtree;

public class Edge implements Comparable<Edge> {
  private final int cost;
  private final int startingVertex;
  private final int endingVertex;

  public Edge(int cost, int startingVertex, int endingVertex) {
    this.cost = cost;
    this.startingVertex = startingVertex;
    this.endingVertex = endingVertex;
  }

  public int getCost() {
    return cost;
  }

  public int getStartingVertex() {
    return startingVertex;
  }

  public int getEndingVertex() {
    return endingVertex;
  }

  @Override
  public int compareTo(Edge other) {
    return Integer.compare(this.cost, other.getCost());
  }

  @Override
  public String toString() {
    return "[from: " + startingVertex + "-> to: " + endingVertex + ", cost: " + cost + "]";
  }
}
