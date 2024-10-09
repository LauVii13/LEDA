package adt.bt;

import adt.bst.BSTNode;

public class Util {

  /**
   * A rotacao a esquerda em node deve subir e retornar seu filho a direita
   * 
   * @param node
   * @return - noh que se tornou a nova raiz
   */
  public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
    BSTNode<T> aux = (BSTNode<T>) node.getRight();

    aux.setParent(node.getParent());
    node.setParent(aux);
    node.setRight(aux.getLeft());
    aux.setLeft(node);

    if (aux.getParent() != null) {
      aux.getParent().setLeft(aux);
    }

    return aux;
  }

  /**
   * A rotacao a direita em node deve subir e retornar seu filho a esquerda
   * 
   * @param node
   * @return noh que se tornou a nova raiz
   */
  public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
    BSTNode<T> aux = (BSTNode<T>) node.getLeft();

    aux.setParent(node.getParent());
    node.setParent(aux);
    node.setLeft(aux.getRight());
    aux.setRight(node);

    if (aux.getParent() != null) {
      aux.getParent().setLeft(aux);
    }

    return aux;
  }

  public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Comparable[size];
    return array;
  }
}
