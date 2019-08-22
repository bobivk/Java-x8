package filesystem;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Terminal {
	Directory currentDirectory;
	private String path;
	Scanner scanner;


	public Terminal(Scanner scanner, Directory directory) {
		this.path = "C:/";
		this.scanner = scanner;
		this.currentDirectory = directory;
		this.currentDirectory.setFileContent(new HashMap<String, File>());
	}

	//create a new text file
	public void touch(String fileName) {
		currentDirectory.addFile(new TextFile(fileName, currentDirectory.getPath()));
	}

	public void mkdir(String directoryName) {
		currentDirectory.addFile(new Directory(directoryName, currentDirectory.getPathToDirectory()));
	}

	public void ls() {
		//list files from current directory
		System.out.println(currentDirectory.getSize() + " Files in folder");
		for(String i: currentDirectory.content.keySet()) {
			System.out.println(currentDirectory.content.get(i));
		}
	}

	public void cd(Directory destinationDir) {
	    //change dir
		this.currentDirectory = destinationDir;
		//update path
		this.path += destinationDir.getName();
	}

	public void mv(File currentFile, Directory destinationDir) {
		currentFile.getParent().removeFile(currentFile);
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
		// copy directory into another directory
		else if(file instanceof Directory && destination instanceof Directory){
			//create new directory
			Directory copiedDir = new Directory(file.getName(), file.getPath());
			//add in destination directory
			copiedDir.setParent((Directory) destination);
			copiedDir.setFileContent(((Directory) file).content);
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
		if(currentDirectory.content.containsKey(file.getName())) {
			currentDirectory.content.get(file.getName());
		} else {
			//loop through inner directories
			//for(Entry<String, File> entry : currentDirectory.content.entrySet()) {
				// TODO: iterate through hashmap to locate file
			//}
		}
	}

	public String getPath() {
		return this.path;
	}
}