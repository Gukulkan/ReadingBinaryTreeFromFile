
import com.gukulkan.StreamTreeFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamTreeFactoryTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testDuplicatedRoots() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("File has duplicated roots");

        String str = "Quick,Fox,Jumps\n" +
                "Brown,#,Over\n" +
                "Brown,#,Over\n" +
                "A,Quick,Brown";

        InputStream is = new ByteArrayInputStream(str.getBytes());

        StreamTreeFactory.buildTree(new InputStreamReader(is));

    }

    @Test
    public void testIncorrectFileInput() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Incorrect input file");

        String str = "Incorrect input file\n" +
                "Brown,#,Over\n" +
                "A,Quick,Brown";

        InputStream is = new ByteArrayInputStream(str.getBytes());

        StreamTreeFactory.buildTree(new InputStreamReader(is));

    }


    @Test
    public void testIncorrectNodesInFile() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("There incorrect nodes");

        String str = "incorrect,inv,cor\n" +
                "Brown,#,Over\n" +
                "A,Quick,Brown";

        InputStream is = new ByteArrayInputStream(str.getBytes());

        StreamTreeFactory.buildTree(new InputStreamReader(is));

    }

}
