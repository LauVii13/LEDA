package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1].
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as
 * estatisticas de ordem maiores que k.
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 * Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 * os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala
 * para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 * ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 * Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T> {

  @Override
  public T[] getKLargest(T[] array, int k) {
    T[] elements;
    if (casoBase(array, k))
      elements = (T[]) new Comparable[0];
    else {
      elements = (T[]) new Comparable[k];

      for (int i = 1; i <= k; i++)
        elements[k - i] = orderStatistics(array, i);
    }

    return elements;
  }

  /**
   * Metodo que retorna a k-esima estatistica de ordem de um array, usando
   * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista
   * a k-esima estatistica de ordem, entao retorna null.
   * 
   * Obs: o valor de k deve ser entre 1 e N.
   * 
   * @param array
   * @param k
   * @return
   */
  public T orderStatistics(T[] array, int k) {
    bubbleSort(array, k);
    return array[array.length - k];
  }

  private void bubbleSort(T[] array, int kAtual) {
    for (int i = 0; i < array.length - kAtual; i++) {
      if (array[i].compareTo(array[i + 1]) > 0)
        Util.swap(array, i, i + 1);
    }
  }

  private boolean casoBase(T[] array, int k) {
    return k > array.length || k < 0;
  }
}
