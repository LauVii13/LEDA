package vetor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestVetor {

  private Vetor<Aluno> vetor;

  @Before
  public void setUp() throws Exception {
    vetor = new Vetor<Aluno>(5);
    ComparadorMaximo compMax = new ComparadorMaximo();
    ComparadorMinimo compMinimo = new ComparadorMinimo();

    vetor.setComparadorMaximo(compMax);
    vetor.setComparadorMinimo(compMinimo);
  }

  @Test
  public void testInserir() {
    vetor.inserir(new Aluno("teste", 0));
    assertFalse(vetor.isVazio());
  }

  @Test
  public void testRemover() {
    Aluno al = new Aluno("teste", 0);
    vetor.inserir(al);
    vetor.remover(al);
    assertTrue(vetor.isVazio());
  }

  @Test
  public void testProcurar() {
    Aluno al = new Aluno("teste", 0);
    vetor.inserir(al);
    assertEquals(al, vetor.procurar(al));
    assertNull(vetor.procurar(new Aluno("teste2", 10)));
  }

  @Test
  public void testIsVazio() {
    assertTrue(vetor.isVazio());
  }

  @Test
  public void testIsCheio() {
    Aluno a1 = new Aluno("teste1", 6.5);
    Aluno a2 = new Aluno("teste2", 2.4);
    Aluno a3 = new Aluno("teste3", 10);
    Aluno a4 = new Aluno("teste4", 7.4);
    Aluno a5 = new Aluno("teste5", 8.2);

    vetor.inserir(a1);
    vetor.inserir(a2);
    vetor.inserir(a3);
    vetor.inserir(a4);
    vetor.inserir(a5);

    assertTrue(vetor.isCheio());
  }

  @Test
  public void testMaximo() {
    Aluno a1 = new Aluno("teste1", 6.5);
    Aluno a2 = new Aluno("teste2", 2.4);
    Aluno a3 = new Aluno("teste3", 10);
    Aluno a4 = new Aluno("teste4", 7.4);
    Aluno a5 = new Aluno("teste5", 8.2);

    vetor.inserir(a1);
    vetor.inserir(a2);
    vetor.inserir(a3);
    vetor.inserir(a4);
    vetor.inserir(a5);

    assertEquals(a3, vetor.maximo());
  }

  @Test
  public void testMinimo() {
    Aluno a1 = new Aluno("teste1", 6.5);
    Aluno a2 = new Aluno("teste2", 2.4);
    Aluno a3 = new Aluno("teste3", 10);
    Aluno a4 = new Aluno("teste4", 7.4);
    Aluno a5 = new Aluno("teste5", 8.2);

    vetor.inserir(a1);
    vetor.inserir(a2);
    vetor.inserir(a3);
    vetor.inserir(a4);
    vetor.inserir(a5);

    assertEquals(a2, vetor.minimo());
  }
}
