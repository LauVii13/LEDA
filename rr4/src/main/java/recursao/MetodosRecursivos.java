package recursao;

import java.util.Arrays;

public class MetodosRecursivos {

  public int calcularSomaArray(int[] array) {
    if (array.length == 0)
      return 0;

    return array[0] + calcularSomaArray(Arrays.copyOfRange(array, 1, array.length));
  }

  public long calcularFatorial(int n) {
    long result = 1;

    if (n > 0)
      result = n * calcularFatorial(n - 1);

    System.out.println(n + "! = " + result);

    return result;
  }

  public int calcularFibonacci(int n) {
    if (n == 1 || n == 2)
      return 1;

    return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
  }

  public int countNotNull(Object[] array) {
    return countNotNull(array, 0);
  }

  private int countNotNull(Object[] array, int index) {
    if (index == array.length)
      return 0;

    int result = 0;
    if (array[index] != null)
      result++;

    return result + countNotNull(array, ++index);
  }

  public long potenciaDe2(int expoente) {
    if (expoente == 0)
      return 1;

    return 2 * potenciaDe2(expoente - 1);
  }

  public double progressaoAritmetica(double termoInicial, double razao, int n) {
    if (n == 1)
      return termoInicial;

    return progressaoAritmetica(termoInicial, razao, n - 1) + razao;
  }

  public double progressaoGeometrica(double termoInicial, double razao, int n) {
    if (n == 1)
      return termoInicial;

    return progressaoGeometrica(termoInicial, razao, n - 1) * razao;
  }

}
