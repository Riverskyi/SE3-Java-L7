import java.math.BigInteger;
import java.util.stream.Stream;

public class Task4 {
    public static Stream<Long> generate(long a, long c, long m) {
        if (m <= 0) {
            throw new IllegalArgumentException("m must be positive");
        }

        long seed = 1L;
        BigInteger multiplier = BigInteger.valueOf(a);
        BigInteger increment = BigInteger.valueOf(c);
        BigInteger modulus = BigInteger.valueOf(m);

        return Stream.iterate(seed, number -> {
            // BigInteger запобігає переповненню під час множення.
            BigInteger next = multiplier.multiply(BigInteger.valueOf(number));
            next = next.add(increment);
            return next.mod(modulus).longValue();
        });
    }
}
