package binarySearch;

public abstract class AbstractBinarySearch<T extends Comparable<T>> implements
    Searching<T> {

  @Override
  public int binSearch(T[] array) {
    return binSearch(array, 0, array.length - 1, array[0]);
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
