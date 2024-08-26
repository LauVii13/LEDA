package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

  private Stack<T> stack1;
  private Stack<T> stack2;

  public QueueUsingStack(int size) {
    stack1 = new StackImpl<T>(size);
    stack2 = new StackImpl<T>(size);
  }

  @Override
  public void enqueue(T element) throws QueueOverflowException {
    if (stack1.isFull()) {
      throw new QueueOverflowException();
    }

    if (element != null) {
      try {
        stack1.push(element);
      } catch (StackOverflowException e) {
        throw new QueueOverflowException();
      }
    }
  }

  @Override
  public T dequeue() throws QueueUnderflowException {
    if (stack1.isEmpty()) {
      throw new QueueUnderflowException();
    }

    T result = null;
    changingStack(stack1, stack2);

    try {
      result = stack2.pop();
    } catch (StackUnderflowException e) {
      throw new QueueUnderflowException();
    }

    changingStack(stack2, stack1);

    return result;
  }

  @Override
  public T head() {
    T result = null;

    if (!this.stack1.isEmpty()) {
      changingStack(stack1, stack2);
      result = stack2.top();
      changingStack(stack2, stack1);
    }

    return result;
  }

  @Override
  public boolean isEmpty() {
    return this.stack1.isEmpty();
  }

  @Override
  public boolean isFull() {
    return this.stack1.isFull();
  }

  private void changingStack(Stack<T> sourceStack, Stack<T> destinationStack) {
    try {
      while (!sourceStack.isEmpty()) {
        destinationStack.push(sourceStack.pop());
      }
    } catch (Exception e) {
    }
  }

}
