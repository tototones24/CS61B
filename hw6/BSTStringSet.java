/** BSTStringSet that implements the StringSet interface using a BST as
 *  its core data structure.
 *  @author Antonio Contreras
 */

public class BSTStringSet implements Set {
	static BST put(BST T, Key key) {
		if (key = null) {
			return new BST;
		} else if (key < t.label()) {
			T.left = put(T.left, key);
		} else if (T.label() < key) {
                    T.right = insert(T.right, key);
		}
                return T;
	}

	static BST contains( BST T, Key key) {
            if (T == null) 
                return null;
            if (sk..keyequals(T.label()))
                return T;
            else if (key < T.label())
                return find(T.left, key);
            else
                return find(T.right, key)
	}
}
