package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
    AbstractSorting<T> {

  @Override
  public void sort(T[] array, int leftIndex, int rightIndex) {
    if (leftIndex >= rightIndex) {
    } else {
      bubbleToRight(array, leftIndex, rightIndex);
      bubbleToLeft(array, leftIndex, rightIndex);
      sort(array, leftIndex + 1, rightIndex - 1);
    }
  }

  private void bubbleToRight(T[] array, int leftIndex, int rightIndex) {
    if (leftIndex >= rightIndex) {
    } else {
      if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0)
        Util.swap(array, leftIndex, leftIndex + 1);

      bubbleToRight(array, leftIndex + 1, rightIndex);
    }
  }

  private void bubbleToLeft(T[] array, int leftIndex, int rightIndex) {
    if (leftIndex >= rightIndex) {
    } else {
      if (array[rightIndex].compareTo(array[rightIndex - 1]) < 0)
        Util.swap(array, rightIndex, rightIndex - 1);

      bubbleToLeft(array, leftIndex, rightIndex - 1);
    }
  }
}
