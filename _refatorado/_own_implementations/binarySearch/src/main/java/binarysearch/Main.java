package binarysearch;

import binarysearch.implementations.Classic;
import binarysearch.implementations.Recursive;
import binarysearch.implementations.RecursiveCeil;

public class Main {
  public static void main(String[] args) {
    Integer[] unitSize = { 2 };
    Integer[] sortedDistinctNumbers = { 0, 1, 2, 3, 5, 7, 8, 9, 13, 14, 15, 16, 17 };
    Integer[] sortedNumbers = { 0, 0, 1, 1, 1, 2, 3, 5, 5, 5, 7, 8, 9, 9, 13, 13, 14, 14, 14, 15, 16, 16, 16 };

    // AbstractBinarySearch<Integer> binarySearch = new Classic<>();
    // AbstractBinarySearch<Integer> binarySearch = new Recursive<>();
    AbstractBinarySearch<Integer> binarySearch = new RecursiveCeil<>();
    System.out.println(binarySearch.binSearch(unitSize, -2));
    System.out.println(binarySearch.binSearch(unitSize, -2));
    System.out.println(binarySearch.binSearch(sortedDistinctNumbers, 4));
    System.out.println(binarySearch.binSearch(sortedNumbers, 100));

  }
}
