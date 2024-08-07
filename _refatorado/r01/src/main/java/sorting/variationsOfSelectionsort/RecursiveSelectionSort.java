package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
    AbstractSorting<T> {

  /**
   * Implementação recursiva do selection sort. Você deve implementar apenas
   * esse método sem usar nenhum outro método auxiliar (exceto
   * Util.swap(array,int,int)). Para isso, tente definir o caso base do
   * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
   * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
   * quadrática O(n^2).
   */
  @Override
  public void sort(T[] array, int leftIndex, int rightIndex) {
    if (casoBase(array, leftIndex, rightIndex))
      return;

    int pegaMenor = pegaMenor(array, leftIndex, rightIndex);

    Util.swap(array, leftIndex, pegaMenor);
    sort(array, leftIndex + 1, rightIndex);
  }

  private int pegaMenor(T[] array, int leftIndex, int rightIndex) {

    if (leftIndex >= rightIndex)
      return leftIndex;

    int menorAtual = leftIndex;
    int proximoMenor = pegaMenor(array, leftIndex + 1, rightIndex);

    if (array[menorAtual].compareTo(array[proximoMenor]) >= 0)
      menorAtual = proximoMenor;

    return menorAtual;
  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex >= rightIndex || rightIndex >= array.length || leftIndex < 0;
  }
}
