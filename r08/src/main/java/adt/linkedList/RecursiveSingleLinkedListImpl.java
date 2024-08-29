package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

  protected T data;
  protected RecursiveSingleLinkedListImpl<T> next;

  public RecursiveSingleLinkedListImpl() {

  }

  @Override
  public boolean isEmpty() {
    return this.data == null;
  }

  @Override
  public int size() {
    int count = 0;

    if (!this.isEmpty()) {
      count = 1 + this.next.size();
    }

    return count;
  }

  @Override
  public T search(T element) {
    T result = this.data;

    if (!this.isEmpty() && !this.data.equals(element)) {
      result = this.next.search(element);
    }

    return result;
  }

  @Override
  public void insert(T element) {
    if (this.isEmpty()) {
      this.data = element;
      this.next = new RecursiveSingleLinkedListImpl<>();
    } else {
      this.next.insert(element);
    }
  }

  @Override
  public void remove(T element) {
    if (!this.isEmpty()) {
      if (this.data.equals(element)) {
        this.data = this.next.getData();
        this.next = this.next.getNext();
      } else {
        this.next.remove(element);
      }
    }
  }

  @Override
  public T[] toArray() {
    int size = this.size();
    T[] array = (T[]) new Object[size];

    if (!this.isEmpty()) {
      array[0] = this.data;
      T[] proximos = this.next.toArray();

      for (int i = 1; i < size; i++) {
        array[i] = proximos[i - 1];
      }
    }

    return array;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public RecursiveSingleLinkedListImpl<T> getNext() {
    return next;
  }

  public void setNext(RecursiveSingleLinkedListImpl<T> next) {
    this.next = next;
  }
}
