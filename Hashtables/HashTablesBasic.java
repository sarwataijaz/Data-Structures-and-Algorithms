interface Map {
    public int size();
    public Object get(Object key);
    public Object put(Object key, Object value);

    public Object remove(Object key);
}
// linear probing technique where we are going to store pairs in different blocks
public class HashTables<K,V> implements Map {
     private int size=0;
    private Entry<K, V>[] entries = new Entry[11]; // for suppOse
     private Entry NIL = new Entry(null,null); // dummy object to store at the used places

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(Object key) {
        return (V) entries[hash(key)].value;
    }

    @Override
    public Object put(Object key, Object value) {
        int generatedIndex = hash(key);
        for(int i=0; i<entries.length; i++) {
            int j = generatedIndex + i % entries.length;
            if(entries[j] == null || entries[j] == NIL) {
                entries[j] = new Entry(key,value);
                ++size;
                return null;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Table is phul");
    }

    private int hash(Object key) {
        return (key.hashCode() & 0x7FFFFFFF) % entries.length; // Assuming 11 as the size
    }
    @Override
    public V remove(Object key) {
        int generatedIndex = hash(key);
        for(int i=0; i<entries.length; i++) {
            int j = generatedIndex + i % entries.length;
            if(entries[j].key.equals(key)) {
                Object previousValue = entries[j].value;
                entries[j] = NIL;
                --size;
                return (V) previousValue;
            }
        }
        throw new ArrayIndexOutOfBoundsException("No such element exist");
    }

    private class Entry<K,V> {
        Object key, value;

        private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
