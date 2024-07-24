package recursao;

public class TestarMetodosRecursivos {
  public static void main(String[] args) {
    MetodosRecursivos rec = new MetodosRecursivos();

    int[] listaInteiros = { 1, 2, 3, 4, 5 };
    System.out.println(rec.calcularSomaArray(listaInteiros));

    System.out.println("--------------------------------");

    rec.calcularFatorial(12);

    System.out.println("--------------------------------");

    System.out.println(rec.calcularFibonacci(10));

    System.out.println("--------------------------------");

    Object[] listaObjectsNull = { 1, 2, null, null, 5 };
    System.out.println(rec.countNotNull(listaObjectsNull));

    System.out.println("--------------------------------");

    System.out.println(rec.potenciaDe2(4));

    System.out.println("--------------------------------");

    System.out.println(rec.progressaoAritmetica(4, 2, 5));

    System.out.println("--------------------------------");

    System.out.println(rec.progressaoGeometrica(4, 2, 5));
  }
}
