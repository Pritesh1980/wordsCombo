package cloud.mistry.combo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

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

}