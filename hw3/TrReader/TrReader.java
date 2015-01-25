import java.io.Reader;
import java.io.IOException;

/** Translating Reader: a stream that is a translation of an
 *  existing reader. */
public class TrReader extends Reader {
    /** A new TrReader that produces the stream of characters produced
     *  by STR, converting all characters that occur in FROM to the
     *  corresponding characters in TO.  That is, change occurrences of
     *  FROM.charAt(0) to TO.charAt(0), etc., leaving other characters
     *  unchanged.  FROM and TO must have the same length. */
    public TrReader(Reader str, String from, String to) {
        // FILL IN
        this.str = str;
        this.from = from;
        this.to = to;
    }

    // FILL IN
    // NOTE: Until you fill in the right methods, the compiler will
    //       reject this file, saying that you must declare TrReader
    //     abstract.  Don't do that; define the right methods instead!

    /** Translates a single character. */
    // public int read() throws IOException {
    //     int c = str.read();
    //     if (c == -1) {
    //         return c;
    //     } else {
    //         return translate((char) c);
    //     }
    // }

    public int read() throws IOException {
        int a = str.read();
        if (c == -1) {
            return c;
        } else {
            return translate((char) c);
        }
    }

   /** Translates a single character and stores it in an array. 
     *  @param cbuf array where the given characters will be read. */
    public int read(char[] cbuf) throws IOException {
        int a = str.read(cbuf);
        for (int b = 0; b < a; ++b) {
            cbuf[i] = translate(cbuf[i]);
        }
        return n;
        }
    }















read:str.read

for x in off:lines 
if read() ; if -1 then ..

cbuff is some chcaracter array, its a plce to store info.

off is where yo should start putting in info.


public int read(char[] cbuf, int off, int len) {
    /** info goes from the readd supplied gets translated, and stored in cbuff[off] throug
     *  
}