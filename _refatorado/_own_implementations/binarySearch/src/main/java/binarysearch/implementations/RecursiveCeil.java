package binarysearch.implementations;

import binarysearch.AbstractBinarySearch;

public class RecursiveCeil<T extends Comparable<T>> extends AbstractBinarySearch<T> {

  @Override
  public int binSearch(T[] array, int leftIndex, int rightIndex, T k) {
    if (casoBase(array, leftIndex, rightIndex))
      return -1;

    int index = -1, middle = (leftIndex + rightIndex) / 2;

    if (array[middle].compareTo(k) == 0)
      index = middle;

    else if (array[middle].compareTo(k) < 0)
      index = binSearch(array, middle + 1, rightIndex, k);

    else if (array[middle].compareTo(k) > 0) {
      index = binSearch(array, leftIndex, middle - 1, k);

      if (index == -1)
        index = middle;
    }

    return index;
  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex > rightIndex || rightIndex >= array.length || leftIndex < 0;
  }
}
