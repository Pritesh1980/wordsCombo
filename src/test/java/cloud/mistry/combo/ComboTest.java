package cloud.mistry.combo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collection;

import static com.google.common.primitives.Ints.asList;
import static org.junit.jupiter.api.Assertions.*;

public class ComboTest
{
    private static cloud.mistry.combo.Combo combo = null;

    @BeforeEach
    public void setup()
    {
        combo = new Combo();
    }

    @org.junit.jupiter.api.Test
    public void testLookupNullWord()
    {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()-> combo.lookupWord(null));
        System.out.println(exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    public void testLookupShortWord()
    {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()-> combo.lookupWord("BOO"));
        System.out.println(exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    public void testLookupLongWord()
    {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()-> combo.lookupWord("COWABUNGA"), "Wrong exception thrown");
        System.out.println(exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    public void testLookupValidWord01()
    {
       final String word = "AAAAAA";
       Collection<?> ret = combo.lookupWord(word);

        System.out.println(ret);
        assertEquals(6, ret.size(), "Returned number list was of incorrect length.");

        Collection<Integer> expected = asList(1, 1, 1, 1, 1, 1);
        assertEquals(expected, ret, "Returned number array not as expected.");
    }

    @org.junit.jupiter.api.Test
    public void testLookupValidWord02()
    {
        final String word = "HAMMER";
        Collection<?> ret = combo.lookupWord(word);

        System.out.println(ret);
        assertEquals(6, ret.size(), "Returned number list was of incorrect length.");

        Collection<Integer> expected = asList(8, 1, 3, 3, 5, 8);
        assertEquals(expected, ret, "Returned number array not as expected.");
    }

    @org.junit.jupiter.api.Test
    public void testLookupValidWord03()
    {
        final String word = "xxxxxx";
        Collection<?> ret = combo.lookupWord(word);

        System.out.println(ret);
        assertEquals(6, ret.size(), "Returned number list was of incorrect length.");

        Collection<Integer> expected = asList(4, 4, 4, 4, 4, 4);
        assertEquals(expected, ret, "Returned number array not as expected.");
    }

    @org.junit.jupiter.api.Test
    public void testLookupValidWord04()
    {
        final String word = "RANDOM";
        Collection<?> ret = combo.lookupWord(word);

        System.out.println(ret);
        assertEquals(6, ret.size(), "Returned number list was of incorrect length.");

        Collection<Integer> expected = asList(8, 1, 4, 4, 5, 3);
        assertEquals(expected, ret, "Returned number array not as expected.");
    }
}