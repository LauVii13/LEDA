package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
    AbstractSorting<T> {

  /**
   * Implementação recursiva do bubble sort. Você deve implementar apenas esse
   * método sem usar nenhum outro método auxiliar (exceto
   * Util.swap(array,int,int)). Para isso, tente definir o caso base do
   * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
   * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
   * quadrática O(n^2).
   */
  @Override
  public void sort(T[] array, int leftIndex, int rightIndex) {
    if (casoBase(array, leftIndex, rightIndex))
      return;

    if (bubble(array, leftIndex, rightIndex))
      sort(array, leftIndex, rightIndex - 1);
  }

  private boolean bubble(T[] array, int leftIndex, int rightIndex) {
    if (leftIndex >= rightIndex)
      return false;

    boolean trocou = false;
    if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0) {
      Util.swap(array, leftIndex, leftIndex + 1);
      trocou = true;
    }

    boolean trocaFutura = bubble(array, leftIndex + 1, rightIndex);
    if (trocaFutura)
      trocou = true;

    return trocou;
  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex >= rightIndex || rightIndex >= array.length || leftIndex < 0;
  }
}
