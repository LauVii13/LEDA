import java.util.*;

public class Main {
  public static void main(String[] args) {
    RotateLinkedListImpl<Integer> list = new RotateLinkedListImpl<>();

    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);

    System.out.println(Arrays.toString(list.toArray()));
    list.rotate(2);
    System.out.println(Arrays.toString(list.toArray()));
  }
}
