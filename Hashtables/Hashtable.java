// revised and final code of hastable with load factor and rehash() method
public class Hashtable implements Map {
    int used = 0, size = 0;
    int capacity = 0;
    float loadFactor;
    Entry[] entries;
    Entry NIL = new Entry(null,null);

    public Hashtable(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        entries = new Entry[capacity];
    }
    public Hashtable(int capacity) {
        this.capacity = capacity;
        entries = new Entry[capacity];
    }
    public Hashtable() {
        this.capacity = 100;
        entries = new Entry[capacity];
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(Object key) {
        int generatedIndex = hash(key);
        for(int i=0; i<entries.length; i++) {
            int j = nextProbe(generatedIndex,i);
            if(entries[j] == null) break;
            if(entries[j] == NIL) continue;
            if(entries[j].key.equals(key)) return entries[j].value;
        }
        return null;
    }

    public int nextProbe(int h, int i) {
        return (h+i) % entries.length;
    }
    @Override
    public Object put(Object key, Object value) {
        if(used > loadFactor*entries.length)
            rehash();

        int generatedIndex = hash(key);
        for(int i=0; i<entries.length; i++) {
            int j = nextProbe(generatedIndex,i);
            if(entries[j] == null) {
                entries[j] = new Entry(key,value);
                ++used;
                ++size;
                break; // create a new pair
            }
            if(entries[j] == NIL) continue; // avoid collision
            if(entries[j].key.equals(key)) {
                Object oldValue = entries[j].value;
                entries[j].value = value;
                return oldValue; // update value
            }
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        int generatedIndex = hash(key);
        for(int i=0; i<entries.length; i++) {
            int j = nextProbe(generatedIndex,i);
            if(entries[j] == null) break; // doesn't exist beyond that
            if(entries[j] == NIL) continue; // chance of existence
            if(entries[j].key.equals(key)) {
                Object oldValue = entries[j].value;
                entries[j] = NIL;
                --size;
                return oldValue; // update value
            }
        }
        return null;
    }

    private int hash(Object key) {
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    private void rehash() {
        Entry[] oldEntries = entries;
        entries = new Entry[2* oldEntries.length+1]; // adding 1 to achieve odd divisor

        for(int i=0; i< oldEntries.length; i++) {
            if(oldEntries[i] == NIL || oldEntries[i] == null) continue;
            int h = hash(oldEntries[i].key);
            for(int k = 0; k < entries.length; k++) {
                int j= nextProbe(h,k);
                if(entries[j]==null) {
                    entries[j] = oldEntries[k];
                    break;
                }
            }
        }

        used = size;
    }
    private class Entry {
        Object value, key;
        private Entry(Object k, Object v) {
            key = k;
            value = v;
        }
    }
}
