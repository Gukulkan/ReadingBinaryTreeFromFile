
import com.gukulkan.Tree;
import com.gukulkan.TreeFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertTrue;

public class TreeTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testInsertionRoot(){

        Tree tree = new Tree();

        tree.insert("Quick","Fox","Jumps");
        tree.insert("Brown","#","Over");
        tree.insert("A","Quick","Brown");

        assertTrue(tree.toString().contains("root=TreeNode{value=A"));
    }

    @Test
    public void testDuplicatedRoots() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("File has duplicated roots");

        String str = "Quick,Fox,Jumps\n" +
                "Brown,#,Over\n" +
                "Brown,#,Over\n" +
                "A,Quick,Brown";

        InputStream is = new ByteArrayInputStream(str.getBytes());

        TreeFactory.buildTree(new InputStreamReader(is));

    }

    @Test
    public void testIncorrectFileInput() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Incorrect input file");

        String str = "Incorrect input file\n" +
                "Brown,#,Over\n" +
                "A,Quick,Brown";

        InputStream is = new ByteArrayInputStream(str.getBytes());

        TreeFactory.buildTree(new InputStreamReader(is));

    }


    @Test
    public void testIncorrectNodesInFile() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("There incorrect nodes in file");

        String str = "incorrect,inv,cor\n" +
                "Brown,#,Over\n" +
                "A,Quick,Brown";

        InputStream is = new ByteArrayInputStream(str.getBytes());

        TreeFactory.buildTree(new InputStreamReader(is));

    }

}
