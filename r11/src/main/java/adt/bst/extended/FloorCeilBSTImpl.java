package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

  @Override
  public Integer floor(Integer[] array, double numero) {
    fillBST(array, 0);
    return searchFloor(this.root, numero);
  }

  private Integer searchFloor(BSTNode<Integer> node, double number) {
    Integer result = null;

    if (!node.isEmpty()) {
      if (node.getData() > number) {
        result = searchFloor((BSTNode<Integer>) node.getLeft(), number);
      } else {
        result = searchFloor((BSTNode<Integer>) node.getRight(), number);
        if (result == null) {
          result = node.getData();
        }
      }
    }
    return result;
  }

  @Override
  public Integer ceil(Integer[] array, double numero) {
    fillBST(array, 0);
    return searchCeil(this.root, numero);
  }

  private Integer searchCeil(BSTNode<Integer> node, double number) {
    Integer result = null;

    if (!node.isEmpty()) {
      if (node.getData() < number) {
        result = searchCeil((BSTNode<Integer>) node.getRight(), number);
      } else {
        result = searchCeil((BSTNode<Integer>) node.getLeft(), number);
        if (result == null) {
          result = node.getData();
        }
      }
    }
    return result;
  }

  private void fillBST(Integer[] array, int i) {
    if (i < array.length) {
      this.insert(array[i]);
      fillBST(array, ++i);
    }
  }

}
