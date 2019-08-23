package filesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Terminal {
	Directory currentDirectory;
	Scanner scanner;
	HashMap<String, Command> commands;

	public Terminal(Scanner scanner, Directory directory) {
		this.scanner = scanner;
		this.currentDirectory = directory;
		this.currentDirectory.setParent(currentDirectory);
		this.currentDirectory.setFileContent(new HashMap<String, File>());
		this.commands = new HashMap<String, Command>();
		this.commands.put("mkdir", new Mkdir());
	}
	public void run() {
		while(true){
            System.out.println(this.currentDirectory.getPath());
            String nextln = scanner.nextLine();
            String[] inputarr = nextln.split(" ");
            ArrayList<String> inputs = new ArrayList<>(Arrays.asList(inputarr));
            String help = "\n ls \n cd \n pwd \n mkdir \n mv \n rm \n rename \n cp \n cat \n vim \n ";    
            switch (inputs.get(0)) {
                	case "ls":
                		this.ls();
                		break;
                	case "help": System.out.println(help); break;
                    case "cd":
                        if (inputs.get(1).equals("..")) {
                            this.cd(this.currentDirectory.getParent());
                        } else {
                        	System.out.println(this.currentDirectory.getFileContent().get(inputs.get(1)));
                            this.cd((Directory) this.currentDirectory.getFileContent().get(inputs.get(1)));
                        }
                    break;
                    case "touch":
                        this.touch(inputs.get(1));break;
                    case "mkdir":
                        this.mkdir(inputs.get(1));break;
                    case "mv":
                        this.mv(this.currentDirectory.getFileContent().get(inputs.get(1)),
                                (Directory) this.currentDirectory.getFileContent().get(inputs.get(2)));
                        break;
                    case "rm":
                        this.rm(this.currentDirectory.getFileContent().get(inputs.get(1)));
                        break;
                    case "rename":
                        this.rename(this.currentDirectory.getFileContent().get(inputs.get(1)), inputs.get(2));
                        break;
                    case "pwd":
                        this.pwd();
                        break;
                    case "cat":
                        this.cat((TextFile) this.currentDirectory.getFileContent().get(inputs.get(1)));
                        break;
                    case "vim":
                        this.vim((TextFile) this.currentDirectory.getFileContent().get(inputs.get(1)));
                        break;
                    case "cp": {
                        // check if both files exist
                        if (this.currentDirectory.getFileContent().containsKey(inputs.get(1)) &&
                                this.currentDirectory.getFileContent().containsKey(inputs.get(2))) {
                            this.cp(this.currentDirectory.getFileContent().get(inputs.get(1)),
                                    this.currentDirectory.getFileContent().get(inputs.get(2)));
                        } else {
                            // use the overloaded function to create a new textfile and copy the text into it
                            this.cp((TextFile) this.currentDirectory.getFileContent().get(inputs.get(1)), inputs.get(2));
                        }
                        break;
                    }
                    case "locate":
                        this.locate(inputs.get(1), this.currentDirectory);
                        break;
                    case "quit":System.exit(0); break;
                    default:
                        System.out.println("Command is not valid, try: " + help);
                        break;
                }
            }
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
			System.out.println(currentDirectory.content.get(i).getName());
		}
	}

	public void cd(Directory destinationDir) {
		if(destinationDir == null) {
			System.out.println("Directory not found");
		} else{
			//change dir
			this.currentDirectory = destinationDir;
		}

	}

	public void mv(File currentFile, Directory destinationDir) {
		destinationDir.addFile(currentFile);
		currentFile.getParent().removeFile(currentFile);
	}
	public void rm(File currentFile) {
		currentDirectory.removeFile(currentFile);
	}
	public void rename(File currentFile, String newName) {
		currentFile.setName(newName);
	}
	public void pwd() {
		System.out.println(currentDirectory.getPath());
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
		currentDirectory.addFile(file2);
	}
	
	public String locate(String fileName, Directory startingDir) {
		//check if file is in current dir
		if(startingDir.content.containsKey(fileName)) {
			return startingDir.content.get(fileName).getPath();
		} else {
			//loop through inner directories
			for(HashMap.Entry<String, File> entry : startingDir.content.entrySet()) {
				// TODO: iterate through hashmap to locate file
				if(entry.getValue() instanceof Directory) {
					locate(fileName, (Directory) entry.getValue());
				}
			}
		}
		return "";
	}


}