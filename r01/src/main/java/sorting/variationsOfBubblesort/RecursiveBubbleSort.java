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
    if (leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex) {
      // casos de exceção
    } else {
      boolean trocou = bubble(array, leftIndex, rightIndex);
      if(trocou)
        sort(array, leftIndex, rightIndex - 1);
    }
  }

  private boolean bubble(T[] array, int leftIndex, int rightIndex) {
    boolean trocou = false;
    if (leftIndex >= rightIndex) {
    } else {
      if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0){
          Util.swap(array, leftIndex, leftIndex + 1);
          trocou = true;
        }

      boolean trocaFutura = bubble(array, leftIndex + 1, rightIndex);
      if(trocaFutura)
        trocou = true;
    }

    return trocou;
  }

}