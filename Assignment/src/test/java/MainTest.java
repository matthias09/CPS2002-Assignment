import um.cps2002.Main;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    Main main;

    @Test
    public void testClass(){
        main = new Main();

        String msg = main.getString();

        assertEquals("Hello",msg);

    }

}
