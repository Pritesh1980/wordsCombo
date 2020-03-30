package cloud.mistry.combo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class ComboTest
{
    private static cloud.mistry.combo.Combo combo = null;

    @BeforeAll
    public static void setup()
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
                ()-> combo.lookupWord("COWABUNGA"));
        System.out.println(exception.getMessage());
    }
}