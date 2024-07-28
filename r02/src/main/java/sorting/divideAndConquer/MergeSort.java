package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

  @Override
  public void sort(T[] array, int leftIndex, int rightIndex) {
    if (casosDeQuebra(array, leftIndex, rightIndex)) {
    } else {
      int middle = (rightIndex + leftIndex) / 2;

      sort(array, leftIndex, middle);
      sort(array, middle + 1, rightIndex);

      mergeArrays(array, leftIndex, middle, rightIndex);
    }
  }

  private void mergeArrays(T[] array, int leftIndex, int middle, int rightIndex) {
    int lengthLeft = middle - leftIndex + 1;
    int lengthRight = rightIndex - middle;
    T[] l = criaArrayTemp(array, leftIndex, middle, lengthLeft);
    T[] r = criaArrayTemp(array, middle + 1, rightIndex, lengthRight);

    int i = 0, j = 0, p = leftIndex;

    while (i < l.length && j < r.length) {
      if (l[i].compareTo(r[j]) <= 0)
        array[p++] = l[i++];
      else
        array[p++] = r[j++];
    }

    while (i < l.length)
      array[p++] = l[i++];

    while (j < r.length)
      array[p++] = r[j++];

  }

  private T[] criaArrayTemp(T[] array, int start, int end, int length) {
    T[] temp = (T[]) new Comparable[length];

    for (int i = start; i <= end; i++)
      temp[i - start] = array[i];

    return temp;
  }

  private boolean casosDeQuebra(T[] array, int leftIndex, int rightIndex) {
    return leftIndex >= rightIndex || rightIndex >= array.length || leftIndex < 0;
  }

}
