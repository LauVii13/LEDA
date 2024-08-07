package orderStatistic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Integer[] numbers = {4, 8, 7, 3, 0, 9, 2, -1, 6, 5};
        KLargest<Integer> kl = new KLargestOrderStatisticsImpl<>();

        System.out.println(Arrays.toString(kl.getKLargest(numbers, -1)));
    }
}
