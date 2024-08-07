package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

  @Override
  public void sort(Integer[] array, int leftIndex, int rightIndex) {
    if (casoBase(array, leftIndex, rightIndex)) {
    } else {
      int[] arrayOrd = new int[array.length];

      int min = array[leftIndex], max = array[rightIndex];

      // define max e min
      for (int i = leftIndex; i <= rightIndex; i++) {
        if (array[i] < min)
          min = array[i];
        if (array[i] > max)
          max = array[i];
      }

      int[] aux = new int[max + 1];

      // contando
      for (int i = leftIndex; i <= rightIndex; i++)
        aux[array[i]]++;

      // soma acumulada
      for (int i = 1; i < aux.length; i++)
        aux[i] += aux[i - 1];

      // atribui em array ordenado
      for (int i = rightIndex; i >= leftIndex; i--) {
        int val = array[i];
        aux[val]--;
        int correctPosition = aux[val];
        arrayOrd[correctPosition] = val;
      }

      // sobreescrevendo array principal
      for (int i = leftIndex; i <= rightIndex; i++)
        array[i] = arrayOrd[i];
    }
  }

  private boolean casoBase(Integer[] array, int leftIndex, int rightIndex) {
    return (leftIndex < 0 || leftIndex > rightIndex || rightIndex >= array.length);
  }
}
