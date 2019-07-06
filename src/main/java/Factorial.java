import java.util.function.IntToLongFunction;
import trampoline.Trampoline;

/**
 * Created by mtumilowicz on 2018-11-25.
 */
public class Factorial implements IntToLongFunction {

    @Override
    public long applyAsLong(int value) {
        return factorial(value, 1).invoke();
    }
    
    public Trampoline<Long> factorial(int n, long acc) {
        return n == 1 ? Trampoline.completed(acc) : () -> factorial(n - 1, acc * n);
    }
}
