import java.lang.StringBuilder;
/**
 * This is a string set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that insert a new 
 * String, finds a String key and prints the contents of the data structure resp.
 */
public class StringSet {

    StringNode [] table;	// Hash table - collisions resolved through chaining.
    int numelements;	// Number of elements actually stored in the structure.
    int size;					// Allocated memory (size of the hash table).

    /** 
     * Constructur: initilaizes numelements, size and initial table size.
     */
    public StringSet() {
    	numelements = 0;
    	size = 100;
    	table = new StringNode[size];
    }

    /*
     * inserts a new key into the set. Inserts it at the head of the linked list given by its hash value.
     */
    public void insert(String key) {
    	int index = hash(key);
    	if (numelements == size) {
	        //TODO: need to expand the hash table and rehash its contents.
	    }
	    //TODO: Code for actual insert.
        if (table[index] == null) {
            table[hash(key)] = new StringNode(key, null);
        } else {
            StringNode temp = table[hash(key)]; 
            while ((temp = temp.getNext()) != null) {}
        }
    }

    /*
     * finds if a String key is present in the data structure. Returns true if found, else false.
     */
    public boolean find(String key) {
	    StringNode temp;
    	if ((temp = table[hash(key)]) != null) {
            System.out.println();
            String t = temp.getKey();
            while (t != key && temp.getNext() != null) {
                System.out.println(t);
                temp = temp.getNext();
            }
            if (temp.getKey() == null) { return false; }
            return true;
    	}return false;
    }

    /*
     * Prints the contents of the hash table.
     */
    public void print() {        
        for (StringNode temp : table) {
            for (; temp.getKey() != null; temp=temp.getNext())
                System.out.println(temp.getKey());
        }
    }

    /*
     * The hash function that returns the index into the hash table for a string k.
     */
    private int hash(String k) {
        int h = 0;    
        for (int i = 0; i < k.length(); i++) {
            h += (Math.pow(17.0, (double)(k.length()-i)) * ((int)k.charAt(i)));
        }    
        return h % size;
    }
}
