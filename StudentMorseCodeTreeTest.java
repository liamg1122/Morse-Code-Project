import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StudentMorseCodeTreeTest {

    private MorseCodeTree morseCodeTree;

    @BeforeEach
    public void setUp() {
        morseCodeTree = new MorseCodeTree();
    }

    @Test
    public void testFetch() {
        assertEquals("e", morseCodeTree.fetch("."));
        assertEquals("t", morseCodeTree.fetch("-"));
        assertEquals("i", morseCodeTree.fetch(".."));
        assertEquals("m", morseCodeTree.fetch("--"));
    }
    

    @Test
    public void testUnsupportedOperationExceptionForDelete() {
        assertThrows(UnsupportedOperationException.class, () -> {
            morseCodeTree.delete("e");
        }, "Delete operation should throw an UnsupportedOperationException.");
    }

}
