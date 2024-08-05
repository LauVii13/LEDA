package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

  /**
   * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a
   * estrategia
   * de usar o selection sem modificar o array original. Note que seu algoritmo
   * vai
   * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de
   * ordem
   * desejada sem modificar o array original.
   * 
   * Restricoes:
   * - Voce NÃO pode modificar o aray original
   * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e
   * utilizado.
   * - Você NÃO pode usar métodos já prontos de manipulação de arrays
   * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
   * elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar
   * um elemento
   * usando a ideia do selection sort).
   * - Considere que k varia de 1 a N
   * - Você pode implementar métodos auxiliares, desde que seja apenas nesta
   * classe.
   */
  @Override
  public T getOrderStatistics(T[] array, int k) {
    T result = null;
    if (array.length == 0) {
      // caso base
    } else {
      int kEsimoIndice = selectionSort(array, k);
      result = array[kEsimoIndice];
    }
    return result;
  }

  private int selectionSort(T[] array, int k) {
    // calculando a primeira ocorrencia para simplificar os 'if' do pegaMenor para o
    // primeiro caso
    int iMenor = primeiraOcorrenciaK(array);

    for (int i = 2; i <= k; i++) {
      iMenor = pegaMenor(array, iMenor);
      // original -> swap iMenor, i
    }

    return iMenor;
  }

  private int pegaMenor(T[] array, int menorK) {
    int indiceMenor = -1;

    for (int i = 0; i < array.length; i++) {
      if (indiceMenor >= 0) {
        if (array[i].compareTo(array[indiceMenor]) < 0 && array[i].compareTo(array[menorK]) > 0)
          indiceMenor = i;
      } else {
        // se ainda nao foi definido a primeira ocorrencia > menorK:
        if (array[i].compareTo(array[menorK]) > 0)
          indiceMenor = i;
      }
    }
    return indiceMenor;
  }

  private int primeiraOcorrenciaK(T[] array) {
    int iMenor = 0;
    for (int i = 1; i < array.length; i++)
      if (array[i].compareTo(array[iMenor]) < 0)
        iMenor = i;

    return iMenor;
  }

}
