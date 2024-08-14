package binarysearch.implementations;

import binarysearch.AbstractBinarySearch;

public class RecursiveFirstOccurrence<T extends Comparable<T>> extends AbstractBinarySearch<T> {

  @Override
  public int binSearch(T[] array, int leftIndex, int rightIndex, T k) {
    if (casoBase(array, leftIndex, rightIndex))
      return -1;

    int index = -1, middle = (leftIndex + rightIndex) / 2;

    if (array[middle].compareTo(k) == 0) {
      if (previousIsTheSame(array, middle))
        index = binSearch(array, leftIndex, middle - 1, k);
      else
        index = middle;
    } else if (array[middle].compareTo(k) < 0)
      index = binSearch(array, middle + 1, rightIndex, k);
    else if (array[middle].compareTo(k) > 0)
      index = binSearch(array, leftIndex, middle - 1, k);

    return index;
  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex > rightIndex || rightIndex >= array.length || leftIndex < 0;
  }

  private boolean previousIsTheSame(T[] arrays, int pivot) {
    return pivot == 0 || arrays[pivot - 1].compareTo(arrays[pivot]) == 0;
  }
}
