public class Association<K,V> 
{
	protected K theKey;
	protected V theValue;
	
	public Association(K key, V value) {
		theKey = key;
		theValue = value;
	}
	public V getValue() {
		return theValue;
	}

	public K getKey() {
		return theKey;
	}

	public V setValue(V value) {
		V oldValue = theValue;
		theValue = value;
		return oldValue;
	}

	public int compareTo(K key) {
		return ((String) key).toUpperCase().compareTo( ((String) theKey).toUpperCase() );
	}
}