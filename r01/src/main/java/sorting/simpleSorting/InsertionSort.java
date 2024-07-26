package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

  @Override
  public void sort(T[] array, int leftIndex, int rightIndex) {

    if (leftIndex < 0 || rightIndex >= array.length || leftIndex > rightIndex) {
      // casos de exceção
    } else {
      // logica sort
      for (int i = leftIndex; i <= rightIndex; i++) {
        int indiceAtual = i;
        while (indiceAtual > leftIndex && array[indiceAtual].compareTo(array[indiceAtual - 1]) < 0) {
          Util.swap(array, indiceAtual, indiceAtual - 1);
          indiceAtual--;
        }
      }
    }
  }
}
