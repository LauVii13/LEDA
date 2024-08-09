package binarysearch;

public abstract class AbstractBinarySearch<T extends Comparable<T>> implements
    Searching<T> {

  @Override
  public int binSearch(T[] array, T k) {
    return binSearch(array, 0, array.length - 1, k);
  }

  /**
   * 
   * @param array
   *                   the target of the binary search
   * @param leftIndex
   *                   where the searching should begin
   * @param rightIndex
   *                   where the searching should end
   * @param k
   *                   value searched in the binary search
   */
  public abstract int binSearch(T[] array, int leftIndex, int rightIndex, T k);

}
