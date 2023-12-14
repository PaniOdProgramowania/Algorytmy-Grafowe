package pl.paniodprogramowania.list;

import java.util.Arrays;

public class FindMinMax {

  public static Pair findMinMax(int[] tab){
    if (tab.length == 1) {
      return new Pair(tab[0], tab[0]);
    }
    if (tab.length == 2){
      return new Pair(Math.min(tab[0], tab[1]), Math.max(tab[0], tab[1]));
    }
    var middleIndex = tab.length / 2;

    var leftArray = Arrays.copyOfRange(tab, 0, middleIndex);
    var rightArray = Arrays.copyOfRange(tab, middleIndex, tab.length);
    var minMaxFromLeftList = findMinMax(leftArray);
    var minMaxFromRightList = findMinMax(rightArray);
    var min = Math.min(minMaxFromLeftList.getMin(), minMaxFromRightList.getMin());
    var max = Math.max(minMaxFromLeftList.getMax(), minMaxFromRightList.getMax());
    return new Pair(min, max);
  }
}
