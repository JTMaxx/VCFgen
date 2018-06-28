import org.junit.gen5.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

    Reader r = new Reader();

    @Test
    public void testGetFieldContent() {
       assertTrue("\t".equals(r.contactsToParse.get(3).charAt(5)));
    }
//
//    @Test
//    public void testCharAt() {
//        assertTrue("\t".equals(Character.toString("0123\t56".charAt(4))));
//
//    }
}
