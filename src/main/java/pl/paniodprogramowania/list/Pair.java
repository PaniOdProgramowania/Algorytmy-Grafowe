package pl.paniodprogramowania.list;

public class Pair {
  private int min;
  private int max;

  public Pair(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }

  @Override
  public String toString() {
    return "Pair{" + "left=" + min + ", right=" + max + '}';
  }
}
