package binarysearch;

/**
 */
public interface Searching<T extends Comparable<T>> {

  /**
   * 
   * @param array
   *              the target of the binary search algorithm
   */
  public int binSearch(T[] array, T k);
}
