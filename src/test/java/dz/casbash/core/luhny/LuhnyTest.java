package dz.casbash.core.luhny;

import dz.casbah.core.luhny.Luhny;
import org.fest.assertions.Assertions;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 11/7/13
 * Time: 2:44 PM
 */
public class LuhnyTest {


    @Test
    public void luhnyCheckShouldPass() {
        String s = "5678";
        Assertions.assertThat(Luhny.check(s)).isTrue();
    }
}
