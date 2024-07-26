package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
    AbstractSorting<T> {

  @Override
  public void sort(T[] array, int leftIndex, int rightIndex) {
    if (casoBase(array, leftIndex, rightIndex))
      return;

    boolean trocouRight = bubbleToRight(array, leftIndex, rightIndex);
    boolean trocouLeft = bubbleToLeft(array, leftIndex, rightIndex);

    if (trocouRight || trocouLeft)
      sort(array, leftIndex + 1, rightIndex - 1);
  }

  private boolean bubbleToRight(T[] array, int leftIndex, int rightIndex) {
    if (leftIndex >= rightIndex)
      return false;

    boolean trocou = false;
    if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0) {
      Util.swap(array, leftIndex, leftIndex + 1);
      trocou = true;
    }

    boolean trocaFutura = bubbleToRight(array, leftIndex + 1, rightIndex);
    if (trocaFutura)
      trocou = true;

    return trocou;

  }

  private boolean bubbleToLeft(T[] array, int leftIndex, int rightIndex) {
    if (leftIndex >= rightIndex)
      return false;

    boolean trocou = false;
    if (array[rightIndex].compareTo(array[rightIndex - 1]) < 0) {
      Util.swap(array, rightIndex, rightIndex - 1);
      trocou = true;
    }

    boolean trocaFutura = bubbleToLeft(array, leftIndex, rightIndex - 1);
    if (trocaFutura)
      trocou = true;

    return trocou;
  }

  private boolean casoBase(T[] array, int leftIndex, int rightIndex) {
    return leftIndex >= rightIndex || rightIndex >= array.length || leftIndex < 0;
  }
}
