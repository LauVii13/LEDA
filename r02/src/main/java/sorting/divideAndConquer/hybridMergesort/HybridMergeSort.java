package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de
 * forma
 * que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados.
 * E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
    AbstractSorting<T> {

  /**
   * For inputs with size less or equal to this value, the insertionsort
   * algorithm will be used instead of the mergesort.
   */
  public static final int SIZE_LIMIT = 4;

  protected static int MERGESORT_APPLICATIONS = 0;
  protected static int INSERTIONSORT_APPLICATIONS = 0;

  public void sort(T[] array, int leftIndex, int rightIndex) {
    this.MERGESORT_APPLICATIONS = 0;
    this.INSERTIONSORT_APPLICATIONS = 0;

    if (casosDeQuebra(array, leftIndex, rightIndex)) {
    } else {
      if ((rightIndex - leftIndex) + 1 <= SIZE_LIMIT)
        insertionSort(array, leftIndex, rightIndex);
      else {
        int middle = (rightIndex + leftIndex) / 2;

        sort(array, leftIndex, middle);
        sort(array, middle + 1, rightIndex);

        mergeArrays(array, leftIndex, middle, rightIndex);
      }
    }

  }

  private void insertionSort(T[] array, int leftIndex, int rightIndex) {
    this.INSERTIONSORT_APPLICATIONS++;
    for (int i = leftIndex; i <= rightIndex; i++) {
      int indiceAtual = i;
      while (indiceAtual > leftIndex && array[indiceAtual].compareTo(array[indiceAtual - 1]) < 0) {
        Util.swap(array, indiceAtual, indiceAtual - 1);
        indiceAtual--;
      }
    }
  }

  private void mergeArrays(T[] array, int leftIndex, int middle, int rightIndex) {
    this.MERGESORT_APPLICATIONS++;
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
