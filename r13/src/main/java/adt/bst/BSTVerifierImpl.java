package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

  private BSTImpl<T> bst;

  public BSTVerifierImpl(BST<T> bst) {
    this.bst = (BSTImpl<T>) bst;
  }

  private BSTImpl<T> getBSt() {
    return bst;
  }

  @Override
  public boolean isBST() {
    return isBST(getBSt().getRoot());
  }

  private boolean isBST(BSTNode<T> node) {
    boolean result = true;

    if (!node.isEmpty()) {
      BSTNode<T> maxLeftNode = (BSTNode<T>) node.getLeft();
      BSTNode<T> minRightNode = (BSTNode<T>) node.getLeft();

      while (!maxLeftNode.isEmpty()) {
        maxLeftNode = (BSTNode<T>) maxLeftNode.getRight();
      }

      while (!minRightNode.isEmpty()) {
        minRightNode = (BSTNode<T>) minRightNode.getLeft();
      }

      maxLeftNode = (BSTNode<T>) maxLeftNode.getParent();
      minRightNode = (BSTNode<T>) maxLeftNode.getParent();

      if (maxLeftNode.getData().compareTo(node.getData()) < 0 && minRightNode.getData().compareTo(node.getData()) > 0) {
        result = isBST((BSTNode<T>) node.getLeft()) && isBST((BSTNode<T>) node.getRight());
      } else {
        result = false;
      }
    }

    return result;
  }

}
