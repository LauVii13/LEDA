package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

  protected DoubleLinkedList<T> list;
  protected int size;

  public QueueDoubleLinkedListImpl(int size) {
    this.size = size;
    this.list = new DoubleLinkedListImpl<T>();
  }

  @Override
  public void enqueue(T element) throws QueueOverflowException {
    if (this.isFull()) {
      throw new QueueOverflowException();
    }

    this.list.insertFirst(element);
  }

  @Override
  public T dequeue() throws QueueUnderflowException {
    if (this.isEmpty()) {
      throw new QueueUnderflowException();
    }
    T result = this.head();
    this.list.removeLast();
    return result;
  }

  @Override
  public T head() {
    T result = null;
    if (!this.isEmpty()) {
      result = ((DoubleLinkedListImpl<T>) this.list).getLast().getData();
    }
    return result;
  }

  @Override
  public boolean isEmpty() {
    return this.list.size() == 0;
  }

  @Override
  public boolean isFull() {
    return this.list.size() == this.size;
  }

}
