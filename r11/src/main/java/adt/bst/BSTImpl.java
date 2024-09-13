package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

  protected BSTNode<T> root;

  public BSTImpl() {
    root = new BSTNode<T>();
  }

  public BSTNode<T> getRoot() {
    return this.root;
  }

  @Override
  public boolean isEmpty() {
    return root.isEmpty();
  }

  @Override
  public int height() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Not implemented yet!");
  }

  @Override
  public BSTNode<T> search(T element) {
    boolean found = false;
    BSTNode<T> aux = this.root;

    if (element != null) {
      while (!found && !aux.isEmpty()) {
        if (aux.getData().compareTo(element) == 0) {
          found = true;
        } else if (aux.getData().compareTo(element) < 0) {
          aux = (BSTNode<T>) aux.getRight();
        } else if (aux.getData().compareTo(element) > 0) {
          aux = (BSTNode<T>) aux.getLeft();
        }
      }
    }
    return aux;
  }

  @Override
  public void insert(T element) {
    BSTNode<T> aux = this.root;

    if (element != null) {
      while (!aux.isEmpty()) {
        if (aux.getData().compareTo(element) < 0) {
          aux = (BSTNode<T>) aux.getRight();
        } else if (aux.getData().compareTo(element) > 0) {
          aux = (BSTNode<T>) aux.getLeft();
        }
      }

      aux.setData(element);

      aux.setLeft(new BSTNode<T>());
      aux.setRight(new BSTNode<T>());

      aux.getLeft().setParent(aux);
      aux.getRight().setParent(aux);
    }
  }

  @Override
  public BSTNode<T> maximum() {
    BSTNode<T> aux = this.root;

    while (!aux.isEmpty()) {
      aux = (BSTNode<T>) aux.getRight();
    }

    aux = (BSTNode<T>) aux.getParent();

    return aux;
  }

  @Override
  public BSTNode<T> minimum() {
    BSTNode<T> aux = this.root;

    while (!aux.isEmpty()) {
      aux = (BSTNode<T>) aux.getLeft();
    }

    aux = (BSTNode<T>) aux.getParent();

    return aux;
  }

  @Override
  public BSTNode<T> sucessor(T element) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Not implemented yet!");
  }

  @Override
  public BSTNode<T> predecessor(T element) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Not implemented yet!");
  }

  @Override
  public void remove(T element) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Not implemented yet!");
  }

  @Override
  public T[] preOrder() {
    // RED
    return preOrder(this.root);
  }

  @Override
  public T[] order() {
    // ERD
    return order(this.root);
  }

  @Override
  public T[] postOrder() {
    // EDR
    return postOrder(this.root);
    // T[] result = (T[]) new Comparable[size()];
    // int i = 0;

    // BSTNode<T> aux = this.root;

    // while (!aux.getParent().isEmpty()) {
    // while (!aux.isEmpty()) {
    // aux = (BSTNode<T>) aux.getLeft();
    // }

    // result[i++] = aux.getParent().getData();

    // aux = (BSTNode<T>) aux.getParent();

    // if (!aux.getRight().isEmpty()) {
    // aux = (BSTNode<T>) aux.getRight();
    // }
    // }

    // return result;
  }

  private T[] preOrder(BSTNode<T> node) {
    T[] result = (T[]) new Comparable[size()];

    if (!node.isEmpty()) {
      T[] arrayNode = visit(node);
      T[] arrayLeft = postOrder((BSTNode<T>) node.getLeft());
      T[] arrayRight = postOrder((BSTNode<T>) node.getRight());
      result = fillArray(arrayNode, arrayLeft, arrayRight);
    }

    return result;
  }

  private T[] order(BSTNode<T> node) {
    T[] result = (T[]) new Comparable[size()];

    if (!node.isEmpty()) {
      T[] arrayLeft = postOrder((BSTNode<T>) node.getLeft());
      T[] arrayNode = visit(node);
      T[] arrayRight = postOrder((BSTNode<T>) node.getRight());
      result = fillArray(arrayLeft, arrayNode, arrayRight);
    }

    return result;
  }

  private T[] postOrder(BSTNode<T> node) {
    T[] result = (T[]) new Comparable[size()];

    if (!node.isEmpty()) {
      T[] arrayLeft = postOrder((BSTNode<T>) node.getLeft());
      T[] arrayRight = postOrder((BSTNode<T>) node.getRight());
      T[] arrayNode = visit(node);
      result = fillArray(arrayLeft, arrayRight, arrayNode);
    }

    return result;
  }

  private T[] visit(BSTNode<T> node) {
    T[] result = (T[]) new Comparable[1];
    result[0] = node.getData();
    return result;
  }

  private T[] fillArray(T[] array1, T[] array2, T[] array3) {
    int i = 0;
    T[] result = (T[]) new Comparable[array1.length + array2.length + array3.length];

    for (T t : array1) {
      result[i++] = t;
    }

    for (T t : array2) {
      result[i++] = t;
    }

    for (T t : array3) {
      result[i++] = t;
    }

    return result;
  }

  /**
   * This method is already implemented using recursion. You must understand
   * how it work and use similar idea with the other methods.
   */
  @Override
  public int size() {
    return size(root);
  }

  private int size(BSTNode<T> node) {
    int result = 0;
    // base case means doing nothing (return 0)
    if (!node.isEmpty()) { // indusctive case
      result = 1 + size((BSTNode<T>) node.getLeft())
          + size((BSTNode<T>) node.getRight());
    }
    return result;
  }

}
