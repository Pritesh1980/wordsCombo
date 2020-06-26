package cloud.mistry.combo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Api(value="Words Combo App", description="Generates word and number combinations following a set pattern.")
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
            return "Combo Analysis ready to rock and roll - 2020!";
        }
    }

    @GetMapping("/combo/words")
    String GetWord()
    {
        return "At /combo/words";
    }


    @ApiOperation(value = "Takes in a 6 character word and returns the numerical pattern for it.", response = String.class)
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
    String GetNumber()
    {
        return "At /combo/numbers";
    }

    @ApiOperation(value = "Converts a 6 digit number into potential real words that could be generated from them.", response = String.class)
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