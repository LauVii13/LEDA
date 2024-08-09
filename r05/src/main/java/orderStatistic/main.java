package orderStatistic;

import java.lang.reflect.Array;
import java.util.Arrays;

import problems.FloorBinarySearchImpl;

public class main {
  public static void main(String[] args) {
    Integer[] numbers = { 4, 8, 7, 3, 0, 9, 1, 6 };
    KLargest<Integer> kl = new KLargestOrderStatisticsImpl<>();
    QuickSelect<Integer> quickSelect = new QuickSelect<>();
    FloorBinarySearchImpl floorSearch = new FloorBinarySearchImpl();

    System.out.println(floorSearch.floor(numbers, 2));

    // System.out.println(quickSelect.quickSelect(numbers, 8));
    // System.out.println(Arrays.toString(kl.getKLargest(numbers, 7)));
  }
}
