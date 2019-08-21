package filesystem;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class File {
	private Directory parent;
	private String name;
	private String path;
	
	public File(String name, String path) {
		this.name = name;
		this.setPath(path);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Directory getParent() {
		return parent;
	}
	public void setParent(Directory parent) {
		this.parent = parent;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public abstract ArrayList<String> getTextContent();
	public abstract HashMap<String, File> getFileContent();

    public abstract void addFile(File file);
}
