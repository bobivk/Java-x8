package filesystem;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class TerminalTest {

    @Test
    public void touch() {
        Scanner scanner = new Scanner(System.in);
        Terminal terminal = new Terminal(scanner, new Directory("C:", ""));
        terminal.touch("filename");
        assertEquals("filename",
                terminal.getCurrentDirectory().getFileContent().get("filename").getName()
        );
        assertEquals("C:/", terminal.getCurrentDirectory().getFileContent().get("filename").getPath());
    }


    @Test
    public void mkdir() {
    }

    @Test
    public void ls() {
    }

    @Test
    public void cd() {
    }

    @Test
    public void mv() {
    }

    @Test
    public void rm() {
    }

    @Test
    public void rename() {
    }

    @Test
    public void pwd() {
    }

    @Test
    public void cat() {
    }

    @Test
    public void vim() {
    }

    @Test
    public void cp() {
    }

    @Test
    public void testCp() {
    }

    @Test
    public void locate() {
    }
}