public class RotateLinkedListImpl<T> extends RecursiveLinkedListImpl<T> {
  public void rotate(int k) {
    if (k > 0) {
      this.recursiveRotate();
      this.rotate(k - 1);
    }
  }

  public void recursiveRotate() {
    if (!this.isEmpty() && !this.next.isEmpty()) {

      RotateLinkedListImpl<T> aux = new RotateLinkedListImpl<>();
      aux.setData(this.next.getData());
      aux.setNext(this.next.getNext());

      this.next = new RotateLinkedListImpl<>();
      this.next.setData(aux.getData());
      this.next.setNext(aux.getNext());

      ((RotateLinkedListImpl<T>) this.next).recursiveRotate();

      T thisData = this.data;
      this.data = this.next.getData();
      this.next.setData(thisData);
    }
  }
}
