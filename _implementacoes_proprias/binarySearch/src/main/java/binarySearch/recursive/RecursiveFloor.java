package binarySearch.recursive;

import binarySearch.AbstractBinarySearch;

public class RecursiveFloor<T extends Comparable<T>> extends AbstractBinarySearch<T> {
  @Override
  public int binSearch(T[] array, int leftIndex, int rightIndex, T k) {
    int result = -1;
    if (casoBase(array, leftIndex, rightIndex)) {
    } else {
      int meio = (leftIndex + rightIndex) / 2;

      if (array[rightIndex].compareTo(k) <= 0)
        result = rightIndex;
      else if (array[meio].compareTo(k) <= 0 && array[meio + 1].compareTo(k) > 0)
        result = meio;
      else if (array[meio].compareTo(k) < 0)
        result = binSearch(array, meio + 1, rightIndex, k);
      else
        result = binSearch(array, leftIndex, meio - 1, k);
    }

    return result;
  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex >= rightIndex || rightIndex >= array.length || leftIndex < 0;
  }
}
