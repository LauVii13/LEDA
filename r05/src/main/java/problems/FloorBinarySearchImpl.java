package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

  @Override
  public Integer floor(Integer[] array, Integer x) {
    Integer result = null;

    if (casoBase(array)) {
    } else {
      int index = partition(array, 0, array.length - 1, x);
      if (index >= 0)
        result = array[index];
    }

    return result;
  }

  private Integer partition(Integer[] array, int leftIndex, int rightIndex, int x) {
    int index = -1;

    int pivot = leftIndex;
    int pointer = leftIndex;

    for (int i = leftIndex; i <= rightIndex; i++) {
      if (array[i].compareTo(array[pivot]) < 0)
        Util.swap(array, ++pointer, i);
    }

    Util.swap(array, pivot, pointer);

    if (x == array[pointer]) {
      index = pointer;
    } else if (x < array[pointer] && pointer > leftIndex) {
      index = partition(array, leftIndex, pointer - 1, x);
    } else if (x > array[pointer]) {
      if (pointer < rightIndex)
        index = partition(array, pointer + 1, rightIndex, x);

      if (index == -1)
        index = pointer;
    }

    return index;
  }

  private boolean casoBase(Integer[] array) {
    return array.length == 0;
  }

}
// [4,8,7,3,0,9,2,1,6]
