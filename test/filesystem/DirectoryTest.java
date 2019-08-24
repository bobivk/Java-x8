package filesystem;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DirectoryTest {

    @Test
    public void testAddTextFile() {
        Directory dir = new Directory("dir", "C:");
        File tex = new TextFile("txt", dir.getPathToDirectory());
        dir.addFile(tex);
        assertEquals("C:/dir/", tex.getPath());
        assertEquals("txt", tex.getName());
        assertEquals(dir, tex.getParent());
    }

    @Test
    public void testRemoveFile() {
        Directory dir = new Directory("dir", "C:");
        File tex = new TextFile("txt", dir.getPathToDirectory());
        dir.addFile(tex);
        dir.removeFile(tex);
        assertEquals(dir.getFileContent(), new HashMap<String, File>() );
    }

    @Test
    public void testGetFileContent() {
        Directory dir = new Directory("dir", "C:");
        File tex = new TextFile("txt", dir.getPathToDirectory());
        dir.addFile(tex);
        assertEquals(tex,dir.getFileContent().get(tex.getName()));
    }

    @Test
    public void testGetPathToDirectory() {
        Directory dir = new Directory("dir", "C:");
        assertEquals("C:/dir/", dir.getPathToDirectory());
    }
}