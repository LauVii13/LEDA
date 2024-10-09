package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 * - insert
 * - preOrder
 * - postOrder
 * - remove
 * - height
 * - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
    AVLTree<T> {

  // TODO Do not forget: you must override the methods insert and remove
  // conveniently.

  // AUXILIARY
  protected int calculateBalance(BSTNode<T> node) {
    int result = 0;
    if (node != null) {
      result = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
    }

    return result;
  }

  // AUXILIARY
  protected void rebalance(BSTNode<T> node) {
    int balance = calculateBalance(node);
    if (balance < -1 || balance > 1) {
      rotacionaCasos(validaCaso(node), node);
    }

    if (this.root.getParent() != null) {
      this.root = (BSTNode<T>) this.root.getParent();
    }
  }

  private String validaCaso(BSTNode<T> node) {
    String result = null;

    if (calculateBalance(node) > 0) { // L
      if (calculateBalance((BSTNode<T>) node.getLeft()) > 0) { // LL
        result = "LL";
      } else { // LR
        result = "LR";
      }
    } else { // RR
      if (calculateBalance((BSTNode<T>) node.getRight()) > 0) { // RL
        result = "RL";
      } else { // RR
        result = "RR";
      }
    }

    return result;
  }

  private void rotacionaCasos(String caso, BSTNode<T> node) {
    switch (caso) {
      case "LL":
        Util.rightRotation(node);
        break;

      case "RR":
        Util.leftRotation(node);
        break;

      case "LR":
        Util.leftRotation((BSTNode<T>) node.getLeft());
        rotacionaCasos("LL", node);
        break;

      case "RL":
        Util.rightRotation((BSTNode<T>) node.getRight());
        rotacionaCasos("RR", node);
        break;

      default:
        break;
    }
  }

  // AUXILIARY
  protected void rebalanceUp(BSTNode<T> node) {
    BSTNode<T> parent = (BSTNode<T>) node.getParent();
    while (parent != null) {
      rebalance(parent);
      parent = (BSTNode<T>) parent.getParent();
    }
  }

  @Override
  public void insert(T element) {
    if (element != null) {
      insert(element, this.root);
    }
  }

  @Override
  protected void insert(T element, BSTNode<T> node) {
    if (node.isEmpty()) {
      insertNewLeafNode(node, element);
    } else {
      if (node.getData().compareTo(element) < 0) {
        insert(element, (BSTNode<T>) node.getRight());
      } else {
        insert(element, (BSTNode<T>) node.getLeft());
      }
      rebalance(node);
    }
  }

  @Override
  public void remove(T element) {
    BSTNode<T> aux = search(element);
    if (aux != null && !aux.isEmpty()) {
      remove(aux);
    }
  }

  @Override
  protected void remove(BSTNode<T> node) {
    BSTNode<T> aux = new BSTNode<>();
    if (node.isLeaf()) {
      aux.setParent(node.getParent());
      connectChild(aux, node.getData());
      rebalanceUp(node);
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

      rebalanceUp(node);
    }
  }
}
