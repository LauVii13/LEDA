package orderStatistic;

import java.util.PriorityQueue;

public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

  /**
   * Existem diversas formas de se calcular uma estatistica de ordem.
   * Voce deve fazer isso usando uma heap restricoes:
   * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
   * uma PriorityQueue
   * - caso a estatistica de ordem procurada nao exista no array o metodo deve
   * retornar null
   * 
   * @param array
   * @param k
   * @return
   */

  @Override
  public T getOrderStatistics(T[] array, int k) {
    PriorityQueue<T> heap = new PriorityQueue<T>();
    for (T t : array) {
      heap.add(t);
    }

    T result = null;
    if (k >= 1 && k <= array.length) {
      result = heap.poll();
      k--;

      if (heap.peek() != null && heap.peek().compareTo(result) < 0) { // max heap
        k = heap.size() - k + 1;
      }

      while (k >= 1) {
        result = heap.poll();
        k--;
      }
    }

    return result;
  }

}