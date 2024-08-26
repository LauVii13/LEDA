package problems;

/**
 * Classe com metodos para calcular raiz n-esima de um numero com aproximacao
 * e para encontrar os limites que dividem um array em 3 partes de mesmo tamanho
 * 
 * @author adalbertocajueiro
 *
 */
public class RaizImpl implements Raiz {

  public double raiz(int numero, int raiz, double erro) {
    double result;
    if (numero < 0) {
      result = -1;
    } else {
      result = binarySearch(numero, raiz, erro, 0, numero);
    }
    return result;
  }

  private double binarySearch(int numero, int raiz, double erro, double leftValue, double rightValue) {
    double result = -1;
    if (leftValue > rightValue) {
    } else {
      double meio = (leftValue + rightValue) / 2;

      double limiteSuperior = calculaPotencia(meio + erro, raiz);
      double limiteInferior;
      if (erro <= meio)
        limiteInferior = calculaPotencia(meio - erro, raiz);
      else
        limiteInferior = calculaPotencia(meio, raiz);

      if (limiteInferior < numero && limiteSuperior > numero)
        result = meio;
      else if (limiteInferior > numero)
        result = binarySearch(numero, raiz, erro, leftValue, meio - erro);
      else
        result = binarySearch(numero, raiz, erro, meio + erro, rightValue);
    }
    return result;
  }

  private double calculaPotencia(double valor, int contador) {
    if (contador <= 1) {
    } else {
      valor *= calculaPotencia(valor, contador - 1);
    }

    return valor;
  }
}
