import java.lang.Math;

public class StringSet {

  StringNode [] table;	// Hash table - collisions resolved through chaining.
  int numelements;	// Number of elements actually stored in the structure.
  int size;					// Allocated memory (size of the hash table).

  public StringSet() {
    numelements = 0;
    size = 100;
    table = new StringNode[size];
  }

  public void insert(String key) {
      if (numelements == size) {}
      int index = hash(key);
      table[index] = new StringNode(key, table[index]);
  }

  public boolean find(String key) {
      int i = hash(key);
      for (StringNode curr = table[i]; curr != null; curr = curr.getNext()) {
          if (key.equals(curr.getKey())) {
              return true;
          }
      } return false;
  }

  public void print() {
      StringNode t;
      for (StringNode k : table) {
          t = k;
          do {
              System.out.println(t.getKey());
              t = t.getNext();
          } while (t.getNext() != null);
      }
  }

  /*
   * hash function returns the index into the hash table for a string k.
   */
  public int hash(String k) {
      int h = 0;
      for (int i = 0; i < k.length(); i++) {
          h = (33 * h + k.charAt(i));
      }
      return (Math.abs(h) % size);
  }

}
