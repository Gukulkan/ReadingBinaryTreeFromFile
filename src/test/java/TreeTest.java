
import com.gukulkan.Tree;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TreeTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testInsert() {

        Tree<String> tree = new Tree<>();

        tree.insert("Quick", "Fox", "Jumps");
        tree.insert("Brown", "#", "Over");
        tree.insert("A", "Quick", "Brown");

        assertTrue(tree.toString().contains("root=TreeNode{value=A"));
    }

    @Test
    public void testGet() {

        Tree<String> tree = new Tree<>();

        tree.insert("Quick", "Fox", "Jumps");
        tree.insert("Brown", "#", "Over");
        tree.insert("A", "Quick", "Brown");

        assertEquals(tree.get("A"), "A");
        assertEquals(tree.get("Brown"), "Brown");
        assertEquals(tree.get("Fox"), "Fox");
        assertEquals(tree.get("Jumps"), "Jumps");
        assertNotEquals(tree.get("Jumps"), "jumps");
    }


}
