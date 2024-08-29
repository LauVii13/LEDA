package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

  protected DoubleLinkedList<T> top;
  protected int size;

  public StackDoubleLinkedListImpl(int size) {
    this.size = size;
    this.top = new DoubleLinkedListImpl<T>();
  }

  @Override
  public void push(T element) throws StackOverflowException {
    if (this.isFull()) {
      throw new StackOverflowException();
    }

    this.top.insert(element);
  }

  @Override
  public T pop() throws StackUnderflowException {
    if (this.isEmpty()) {
      throw new StackUnderflowException();
    }
    T result = this.top();
    this.top.removeLast();
    return result;
  }

  @Override
  public T top() {
    T result = null;
    if (!this.isEmpty()) {
      result = ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
    }
    return result;
  }

  @Override
  public boolean isEmpty() {
    return this.top.size() == 0;
  }

  @Override
  public boolean isFull() {
    return this.top.size() == this.size;
  }

}
