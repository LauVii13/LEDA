package main.linkedList.rotateLinkedList;

import main.linkedList.RecursiveLinkedListImpl;

public class RotateLinkedListImpl<T> extends RecursiveLinkedListImpl<T> {
  public void rotate(int k) {
    if (k > 0) {
      this.recursiveRotate();
      this.rotate(k - 1);
    }
  }

  public void recursiveRotate() {
    if (!this.isEmpty() && !this.next.isEmpty()) {

      ((RotateLinkedListImpl<T>) this.next).recursiveRotate();

      T thisData = this.data;
      this.data = this.next.getData();
      this.next.setData(thisData);
    }
  }
}
