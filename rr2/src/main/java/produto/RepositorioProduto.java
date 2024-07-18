package produto;

public interface RepositorioProduto<T> {
  
  public int procurarIndice(int codigo);

  public boolean existe(int codigo);

  public void inserir(T o);

  public void atualizar(T o);
  
  public void remover(int codigo);

  public T procurar(int codigo);
}
