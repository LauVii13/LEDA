public class RecursiveLinkedListImpl<T> implements LinkedList<T> {
  protected T data;
  protected RecursiveLinkedListImpl<T> next;

  @Override
  public boolean isEmpty() {
    return this.data == null;
  }

  @Override
  public int size() {
    int result = 0;

    if (!this.isEmpty())
      result = 1 + this.next.size();

    return result;
  }

  @Override
  public T search(T element) {
    T result = this.data;

    if (!this.isEmpty() && !this.data.equals(element))
      result = this.next.search(element);

    return result;
  }

  @Override
  public void insert(T element) {
    if (this.isEmpty()) {
      this.data = element;
      this.next = new RecursiveLinkedListImpl<>();
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
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public RecursiveLinkedListImpl<T> getNext() {
    return this.next;
  }

  public void setNext(RecursiveLinkedListImpl<T> next) {
    this.next = next;
  }

}
