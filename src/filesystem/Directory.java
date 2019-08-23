package filesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Directory extends File{


	HashMap<String, File> content = new HashMap<String, File>();
//	private Map<String, Directory> directoryContents = new HashMap<String, Directory>();
	public Directory(String name, String path) {
		super(name, path);
	}

	@Override
	public ArrayList<String> getTextContent() {
		System.out.println("Tried to get text content of directory");
		return new ArrayList<String>();
	}

	public void addFile(File file) {
		this.content.put(file.getName(), file);
		this.content.get(file.getName()).setPath(this.getPathToDirectory());
		this.content.get(file.getName()).setParent(this);
	}
	public void removeFile(File file) {
		this.content.remove(file.getName());
	}

// Getters and setters
	@Override
	public HashMap<String, File> getFileContent() {
		return this.content;
	}

	public void setFileContent(HashMap<String, File> newContent){
		this.content = newContent;
	}

	public int getSize() {
		return content.size();
	}

	//get path of files in the directory
	public String getPathToDirectory(){
		return this.getPath() + "/" + this.getName() + "/";
	}
}