package binarySearch;

/**
 * The interface of all sorting algorithms. It contains only the signature of
 * the sort method, which must be implemented according to the exercice's
 * specific algorithm.
 */
public interface Searching<T extends Comparable<T>> {

  /**
   * It sorts the array in increasing order considering all its elements.
   * 
   * @param array
   *              the target of the sorting algorithm
   */
  public int binSearch(T[] array);
}
