/** An alternative addition procedure based on bit operations.
 *  without using the operators +, -, /, *, or \%, ++, --, +=, -=, *=, \=,
 *  %=, or any method calls. Instead, use the bitwise operators &, |, ^, ~,
 *  <<, >>, >>>, and &=, etc.
 *  @author Antonio Contreras
 */
public class Adder {
    /** Returns X+Y. */
    public static int add(int x, int y) {
        /* FILL IN */
        int a = x & y;
        int b = x ^ y;
        int finalResult = b;
        for (int i = 0; i < 32; i += 1) {
            /* FILL IN */
            a = a << 1;
            b = b & a;
            b = finalResult;
        }
        /* REPLACE WITH SOMETHING THAT WORKS. */ 
        return finalResult;
    }

}
