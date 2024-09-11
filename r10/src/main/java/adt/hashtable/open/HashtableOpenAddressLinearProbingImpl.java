package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
    AbstractHashtableOpenAddress<T> {

  public HashtableOpenAddressLinearProbingImpl(int size,
      HashFunctionClosedAddressMethod method) {
    super(size);
    hashFunction = new HashFunctionLinearProbing<T>(size, method);
    this.initiateInternalTable(size);
  }

  @Override
  public void insert(T element) throws HashtableOverflowException {
    if (this.elements >= this.table.length) {
      throw new HashtableOverflowException();
    }

    if (element != null) {
      int prob = 0;
      int hashCode = 0;
      boolean canSearch = true;

      while (canSearch) {
        hashCode = getHash(element, prob++);

        if (isFoundOrEmpty(hashCode, prob)) {
          canSearch = false;
        } else {
          this.COLLISIONS++;
        }
      }

      if (this.table[hashCode] == null || this.table[hashCode].equals(this.deletedElement)) {
        this.table[hashCode] = element;
        this.elements++;
      }
    }
  }

  @Override
  public void remove(T element) {
    int index = indexOf(element);
    if (index != -1) {
      this.table[index] = this.deletedElement;
      this.elements--;
    }
  }

  @Override
  public T search(T element) {

    T result = null;
    int index = indexOf(element);

    if (index != -1) {
      result = (T) this.table[index];
    }

    return result;
  }

  @Override
  public int indexOf(T element) {
    int result = -1;

    int prob = 0;
    int hashCode = 0;
    boolean canSearch = true;

    if (element != null) {
      int hashCode = calculaHashProbing(element);

      if (this.table[hashCode].equals(element)) {
        result = hashCode;
      }
    }

    return result;
  }

  private int calculaHashProbing(T element) {
    int prob = 0;
    int hashCode = 0;
    boolean canSearch = true;

    while (canSearch) {
      hashCode = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, prob++);
      canSearch = !isFoundOrEmpty(hashCode, prob);
    }

    return hashCode;
  }

  private int getHash(T element, int prob) {
    return ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, prob);
  }

  private boolean isFoundOrEmpty(int hashCode, int prob) {
    return prob >= this.table.length
        || this.table[hashCode] == null
        || this.table[hashCode].equals(this.deletedElement);
  }
}
