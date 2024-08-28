package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if(this.isEmpty()){
			this.data = element;
			this.next = new RecursiveDoubleLinkedListImpl<>();
			this.previous = new RecursiveDoubleLinkedListImpl<>();

			((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(this);
			this.previous.setNext(this);
		}else{
			RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<>();
			aux.setData(this.data);
			aux.setPrevious(this);
			aux.setNext(this.next);
			
			((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(aux);
			
			this.data = element;
			this.next = aux;
		}
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
