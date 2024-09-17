package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

  @Override
  public boolean equals(BST<T> tree1, BST<T> tree2) {
    return equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
  }

  private boolean equals(BSTNode<T> node1, BSTNode<T> node2) {
    boolean result = false;

    if (areBothEmpty(node1, node2)) {
      result = true;
    } else if (areEquals(node1, node2)) {
      result = equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft())
          && equals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
    }

    return result;
  }

  @Override
  public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
    return isSimilar((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
  }

  private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
    boolean result = false;

    if (areBothEmpty(node1, node2)) {
      result = true;
    } else if (bothHaveData(node1, node2)) {
      result = isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft())
          && isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
    }

    return result;
  }

  @Override
  public T orderStatistic(BST<T> tree, int k) {
    T result = null;

    if (k >= 1) {
      result = orderStatistic(tree, tree.minimum(), k);
    }

    return result;
  }

  private T orderStatistic(BST<T> tree, BSTNode<T> node, int k) {
    T result = null;

    if (!node.isEmpty()) {
      if (k == 1) {
        result = node.getData();
      } else {
        result = orderStatistic(tree, tree.sucessor(node.getData()), --k);
      }
    }

    return result;
  }

  private boolean areBothEmpty(BSTNode<T> node1, BSTNode<T> node2) {
    return node1.isEmpty() && node2.isEmpty();
  }

  private boolean areEquals(BSTNode<T> node1, BSTNode<T> node2) {
    return bothHaveData(node1, node2) && node1.getData().compareTo(node2.getData()) == 0;
  }

  private boolean bothHaveData(BSTNode<T> node1, BSTNode<T> node2) {
    return !node1.isEmpty() && !node2.isEmpty();
  }
}