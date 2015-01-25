import java.util.LinkedList;
/** 
 * Implementation of the EC Hash String set
 * @author Antonio Contreras
 */


public class ECHashStringSet implements StringSet {
	/** */

	private double _loadFactor;
	private int size;
	private LinkedList[] arrayTable;
	private int counter = 0;

	/** This loadfactor already has a set loadfactor. */
	public ECHashStringSet() {
		_loadFactor = 5;
		size = 22;
		arrayTable = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			arrayTable[i] = new LinkedList<String>();
		}
	}

	/* The load factor would be whatever you want it to. */
	public ECHashStringSet(int loadfactor) {
		_loadFactor = loadfactor;
		size = 22;
		arrayTable = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			arrayTable[i] = new LinkedList<String>();
		}
	}


	/** Will first find the hashcode of things
	 *  Then the adress will be found.
	 *  Then we check of the linked list contains.
	 */
	public boolean contains(String s) {
		int hashNumber = s.hashCode();
		LinkedList<String> bucketList = (LinkedList<String>)arrayTable[hashNumber % arrayTable.length];
		for (String str : bucketList) {
			if (str.equals(s)) {
				return true;
			}
			return false;
		}
		return false;
	}

	public void put(String s) {
		resize();
		int hashNumber = s.hashCode();
		int address = hashNumber & 0x7fffffff;
		if (!arrayTable[address % arrayTable.length].contains(s)) {
			arrayTable[address % arrayTable.length].add(s);
			counter += 1;
		}
	}

	private void resize() {
		if (counter / size > _loadFactor) {
			size *= 2;
			LinkedList<String>[] arrayNewTable = (LinkedList<String>[])new LinkedList[size];
			counter = 0;

			for (int i = 0; i < size; i ++) {
				arrayNewTable[i] = new LinkedList<String>();
			}
			for (LinkedList<String> list : arrayTable) {
				for (String string : list) {
					int hashnumber = string.hashCode() & 0x7fffffff;
					arrayNewTable[hashnumber % arrayNewTable.length].add(string);
				}
			}
			arrayTable = arrayNewTable;
		}
	}

	/** Returns count. */
	public int getCount() {
		return counter;
	}
}