package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

  public FloorCeilHeapImpl(Comparator<Integer> comparator) {
    super(comparator);
  }

  @Override
  public Integer floor(Integer[] array, double numero) {

    for (Integer e : array) {
      if (e <= numero) {
        this.insert(e);
      }
    }

    Integer result = extractRootElement();

    while (rootElement() != null && rootElement() >= result) {
      result = extractRootElement();
    }

    return result;
  }

  @Override
  public Integer ceil(Integer[] array, double numero) {
    for (Integer e : array) {
      if (e >= numero) {
        this.insert(e);
      }
    }

    Integer result = extractRootElement();

    while (rootElement() != null && rootElement() <= result) {
      result = extractRootElement();
    }

    return result;
  }
}
