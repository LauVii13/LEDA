package binarysearch.implementations;

import binarysearch.AbstractBinarySearch;

public class Classic<T extends Comparable<T>> extends AbstractBinarySearch<T> {

  @Override
  public int binSearch(T[] array, int leftIndex, int rightIndex, T k) {
    if (casoBase(array, leftIndex, rightIndex))
      return -1;

    int result = -1;

    while (leftIndex <= rightIndex && result == -1) {
      int middle = (leftIndex + rightIndex) / 2;

      if (array[middle].compareTo(k) == 0)
        result = middle;
      else if (array[middle].compareTo(k) < 0)
        leftIndex = middle + 1;
      else
        rightIndex = middle - 1;
    }

    return result;

  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex > rightIndex || rightIndex >= array.length || leftIndex < 0;
  }
}
