package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
    DoubleLinkedList<T> {

  protected DoubleLinkedListNode<T> last;

  @Override
  public void insertFirst(T element) {
    DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
    newHead.next = head;
    newHead.data = element;
    newHead.previous = new DoubleLinkedListNode<>();
    DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<>();
    aux.previous = newHead;
    aux.next = head.next;
    aux.data = head.data;
    if (head.isNIL()) {
      last = newHead;
    }
    head = newHead;
  }

  @Override
  public void removeFirst() {
    if (!isEmpty()) {
      head = head.next;
      if (head.isNIL()) {
        DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<>();
        head = aux;
        last = aux;
      } else {
        DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode();
        newHead.next = this.head.getNext();
        newHead.data = head.getData();
        newHead.previous = new DoubleLinkedListNode<>();
        head = newHead;
      }
    }
  }

  @Override
  public void removeLast() {
    if (!isEmpty() && !last.isNIL()) {
      last = last.previous;
      if (last.isNIL()) {
        DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<>();
        head = aux;
        last = aux;
      } else {
        DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
        newLast.previous = this.last;
        last.setNext(newLast);

      }
    }
  }

  @Override
  public void insert(T element) {
    if (this.head.isNIL()) {
      this.last = new DoubleLinkedListNode<>();
    }
    DoubleLinkedListNode<T> nodeNil = new DoubleLinkedListNode<>();
    DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>(element, nodeNil, this.last);

    nodeNil.setPrevious(newLast);
    newLast.setNext(nodeNil);

    if (this.head.isNIL()) {
      head = newLast;
    }
    this.last.setNext(newLast);
    this.last = newLast;
  }

  public DoubleLinkedListNode<T> getLast() {
    return last;
  }

  public void setLast(DoubleLinkedListNode<T> last) {
    this.last = last;
  }

}
