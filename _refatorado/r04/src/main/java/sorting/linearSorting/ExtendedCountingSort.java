package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

  @Override
  public void sort(Integer[] array, int leftIndex, int rightIndex) {
    if (casoBase(array, leftIndex, rightIndex))
      return;

    int[] arrayOrd = new int[array.length];

    int min = array[leftIndex], max = array[rightIndex];

    for (int i = leftIndex; i <= rightIndex; i++) {
      if (array[i] < min)
        min = array[i];
      if (array[i] > max)
        max = array[i];
    }

    int[] aux = new int[max - min + 1];

    for (int i = leftIndex; i <= rightIndex; i++)
      aux[array[i] - min]++;

    for (int i = 1; i < aux.length; i++)
      aux[i] += aux[i - 1];

    for (int i = rightIndex; i >= leftIndex; i--)
      arrayOrd[--aux[array[i] - min]] = array[i];

    for (int i = leftIndex; i <= rightIndex; i++)
      array[i] = arrayOrd[i];

  }

  private boolean casoBase(Integer[] array, int leftIndex, int rightIndex) {
    return (leftIndex < 0 || leftIndex > rightIndex || rightIndex >= array.length);
  }

}
