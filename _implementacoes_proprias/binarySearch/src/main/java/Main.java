import binarySearch.basic.BinarySearch;
import binarySearch.basic.Floor;
import binarySearch.recursive.RecursiveBinarySearch;
import binarySearch.recursive.RecursiveFloor;
import binarySearch.AbstractBinarySearch;

public class Main {

  public static void main(String[] args) {
    // AbstractBinarySearch<Integer> bs = new BinarySearch<>();
    // AbstractBinarySearch<Integer> bs = new RecursiveBinarySearch<>();
    // AbstractBinarySearch<Integer> bs = new Floor<>();
    AbstractBinarySearch<Integer> bs = new RecursiveFloor<>();

    Integer[] array1 = { 0, 1, 3, 4, 5 };
    Integer[] array2 = { 0, 3, 4, 5, 6 };
    Integer[] array3 = { 1, 2, 3, 5, 7 };

    System.out.println("--");
    System.out.println(bs.binSearch(array1, 0, array1.length - 1, 4));
    System.out.println("--");
    System.out.println(bs.binSearch(array1, 0, array1.length - 1, 2));
    System.out.println("--");
    System.out.println(bs.binSearch(array2, 0, array2.length - 1, 2));
    System.out.println("--");
    System.out.println(bs.binSearch(array3, 0, array3.length - 1, 4));
    System.out.println("--");
  }

}
