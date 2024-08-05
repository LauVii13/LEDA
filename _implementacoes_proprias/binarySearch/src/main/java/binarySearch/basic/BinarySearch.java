package binarySearch.basic;

import binarySearch.AbstractBinarySearch;

/**
*
*/
public class BinarySearch<T extends Comparable<T>> extends AbstractBinarySearch<T> {

  @Override
  public int binSearch(T[] array, int leftIndex, int rightIndex, T k) {
    int result = -1;
    if (casoBase(array, leftIndex, rightIndex)) {
    } else {
      while (leftIndex < rightIndex && result == -1) {
        int meio = (leftIndex + rightIndex) / 2;

        if (array[meio].compareTo(k) == 0)
          result = meio;
        else if (array[meio].compareTo(k) < 0)
          leftIndex = meio + 1;
        else
          rightIndex = meio - 1;
      }
    }

    return result;
  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex >= rightIndex || rightIndex >= array.length || leftIndex < 0;
  }
}
