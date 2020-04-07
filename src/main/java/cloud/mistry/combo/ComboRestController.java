package cloud.mistry.combo;

import org.springframework.web.bind.annotation.*;



@RestController
class ComboRestController
{
    private static final Combo myCombo = new Combo();

    @GetMapping("/combo")
    public String check()
    {
        if( myCombo==null )
        {
            return "Combo Analysis not initialised. Sorry.";
        }
        else
        {
            return "Combo Analysis ready to rock and roll!";
        }
    }

    @GetMapping("/combo/words")
    String GetWord()
    {
        return "At /combo/words";
    }

    @GetMapping("/combo/words/{word}")
    String GetWord(@PathVariable String word)
    {
        try
        {
            String retString = myCombo.lookupWord(word).toString();
            return retString;
        }
        catch ( IllegalArgumentException ex )
        {
            return ex.getMessage();
        }
    }

    @GetMapping("/combo/numbers")
    String GetWNumber()
    {
        return "At /combo/numbers";
    }

    @GetMapping("/combo/numbers/{number}")
    String GetNumber(@PathVariable String number)
    {
        try
        {
            String retString = myCombo.lookupNumber(number).toString();
            return retString;
        }
        catch ( IllegalArgumentException ex )
        {
            return ex.getMessage();
        }
    }
}