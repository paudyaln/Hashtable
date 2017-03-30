/*
 * interface for a set
 *
 * unordered collection, no duplicates allowed
 */

public interface Set<T>
{
    /*
     * adds item to set if not already present
     *
     * returns true if item successfully added, false if not
     *
     */

    boolean add (T item);
    T remove();
	boolean remove (T item);
    T get();
    boolean contains (T item);
    int size();
    String toString();
}
