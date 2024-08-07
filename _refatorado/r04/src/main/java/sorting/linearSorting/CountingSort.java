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
