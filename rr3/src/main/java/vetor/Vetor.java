package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

  // O array interno onde os objetos manipulados são guardados
  private T[] arrayInterno;

  // O tamanho que o array interno terá
  private int tamanho;

  // Indice que guarda a proxima posição vazia do array interno
  private int indice;

  // O Comparators a serem utilizados
  private Comparator<T> comparadorMaximo;
  private Comparator<T> comparadorMinimo;

  public Vetor(int tamanho) {
    super();
    this.tamanho = tamanho;
    this.indice = -1;
    this.arrayInterno = (T[]) new Comparable[tamanho];
  }

  public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
    this.comparadorMaximo = comparadorMaximo;
  }

  public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
    this.comparadorMinimo = comparadorMinimo;
  }

  // Insere um objeto no vetor
  public void inserir(T o) {
    if (this.indice + 1 >= this.tamanho)
      return;
    this.arrayInterno[++this.indice] = o;
  }

  // Remove um objeto do vetor
  public T remover(T o) {
    if (procurar(o) == null)
      return null;

    int j = 0;
    for (int i = 0; i <= this.indice; i++) {
      if (o.equals(this.arrayInterno[i]))
        continue;

      this.arrayInterno[j++] = this.arrayInterno[i];
    }
    this.arrayInterno[this.indice--] = null;

    return o;
  }

  // Procura um elemento no vetor
  public T procurar(T o) {
    for (T n : this.arrayInterno) {
      if (o.equals(n))
        return n;
    }
    return null;
  }

  // Diz se o vetor está vazio
  public boolean isVazio() {
    return this.indice < 0;
  }

  // Diz se o vetor está cheio
  public boolean isCheio() {
    return this.indice + 1 >= this.tamanho;
  }

  public T maximo() {
    if (isVazio())
      return null;

    T maior = this.arrayInterno[0];

    for (int i = 1; i <= this.indice; i++) {
      T atual = this.arrayInterno[i];

      if (comparadorMaximo.compare(atual, maior) > 0)
        maior = atual;
    }

    return maior;
  }

  public T minimo() {
    if (isVazio())
      return null;

    T menor = this.arrayInterno[0];

    for (int i = 1; i <= this.indice; i++) {
      T atual = this.arrayInterno[i];

      if (comparadorMinimo.compare(atual, menor) < 0)
        menor = atual;
    }

    return menor;
  }
}

class ComparadorMaximo implements Comparator<Aluno> {

  @Override
  public int compare(Aluno o1, Aluno o2) {
    return (int) (o1.getMedia() - o2.getMedia());
  }

}

class ComparadorMinimo implements Comparator<Aluno> {

  @Override
  public int compare(Aluno o1, Aluno o2) {
    return (int) (o1.getMedia() - o2.getMedia());
  }

}