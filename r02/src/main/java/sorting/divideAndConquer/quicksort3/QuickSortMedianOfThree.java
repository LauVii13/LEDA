package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do
 * intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até
 * A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do
 * pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
    AbstractSorting<T> {

  public void sort(T[] array, int leftIndex, int rightIndex) {
    if (casoBase(array, leftIndex, rightIndex)) {
    } else {
      medianaTres(array, leftIndex, rightIndex);

      int j = organizaArray(array, leftIndex + 1, rightIndex - 1, rightIndex - 1, leftIndex);

      if (j != rightIndex - 1)
        Util.swap(array, rightIndex - 1, ++j);

      sort(array, leftIndex, j - 1);
      sort(array, j + 1, rightIndex);
    }
  }

  private void medianaTres(T[] array, int leftIndex, int rightIndex) {
    int meio = (rightIndex + leftIndex) / 2;

    if (array[rightIndex].compareTo(array[meio]) < 0)
      Util.swap(array, rightIndex, meio);
    if (array[rightIndex].compareTo(array[leftIndex]) < 0)
      Util.swap(array, rightIndex, leftIndex);
    if (array[meio].compareTo(array[leftIndex]) < 0)
      Util.swap(array, leftIndex, meio);

    Util.swap(array, meio, rightIndex - 1);

  }

  private int organizaArray(T[] array, int leftIndex, int rightIndex, int pivo, int ponteiro) {
    if (leftIndex >= rightIndex) {
    } else {

      if (array[leftIndex].compareTo(array[pivo]) < 0)
        Util.swap(array, ++ponteiro, leftIndex);

      ponteiro = organizaArray(array, leftIndex + 1, rightIndex, pivo, ponteiro);
    }

    return ponteiro;

  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex >= rightIndex || rightIndex >= array.length || leftIndex < 0;
  }

}
