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
    boolean trocou = true;

    if (leftIndex < 0 || rightIndex >= array.length || leftIndex > rightIndex) {
      // casos de exceção
    } else {
      // logica sort
      while (trocou) {
        trocou = false;
        for (int i = leftIndex; i < rightIndex; i++) {
          if (array[i].compareTo(array[i + 1]) > 0) {
            trocou = true;
            Util.swap(array, i, i + 1);
          }
        }
      }
    }
  }
}
