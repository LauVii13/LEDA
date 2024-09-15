package adt.bst;

import java.util.LinkedList;

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
    return height(this.root);
  }

  private int height(BSTNode<T> node) {
    int result = -1;
    if (!node.isEmpty()) {
      result = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
    }
    return result;
  }

  @Override
  public BSTNode<T> search(T element) {
    BSTNode<T> result = new BSTNode<>();
    if (element != null) {
      result = search(element, this.root);
    }
    return result;
  }

  private BSTNode<T> search(T element, BSTNode<T> node) {
    if (!node.isEmpty() && node.getData().compareTo(element) != 0) {
      if (node.getData().compareTo(element) < 0) {
        node = search(element, (BSTNode<T>) node.getRight());
      } else {
        node = search(element, (BSTNode<T>) node.getLeft());
      }
    }
    return node;
  }

  @Override
  public void insert(T element) {
    if (element != null) {
      insert(element, this.root);
    }
  }

  private void insert(T element, BSTNode<T> node) {
    if (node.isEmpty()) {
      node.setData(element);

      node.setLeft(new BSTNode<>());
      node.setRight(new BSTNode<>());

      node.getLeft().setParent(node);
      node.getRight().setParent(node);
    } else {
      if (node.getData().compareTo(element) < 0) {
        insert(element, (BSTNode<T>) node.getRight());
      } else {
        insert(element, (BSTNode<T>) node.getLeft());
      }
    }
  }

  @Override
  public BSTNode<T> maximum() {
    return maximum(this.root);
  }

  private BSTNode<T> maximum(BSTNode<T> element) {
    BSTNode<T> aux = element;
    if (aux == null || aux.isEmpty()) {
      aux = null;
    } else {
      aux = maximum((BSTNode<T>) aux.getRight());
      if (aux == null) {
        aux = (BSTNode<T>) element;
      }
    }

    return aux;
  }

  @Override
  public BSTNode<T> minimum() {
    return minimum(this.root);
  }

  private BSTNode<T> minimum(BSTNode<T> element) {
    BSTNode<T> aux = element;
    if (aux == null || aux.isEmpty()) {
      aux = null;
    } else {
      aux = minimum((BSTNode<T>) aux.getLeft());
      if (aux == null) {
        aux = (BSTNode<T>) element;
      }
    }

    return aux;
  }

  @Override
  public BSTNode<T> sucessor(T element) {
    BSTNode<T> aux = search(element);
    BSTNode<T> auxParent = (BSTNode<T>) aux.getParent();

    if (minimum((BSTNode<T>) aux.getRight()) != null) {
      aux = minimum((BSTNode<T>) aux.getRight());
    } else {
      while (aux.getParent() != null && aux.getData().compareTo(auxParent.getData()) > 0) {
        aux = (BSTNode<T>) auxParent;
        auxParent = (BSTNode<T>) auxParent.getParent();
      }

      aux = auxParent;
    }

    return aux;
  }

  @Override
  public BSTNode<T> predecessor(T element) {
    BSTNode<T> aux = search(element);
    BSTNode<T> auxParent = (BSTNode<T>) aux.getParent();

    if (maximum((BSTNode<T>) aux.getLeft()) != null) {
      aux = maximum((BSTNode<T>) aux.getLeft());
    } else {
      while (aux.getParent() != null && aux.getData().compareTo(auxParent.getData()) < 0) {
        aux = (BSTNode<T>) auxParent;
        auxParent = (BSTNode<T>) auxParent.getParent();
      }
      aux = auxParent;
    }
    return aux;
  }

  @Override
  public void remove(T element) {
    BSTNode<T> aux = search(element);
    if (aux != null) {
      remove(aux);
    }
  }

  private void remove(BSTNode<T> node) {
    BSTNode<T> aux = new BSTNode<>();
    if (node.isLeaf()) {
      aux.setParent(node.getParent());
      connectChild(aux, node.getData());
    } else if (!node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
      aux = sucessor(node.getData());
      node.setData(aux.getData());
      remove(aux);
    } else {
      if (!node.getLeft().isEmpty()) {
        aux = (BSTNode<T>) node.getLeft();
        aux.setParent(node.getParent());
      } else {
        aux = (BSTNode<T>) node.getRight();
        aux.setParent(node.getParent());
      }
      connectChild(aux, aux.getData());
    }
  }

  private void connectChild(BSTNode<T> child, T element) {
    if (child.getParent() != null) {
      if (element.compareTo(child.getParent().getData()) < 0) {
        child.getParent().setLeft(child);
      } else {
        child.getParent().setRight(child);
      }
    } else {
      this.root = child;
    }
  }

  @Override
  public T[] preOrder() {
    LinkedList<T> result = preOrder(this.root);
    return result.toArray((T[]) new Comparable[size()]);
  }

  private LinkedList<T> preOrder(BSTNode<T> node) {
    LinkedList<T> result = new LinkedList<>();

    if (!node.isEmpty()) {
      result.add(visit(node));
      result.addAll(preOrder((BSTNode<T>) node.getLeft()));
      result.addAll(preOrder((BSTNode<T>) node.getRight()));
    }

    return result;
  }

  @Override
  public T[] order() {
    LinkedList<T> result = order(this.root);
    return result.toArray((T[]) new Comparable[size()]);
  }

  private LinkedList<T> order(BSTNode<T> node) {
    LinkedList<T> result = new LinkedList<>();

    if (!node.isEmpty()) {
      result.addAll(order((BSTNode<T>) node.getLeft()));
      result.add(visit(node));
      result.addAll(order((BSTNode<T>) node.getRight()));
    }

    return result;
  }

  @Override
  public T[] postOrder() {
    LinkedList<T> result = postOrder(this.root);
    return result.toArray((T[]) new Comparable[size()]);
  }

  private LinkedList<T> postOrder(BSTNode<T> node) {
    LinkedList<T> result = new LinkedList<>();

    if (!node.isEmpty()) {
      result.addAll(postOrder((BSTNode<T>) node.getLeft()));
      result.addAll(postOrder((BSTNode<T>) node.getRight()));
      result.add(visit(node));
    }

    return result;
  }

  private T visit(BSTNode<T> node) {
    return node.getData();
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
