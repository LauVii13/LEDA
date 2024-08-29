package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
    RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

  protected RecursiveDoubleLinkedListImpl<T> previous;

  public RecursiveDoubleLinkedListImpl() {

  }

  @Override
  public void insertFirst(T element) {
    if (this.isEmpty()) {
      this.data = element;
      RecursiveDoubleLinkedListImpl<T> proximo = new RecursiveDoubleLinkedListImpl<>();
      proximo.setPrevious(this);

      this.next = proximo;
      this.previous = new RecursiveDoubleLinkedListImpl<>();
      this.previous.setNext(this);

      // ((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(this);
    } else {
      RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<>();
      RecursiveDoubleLinkedListImpl<T> proximo = new RecursiveDoubleLinkedListImpl<>();

      aux.setData(this.data);
      aux.setPrevious(this);

      proximo.setData(this.next.getData());
      proximo.setNext(this.next.getNext());
      proximo.setPrevious(aux);

      aux.setNext(proximo);

      this.setData(element);
      this.setNext(aux);
    }
  }

  @Override
  public void removeFirst() {
    if (!this.isEmpty()) {
      if (this.next.isEmpty()) {
        this.next = null;
        this.previous = null;
        this.data = null;
      } else {
        this.data = this.next.getData();
        RecursiveDoubleLinkedListImpl<T> proximo = new RecursiveDoubleLinkedListImpl<>();
        proximo.setData(this.next.getNext().getData());
        proximo.setNext(this.next.getNext().getNext());
        proximo.setPrevious(this);
        this.next = proximo;
      }
    }
  }

  @Override
  public void removeLast() {
    if (!this.isEmpty()) {
      if (!this.next.isEmpty()) {
        RecursiveDoubleLinkedListImpl<T> proximo = new RecursiveDoubleLinkedListImpl<>();
        proximo.setData(this.next.getData());
        proximo.setPrevious(this);
        proximo.setNext(this.next.getNext());
        this.next = proximo;

        proximo.removeLast();

        // ((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
      } else {

        this.data = null;
        this.next = null;

        if (this.previous.isEmpty()) {
          this.previous = null;
        }
      }
    }
  }

  public RecursiveDoubleLinkedListImpl<T> getPrevious() {
    return previous;
  }

  public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
    this.previous = previous;
  }

  @Override
  public void insert(T element) {
    if (this.isEmpty()) {
      this.data = element;
      this.next = new RecursiveDoubleLinkedListImpl<>();
      if (this.previous == null) {
        previous = new RecursiveDoubleLinkedListImpl<>();
      }
    } else {
      this.next.insert(element);
    }
  }
}