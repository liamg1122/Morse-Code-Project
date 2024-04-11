import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StudentMorseCodeConverterTest {

    @Test
    public void testConvertToEnglishString() {
        String morseCode = "-- -.-- / -. .- -- . / .. ... / .-.. .. .- --";
        String expected = "my name is liam";
        String actual = MorseCodeConverter.convertToEnglish(morseCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testConvertToEnglishFile() throws FileNotFoundException {
        File file = new File("src/helloworld.txt");
        String expected = "hello world"; 
        String actual = MorseCodeConverter.convertToEnglish(file);
        Assertions.assertEquals(expected, actual, "The Morse code was not converted correctly.");
    }
}

