package filesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TextFile extends File {
	private ArrayList<String> textContent;
	public TextFile(String name, String path) {
		super(name, path);
		textContent = new ArrayList<String>();
		this.setTextContent(textContent);
	}

	public void vim(Scanner in) {
		while(!in.nextLine().equals(":wq")) {
			textContent.add(in.nextLine());
		}
	}
	public ArrayList<String> getTextContent() {
		return textContent;
	}
	public HashMap<String, File> getFileContent(){
		return null;
	};
	public void setTextContent(ArrayList<String> textContent) {
		this.textContent = textContent;
	}
	public void addTextContent(ArrayList<String> newContent){
	    for(int i = 0; i < newContent.size(); i++){
	        textContent.add(newContent.get(i));
        }
	}
	public void addFile(File file){
	    System.out.println("This file is not a directory");
    }
}
