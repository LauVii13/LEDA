package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

  @Override
  public void sort(T[] array, int leftIndex, int rightIndex) {
    if (casoBase(array, leftIndex, rightIndex))
      return;

    boolean swapped = true;
    while (swapped) {
      swapped = false;
      for (int i = leftIndex; i < rightIndex; i++) {
        if (array[i].compareTo(array[i + 1]) > 0) {
          swapped = true;
          Util.swap(array, i, i + 1);
        }
      }
    }
  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex >= rightIndex || rightIndex >= array.length || leftIndex < 0;
  }
}
