package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

  protected SingleLinkedListNode<T> head;

  public SingleLinkedListImpl() {
    this.head = new SingleLinkedListNode<T>();
  }

  @Override
  public boolean isEmpty() {
    return this.head.isNIL();
  }

  @Override
  public int size() {
    SingleLinkedListNode<T> aux = this.head;
    int size = 0;
    while (!aux.isNIL()) {
      size++;
      aux = aux.getNext();
    }

    return size;
  }

  @Override
  public T search(T element) {
    SingleLinkedListNode<T> aux = this.head;
    while (!aux.isNIL() && !aux.getData().equals(element)) {
      aux = aux.getNext();
    }
    return aux.getData();
  }

  @Override
  public void insert(T element) {
    SingleLinkedListNode<T> aux = this.head;

    if (this.head.isNIL()) {
      SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element, head);
      this.head = newHead;
    } else {
      while (!aux.isNIL()) {
        aux = aux.getNext();
      }
      aux.setData(element);
      aux.setNext(new SingleLinkedListNode<>());
    }
  }

  @Override
  public void remove(T element) {
    if (this.head.data.equals(element)) {
      this.head = this.head.getNext();
    } else {
      SingleLinkedListNode<T> aux = this.head;
      while (!aux.isNIL() && !aux.getData().equals(element)) {
        aux = aux.getNext();
      }

      if (!aux.isNIL()) {
        aux.setData(aux.getNext().getData());
        aux.setNext(aux.getNext().getNext());
      }
    }
  }

  @Override
  public T[] toArray() {
    int size = this.size();
    T[] array = (T[]) new Object[size];

    SingleLinkedListNode<T> aux = this.head;

    for (int i = 0; i < size; i++) {
      array[i] = aux.getData();
      aux = aux.getNext();
    }

    return array;
  }

  public SingleLinkedListNode<T> getHead() {
    return head;
  }

  public void setHead(SingleLinkedListNode<T> head) {
    this.head = head;
  }

}
