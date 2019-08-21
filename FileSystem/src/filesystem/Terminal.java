package filesystem;

import java.util.Map.Entry;
import java.util.Scanner;

public class Terminal {
	Directory currentDirectory;
	private String path;
	Scanner scanner;


	public Terminal(Scanner scanner) {
		this.path = "C:/";
		this.scanner = scanner;
	}
	//touch works for text files only!!
	public void touch(String fileName) {
		// put file in dir hashmap
		currentDirectory.getFileContent().put(currentDirectory.getName()
													, new TextFile(fileName, this.getPath()));
		// set file parent to current dir
		currentDirectory.getFileContent().get(fileName).setParent(currentDirectory);
	}

	
	public void mkdir(String directoryName) {
		// add to dir hashmap
		currentDirectory.getFileContent().
			put(currentDirectory.getName(), new Directory(directoryName, this.getPath()));
		// set new dir's parent to current directory
		currentDirectory.getFileContent().get(currentDirectory.getName()).
			setParent(currentDirectory);
		
	}
	public void ls() {
		//list files from current directory
		System.out.println(currentDirectory.getSize());
		for(String i: currentDirectory.getFileContent().keySet()) {
			System.out.println(currentDirectory.getFileContent().get(i));
		}
	}
	public void cd(Directory destinationDir) {
	    //change dir
		this.currentDirectory = destinationDir;
		//update path
		path += destinationDir.getName();
		
	}
	public void mv(File currentFile, Directory destinationDir) {
	    //update parent
		currentFile.setParent(destinationDir);
		//add file to dir's hashmap
		destinationDir.addFile(currentFile);
	}
	public void rm(File currentFile) {
		currentDirectory.removeFile(currentFile);
	}
	public void rename(File currentFile, String newName) {
		currentFile.setName(newName);
	}
	public void pwd() {
		System.out.println(getPath());
	}
	public void cat(filesystem.TextFile file) {
		//print out the content of a text file
		for(int i = 0; i < file.getTextContent().size(); i++) {
			System.out.print(file.getTextContent().get(i));
		}
	}
	public void vim(filesystem.TextFile file) {
		file.vim(scanner);
	}

	//copy and paste file
	public void cp(File file, File destination) {
		// copy text file into directory
		if (file instanceof TextFile && destination instanceof Directory){
			// create new file
			TextFile copiedFile = new TextFile(file.getName(), file.getPath());
			//add in destination directory
			copiedFile.setParent((Directory) destination);
			copiedFile.setTextContent(file.getTextContent());
			destination.addFile(copiedFile);
		}
		// copy directory into directory
		else if(file instanceof Directory && destination instanceof Directory){
			//create new directory
			Directory copiedDir = new Directory(file.getName(), file.getPath());
			//add in destination directory
			copiedDir.setParent((Directory) destination);
			copiedDir.setFileContent(file.getFileContent());
			destination.addFile(copiedDir);
		}
		// copy textfile into existing textfile
		else if(file instanceof TextFile && destination instanceof TextFile){
			((TextFile) destination).addTextContent(file.getTextContent());
		}
		else {
			System.out.println("The file is not a Directory or TextFile");
		}
	}
	//copy text from one file into a new file
	public void cp(TextFile file1, String file2Name){
		TextFile file2 = new TextFile(file2Name, file1.getPath());
		file2.setTextContent(file1.getTextContent());
	}
	
	public void locate(File file) {
		//check if file is in current dir
		if(currentDirectory.getFileContent().containsKey(file.getName())) {
			currentDirectory.getFileContent().get(file.getName());
		} else {
			//loop through inner directories
			//for(Entry<String, File> entry : currentDirectory.getFileContent().entrySet()) {
				// TODO: iterate through hashmap to locate file
			//}
		}
	}

	public String getPath() {
		return path;
	}
}