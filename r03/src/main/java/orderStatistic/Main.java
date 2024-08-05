package orderStatistic;

public class Main {
  public static void main(String[] args) {
    OrderStatisticsSelectionImpl<Integer> s = new OrderStatisticsSelectionImpl<>();
    Integer[] lista = { 199999999, 6, 5, 4, 3, 2, 1 };
    System.out.println(s.getOrderStatistics(lista, 1));
  }
}
