package binarysearch.implementations;

import binarysearch.AbstractBinarySearch;

public class SquareRoot extends AbstractBinarySearch<Integer> {

  @Override
  public int binSearch(Integer[] array, int leftIndex, int rightIndex, Integer k) {
    if (casoBase(array, leftIndex, rightIndex))
      return -1;

    int index = -1, middle = (leftIndex + rightIndex) / 2;

    if (array[middle] * array[middle] == k) {
      index = middle;
    } else if (array[middle] * array[middle] < k) {
      if (middle == array.length - 1)
        index = middle;
      else if (array[middle + 1] * array[middle + 1] > k)
        index = smallestDifference(array, middle, middle + 1, k);
      else
        index = binSearch(array, middle + 1, rightIndex, k);
    } else {
      if (middle == 0)
        index = middle;
      else if (array[middle - 1] * array[middle - 1] < k)
        index = smallestDifference(array, middle, middle - 1, k);
      else
        index = binSearch(array, leftIndex, middle - 1, k);
    }

    return index;
  }

  private boolean casoBase(Integer[] array, int leftIndex, int rightIndex) {
    return leftIndex > rightIndex || rightIndex >= array.length || leftIndex < 0;
  }

  private int smallestDifference(Integer[] array, int index1, int index2, Integer k) {
    int dif1, dif2, index;
    dif1 = abs((array[index1] * array[index1]) - k);
    dif2 = abs((array[index2] * array[index2]) - k);

    if (dif1 <= dif2)
      index = index1;
    else
      index = index2;

    return index;
  }

  private int abs(int value) {
    if (value < 0)
      value *= -1;

    return value;
  }
}
