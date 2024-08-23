package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}

		if(element != null){
			if(head == -1){
				head = increasePointer(head);
			}

			tail = increasePointer(tail);
			array[tail] = element;
			elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}

		T result = array[head];
		head = increasePointer(head);

		elements--;

		return result;
	}

	@Override
	public T head() {
		T result = null;

		if(!isEmpty()){
			result = array[head];
		}

		return result;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

	private int increasePointer(int pointer){
		return (pointer + 1) % array.length;
	}
}