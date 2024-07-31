package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

  @Override
  public void sort(T[] array, int leftIndex, int rightIndex) {
    if (casoBase(array, leftIndex, rightIndex)) {
    } else {

      int j = organizaArray(array, leftIndex, rightIndex, leftIndex, leftIndex);

      Util.swap(array, leftIndex, j);
      sort(array, leftIndex, j - 1);
      sort(array, j + 1, rightIndex);
    }
  }

  private int organizaArray(T[] array, int leftIndex, int rightIndex, int pivo, int ponteiro) {
    if (leftIndex > rightIndex) {
    } else {

      if (array[leftIndex].compareTo(array[pivo]) < 0)
        Util.swap(array, ++ponteiro, leftIndex);

      ponteiro = organizaArray(array, leftIndex + 1, rightIndex, pivo, ponteiro);
    }

    return ponteiro;
  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex >= rightIndex || rightIndex >= array.length || leftIndex < 0;
  }

}
