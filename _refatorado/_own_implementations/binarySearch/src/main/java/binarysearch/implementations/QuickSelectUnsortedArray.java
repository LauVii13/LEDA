package binarysearch.implementations;

import binarysearch.AbstractBinarySearch;
import util.Util;

public class QuickSelectUnsortedArray extends AbstractBinarySearch<Integer> {

  @Override
  public int binSearch(Integer[] array, int leftIndex, int rightIndex, Integer k) {
    if (casoBase(array, leftIndex, rightIndex))
      return -1;

    int index = -1;
    int pointer = partition(array, leftIndex, rightIndex);

    if (k == array[pointer])
      index = pointer;
    else if (k < array[pointer])
      index = binSearch(array, leftIndex, pointer - 1, k);
    else if (k > array[pointer])
      index = binSearch(array, pointer + 1, rightIndex, k);
    return index;
  }

  private int partition(Integer[] array, int leftIndex, int rightIndex) {
    if (leftIndex >= rightIndex)
      return leftIndex;

    int pointer = leftIndex;
    medianOfThree(array, leftIndex, rightIndex);

    int pivot = rightIndex - 1;

    for (int i = leftIndex; i < rightIndex - 1; i++)
      if (array[i].compareTo(array[pivot]) < 0)
        Util.swap(array, pointer++, i);

    Util.swap(array, pivot, pointer);

    return pointer;
  }

  private void medianOfThree(Integer[] array, int leftIndex, int rightIndex) {
    int middle = (rightIndex + leftIndex) / 2;

    if (array[rightIndex] < array[middle])
      Util.swap(array, rightIndex, middle);
    if (array[rightIndex] < array[leftIndex])
      Util.swap(array, rightIndex, leftIndex);
    if (array[middle] < array[leftIndex])
      Util.swap(array, leftIndex, middle);

    Util.swap(array, middle, rightIndex - 1);
  }

  private boolean casoBase(Integer[] array, int leftIndex, int rightIndex) {
    return array.length == 0 || leftIndex < 0 || rightIndex > array.length || leftIndex > rightIndex;
  }
}
