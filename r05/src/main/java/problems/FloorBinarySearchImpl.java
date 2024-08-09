package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

  @Override
  public Integer floor(Integer[] array, Integer x) {
    Integer result = null;

    if (casoBase(array)) {
    } else {
      int index = binarySearch(array, 0, array.length - 1, x);
      if (index >= 0)
        result = array[index];
    }
    return result;
  }

  private Integer binarySearch(Integer[] array, int leftIndex, int rightIndex, int x) {
    int index = -1;
    int pointer = partition(array, leftIndex, rightIndex);

    if (x == array[pointer])
      index = pointer;
    else if (x < array[pointer] && pointer > leftIndex)
      index = binarySearch(array, leftIndex, pointer - 1, x);
    else if (x > array[pointer]) {
      if (pointer < rightIndex)
        index = binarySearch(array, pointer + 1, rightIndex, x);

      if (index == -1)
        index = pointer;
    }
    return index;
  }

  private int partition(Integer[] array, int leftIndex, int rightIndex){
    int pointer = leftIndex;

    if(leftIndex >= rightIndex){
    } else {
      medianOfThree(array, leftIndex, rightIndex);

      int pivot = rightIndex - 1;
      
      for (int i = leftIndex; i < rightIndex -1; i++) {
        if (array[i].compareTo(array[pivot]) < 0)
          Util.swap(array, pointer++, i);
      }
      Util.swap(array, pivot, pointer);
    }
    return pointer;
  }

  private void medianOfThree(Integer[] array, int leftIndex, int rightIndex){
    int middle = (rightIndex + leftIndex) / 2;

    if (array[rightIndex] < array[middle])
      Util.swap(array, rightIndex, middle);
    if (array[rightIndex] < array[leftIndex])
      Util.swap(array, rightIndex, leftIndex);
    if (array[middle] < array[leftIndex])
      Util.swap(array, leftIndex, middle);

    Util.swap(array, middle, rightIndex - 1);
  }

  private boolean casoBase(Integer[] array) {
    return array.length == 0;
  }
}
