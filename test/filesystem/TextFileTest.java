package filesystem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TextFileTest {

    @Test
    public void testVimWithOneLineString() {
        Scanner scanner = new Scanner("one line \n :wq");
        TextFile file = new TextFile("test","C:/");
        file.vim(scanner);
    }

    @Test
    public void testGetTextContent_and_addTextContent() {
        TextFile file = new TextFile("test","C:/");
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("alo");
        file.addTextContent(arr);
        assertEquals(arr, file.getTextContent());
    }
}