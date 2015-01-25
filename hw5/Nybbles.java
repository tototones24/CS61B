/** Represents an array of integers each in the range -8..7.
 *  Such integers may be represented in 4 bits (called nybbles).
 *  @author Antonio Conteras
 */
public class Nybbles {
    /** Return an array of size N. */
    public Nybbles(int N) {
        // DON'T CHANGE THIS.
        _data = new int[(N + 7) / 8];
        _n = N;
    }

    /** Return the size of THIS. */
    public int size() {
        return _n;
    }

    /** Return the Kth integer in THIS array, numbering from 0.
     *  Assumes 0 <= K < N. */
    public int get(int k) {
        if (k < 0 || k >= _n) {
            throw new IndexOutOfBoundsException();
        } else {
            int position = k/8;
            int number = _data[position];
            int c = 0;

            if (sign > 0 && c == 0) {
                c = -8;;
            } else if (sign > 0) {
                c ^= 1 << 0;
                c ^= 1 << 1;
                c ^= 1 << 2;
                c = (-1) * (c + 1);
            }
            return c;
        }
    }

    /** Set the Kth integer in THIS array to VAL.  Assumes
     *  0 <= K < N and -8 <= VAL < 8. */
    public void set(int k, int val) {
        if (k < 0 || k >= _n) {
            throw new IndexOutOfBoundsException();
        } else if (val < -8 || val >= 8) {
            throw new IllegalArgumentException();
        } else {
            int index = k / 8
            int c =_data[index];
            int inta = 0;
            int intb = 0;
            int intc = 0;
            int intd = 0

            if (val == -8) {
                inta  = 0;
                intb  = 0;
                intc  = 0;
            } else if (val < 0) {
                intd = (1 << (3 + 4 * (k % 8)));
        }
    }

    // DON'T CHANGE OR ADD TO THESE.
    /** Size of current array (in nybbles). */
    private int _n;
    /** The array data, packed 8 nybbles to an int. */
    private int[] _data;
}
