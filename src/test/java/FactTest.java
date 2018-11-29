import org.junit.Test;
import trampoline.Trampoline2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by mtumilowicz on 2018-11-25.
 */
public class FactTest {

    @Test
    public void xxx() {
        Fact fact = new Fact();

        Long apply = fact.apply(50);

        assertThat(apply, is(120L));
    }

    @Test
    public void xxx2() {
        Long apply = Fact2.fact(1_000_000, 1);

        assertThat(apply, is(1307674368000L));
    }

    @Test
    public void xxx3() {
        Integer result = chuj(1_000_000, 1).result();

        assertThat(result, is(1307674368000L));
    }

    public Trampoline2<Integer> chuj(int n, int acc) {
        return n == 1 ? Trampoline2.done(acc) : Trampoline2.more(() -> chuj(n - 1, n * acc));
    }
}