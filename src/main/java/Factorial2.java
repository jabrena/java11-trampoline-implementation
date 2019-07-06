import java.math.BigInteger;
import trampoline.Trampoline;

public class Factorial2 {

    public BigInteger apply(int value) {
        return factorial(BigInteger.valueOf(value), BigInteger.ONE).invoke();
    }
    
    public Trampoline<BigInteger> factorial(BigInteger n, BigInteger acc) {
        return n.compareTo(BigInteger.ONE) == 0 ? Trampoline.completed(acc) : () -> factorial(n.subtract(BigInteger.ONE), acc.multiply(n));
    }
}
