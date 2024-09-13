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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Not implemented yet!");
  }

  @Override
  public BSTNode<T> search(T element) {
    BSTNode<T> aux = this.root;

    if (element != null) {
      while (!aux.isEmpty() && !aux.getData().equals(element)) {
        if (aux.getData().compareTo(element) < 0) {
          aux = (BSTNode<T>) aux.getRight();
        } else{
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
        } else{
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
    return maximum(this.root);
  }

  private BSTNode<T> maximum(BSTNode<T> element){
    BSTNode<T> aux = element;
    aux = maximum((BSTNode<T>) aux.getRight());
    
    return (BSTNode<T>) aux.getParent();
  }

  @Override
  public BSTNode<T> minimum() {
    return minimum(this.root);
  }

  private BSTNode<T> minimum(BSTNode<T> element){
    BSTNode<T> aux = element;
    aux = minimum((BSTNode<T>) aux.getLeft());

    return (BSTNode<T>) aux.getParent();
  }

  @Override
  public BSTNode<T> sucessor(T element) {
    BSTNode<T> aux = search(element);
    BSTNode<T> auxParent = (BSTNode<T>) aux.getParent();

    if(minimum((BSTNode<T>) aux.getRight()) != null){
      aux = minimum((BSTNode<T>) aux.getRight());
    }else{
      while(aux.getParent() != null && aux.getData().compareTo(auxParent.getData()) > 0){
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

    if(maximum((BSTNode<T>) aux.getLeft()) != null){
      aux = maximum((BSTNode<T>) aux.getLeft());
    }else{
      while(aux.getParent() != null && aux.getData().compareTo(auxParent.getData()) < 0){
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
    if(aux != null){
      remove(aux);
    }
  }

  private void remove(BSTNode<T> node){
    if(node.isLeaf()){
      node = new BSTNode<>();
    }else if(node.getLeft() != null && node.getRight() != null){
      node.setData(node.getRight().getData());
      remove((BSTNode<T>) node.getRight());
    }else{
      BSTNode<T> aux = new BSTNode<>();
      if(node.getLeft() != null){
        aux = (BSTNode<T>) node.getLeft();
        aux.setParent(node.getParent());
      }else{
        aux = (BSTNode<T>) node.getRight();
        aux.setParent(node.getParent());
      }

      if(aux.getParent() != null){
        if(aux.getData().compareTo(aux.getParent().getData()) < 0){
          aux.getParent().setLeft(aux);
        }else{
          aux.getParent().setRight(aux);
        }
      }else{
        this.root = aux;
      }
    }
  }

  @Override
  public T[] preOrder() {
    return (T[]) preOrder(this.root).toArray();
  }

  @Override
  public T[] order() {
    return (T[]) order(this.root).toArray();
  }

  @Override
  public T[] postOrder() {
    return (T[]) postOrder(this.root).toArray();
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

  private LinkedList<T> order(BSTNode<T> node) {
    LinkedList<T> result = new LinkedList<>();

    if (!node.isEmpty()) {
      result.addAll(order((BSTNode<T>) node.getLeft()));
      result.add(visit(node));
      result.addAll(order((BSTNode<T>) node.getRight()));
    }

    return result;
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
