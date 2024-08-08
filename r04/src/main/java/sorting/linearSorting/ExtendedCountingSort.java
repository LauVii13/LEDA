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
    if (casoBase(array, leftIndex, rightIndex)) {
    } else {
      int[] arrayOrd = new int[rightIndex - leftIndex + 1];

      int min = array[leftIndex], max = array[rightIndex];

      // define max e min
      for (int i = leftIndex; i <= rightIndex; i++) {
        if (array[i] < min)
          min = array[i];
        if (array[i] > max)
          max = array[i];
      }

      int[] aux = new int[max - min + 1];

      // contando
      for (int i = leftIndex; i <= rightIndex; i++)
        aux[array[i] - min]++;

      // soma acumulada
      for (int i = 1; i < aux.length; i++)
        aux[i] += aux[i - 1];

      // atribui em array ordenado
      for (int i = rightIndex; i >= leftIndex; i--) {
        int val = array[i];
        aux[val - min]--;
        int correctPosition = aux[val - min];
        arrayOrd[correctPosition] = val;
      }

      // sobreescrevendo array principal
      for (int i = 0; i < arrayOrd.length; i++)
        array[leftIndex + i] = arrayOrd[i];
    }
  }

  private boolean casoBase(Integer[] array, int leftIndex, int rightIndex) {
    return (leftIndex < 0 || leftIndex > rightIndex || rightIndex >= array.length);
  }

}
