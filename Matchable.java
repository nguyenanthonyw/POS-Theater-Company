
public interface Matchable<K> {

    /**
     * Checks whether an ticket's key matches the given key.
     * 
     * @param key the key value
     * @return true iff the item's key matches the given key
     */
    public boolean matches(K key);

}
