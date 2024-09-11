package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
    extends AbstractHashtableOpenAddress<T> {

  public HashtableOpenAddressQuadraticProbingImpl(int size,
      HashFunctionClosedAddressMethod method, int c1, int c2) {
    super(size);
    hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
    this.initiateInternalTable(size);
  }

  @Override
  public void insert(T element) {
    if (this.elements >= this.table.length) {
      throw new HashtableOverflowException();
    }

    if (element != null) {
      int prob = 0;
      int hashCode = 0;
      boolean canSearch = true;

      while (canSearch) {
        hashCode = getHash(element, prob++);

        if (isMaxProb(prob) || isFreeToInsert(hashCode)) {
          canSearch = false;
        } else {
          this.COLLISIONS++;
        }
      }

      if (isFreeToInsert(hashCode)) {
        this.table[hashCode] = element;
        this.elements++;
      }
    }
  }

  @Override
  public void remove(T element) {
    int index = indexOf(element);
    if (index != -1) {
      this.table[index] = new DELETED();
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

    if (element != null) {
      int prob = 0;
      int hashCode = 0;
      boolean canSearch = true;

      while (canSearch) {
        hashCode = getHash(element, prob++);
        canSearch = !isMaxProb(prob) && this.table[hashCode] != null && !element.equals(this.table[hashCode]);
      }

      if (!isFreeToInsert(hashCode) && element.equals(this.table[hashCode])) {
        result = hashCode;
      }
    }

    return result;
  }

  private int getHash(T element, int prob) {
    return ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, prob);
  }

  private boolean isMaxProb(int prob) {
    return prob >= this.table.length;
  }

  private boolean isFreeToInsert(int hashCode) {
    return this.table[hashCode] == null || this.table[hashCode].equals(this.deletedElement);
  }
}
