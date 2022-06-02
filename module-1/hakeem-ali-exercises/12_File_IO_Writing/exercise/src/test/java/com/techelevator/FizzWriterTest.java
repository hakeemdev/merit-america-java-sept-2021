package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FizzWriterTest {

    private final String DEST_FILE_PATH = "src/test/resources/fizzbuzz.txt";

    private File destFile = new File(DEST_FILE_PATH);

    @Before
    public void setUp() throws Exception {
        if(destFile.exists()) {
            destFile.delete();
        }
        System.setIn(new ByteArrayInputStream(DEST_FILE_PATH.getBytes()));
    }

    /**
     * The destination file should have a total of 300 lines
     * @throws IOException
     */
    @Test
    public void destinationFile_shouldHaveThreeHundredLines() throws IOException {
        FizzWriter.main(null);

        // read destination file
        int numberOfLines = 0;
        if(destFile.exists()) {
            numberOfLines = Files.readAllLines(destFile.toPath()).size();
        }

        Assert.assertEquals(300,numberOfLines);
    }

    /**
     * Supply the destination file and let the program execute. The output should equal the expected output.
     * @throws IOException
     */
    @Test
    public void writeFizzBuzz_DestinationFileShouldEqualExpectedOutput() throws IOException {
        FizzWriter.main(null);

        // read destination file
        String destContent = "";
        if(destFile.exists()) {
            destContent = Files.readString(destFile.toPath());
        }

        // expected
        // File expectedFile = new File("src/test/resources/fizzbuzz-expected.txt");
        //String expected = Files.readString(expectedFile.toPath());

        Assert.assertEquals(fizzBuzzExpected(), destContent.trim());
    }

    private String fizzBuzzExpected() {
        return "1" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "4" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "7" + System.lineSeparator() +
                "8" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "11" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "14" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "16" + System.lineSeparator() +
                "17" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "19" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "22" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "26" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "28" + System.lineSeparator() +
                "29" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "41" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "44" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "46" + System.lineSeparator() +
                "47" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "49" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "61" + System.lineSeparator() +
                "62" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "64" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "67" + System.lineSeparator() +
                "68" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "71" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "74" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "76" + System.lineSeparator() +
                "77" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "79" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "82" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "86" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "88" + System.lineSeparator() +
                "89" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "91" + System.lineSeparator() +
                "92" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "94" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "97" + System.lineSeparator() +
                "98" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "101" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "104" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "106" + System.lineSeparator() +
                "107" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "109" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "112" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "116" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "118" + System.lineSeparator() +
                "119" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "121" + System.lineSeparator() +
                "122" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "124" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "127" + System.lineSeparator() +
                "128" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "142" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "146" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "148" + System.lineSeparator() +
                "149" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "161" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "164" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "166" + System.lineSeparator() +
                "167" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "169" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "172" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "176" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "178" + System.lineSeparator() +
                "179" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "181" + System.lineSeparator() +
                "182" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "184" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "187" + System.lineSeparator() +
                "188" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "191" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "194" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "196" + System.lineSeparator() +
                "197" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "199" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "202" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "206" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "208" + System.lineSeparator() +
                "209" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "211" + System.lineSeparator() +
                "212" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "214" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "217" + System.lineSeparator() +
                "218" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "221" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "224" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "226" + System.lineSeparator() +
                "227" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "229" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "241" + System.lineSeparator() +
                "242" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "244" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "247" + System.lineSeparator() +
                "248" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "262" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "266" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "268" + System.lineSeparator() +
                "269" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "271" + System.lineSeparator() +
                "272" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "274" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "277" + System.lineSeparator() +
                "278" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "281" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "284" + System.lineSeparator() +
                "FizzBuzz" + System.lineSeparator() +
                "286" + System.lineSeparator() +
                "287" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "289" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "292" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "Buzz" + System.lineSeparator() +
                "296" + System.lineSeparator() +
                "Fizz" + System.lineSeparator() +
                "298" + System.lineSeparator() +
                "299" + System.lineSeparator() +
                "FizzBuzz";
    }
}
