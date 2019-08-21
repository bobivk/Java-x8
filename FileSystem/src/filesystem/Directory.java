package filesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Directory extends File{

	private int size = 0;
	private HashMap<String, File> content = new HashMap<String, File>();
//	private Map<String, Directory> directoryContents = new HashMap<String, Directory>();
	
	public Directory(String name, String path) {
		super(name, path);
	}

	@Override
	public ArrayList<String> getTextContent() {
		System.out.println("tried to get text content of directory");
		return null;
	}



	public void addFile(File file) {
		this.content.put(file.getName(), file);
		this.size++;
	}
	public void removeFile(File file) {
		this.content.remove(file.getName());
		this.size--;
	}

// Getters and setters
	@Override
	public HashMap<String, File> getFileContent() {
		return this.content;
	}

	public void setFileContent(HashMap<String, File> newContent){
		this.content = newContent;
		this.size = newContent.size();
	}

	public int getSize() {
		return size;
	}
}