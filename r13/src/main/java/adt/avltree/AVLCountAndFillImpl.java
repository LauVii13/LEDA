package adt.avltree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
    AVLTreeImpl<T> implements AVLCountAndFill<T> {

  private int LLcounter;
  private int LRcounter;
  private int RRcounter;
  private int RLcounter;

  public AVLCountAndFillImpl() {

  }

  @Override
  public int LLcount() {
    return LLcounter;
  }

  @Override
  public int LRcount() {
    return LRcounter;
  }

  @Override
  public int RRcount() {
    return RRcounter;
  }

  @Override
  public int RLcount() {
    return RLcounter;
  }

  @Override
  public void fillWithoutRebalance(T[] array) {
    Arrays.sort(array);
    Queue<Integer[]> queue = new LinkedList<>();

    Integer[] firstPair = { 0, array.length - 1 };
    queue.add(firstPair);

    fillRecursive(queue, array);
  }

  private void fillRecursive(Queue<Integer[]> queue, T[] array) {
    if (queue.peek() != null) {
      Integer[] pair = queue.remove();
      int middleIndex = (pair[0] + pair[1]) / 2;

      this.insert(array[middleIndex]);

      if (pair[0] != pair[1]) {
        Integer[] leftPair = { pair[0], middleIndex - 1 };
        Integer[] rightPair = { middleIndex + 1, pair[1] };
        queue.add(leftPair);
        queue.add(rightPair);
      }

      fillRecursive(queue, array);
    }
  }

}
