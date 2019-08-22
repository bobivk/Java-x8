package filesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Directory directory = new Directory("C:/Files", "C:/");
        Terminal terminal = new Terminal(scanner, directory);

        //TODO: try to store the methods in a HashMap (Lambda expressions):
//        HashMap<String, Runnable> commands = new HashMap<String, Runnable>();
//        commands.put("ls", () -> terminal.ls());


        while(!scanner.nextLine().equals("end")){
            System.out.println(terminal.getPath());
            String nextln = scanner.nextLine();
            String[] inputarr = nextln.split(" ");
            ArrayList<String> inputs = new ArrayList<>(Arrays.asList(inputarr));
            inputs.add("");
            inputs.add("");
            String help = "\n ls \n cd \n pwd \n mkdir \n mv \n rm \n rename \n cp \n cat \n vim \n ";
            if(inputs.size() == 1){
                if(inputs.get(0).equals("ls")) terminal.ls();
                if(inputs.get(0).equals("help"))System.out.println(help);
            } else {
                switch (inputs.get(0)) {
                    case "cd":
                        if (inputs.get(1).equals("..")) {
                            terminal.cd(terminal.currentDirectory.getParent());
                        } else {
                            terminal.cd((Directory) terminal.currentDirectory.getFileContent().get(inputs.get(1)));
                        }
                    case "touch":
                        terminal.touch(inputs.get(1));
                    case "mkdir":
                        terminal.mkdir(inputs.get(1));
                    case "mv":
                        terminal.mv(terminal.currentDirectory.getFileContent().get(inputs.get(1)),
                                (Directory) terminal.currentDirectory.getFileContent().get(inputs.get(2)));
                    case "rm":
                        terminal.rm(terminal.currentDirectory.getFileContent().get(inputs.get(1)));
                    case "rename":
                        terminal.rename(terminal.currentDirectory.getFileContent().get(inputs.get(1)), inputs.get(2));
                    case "pwd":
                        terminal.pwd();
                    case "cat":
                        terminal.cat((TextFile) terminal.currentDirectory.getFileContent().get(inputs.get(1)));
                    case "vim":
                        terminal.vim((TextFile) terminal.currentDirectory.getFileContent().get(inputs.get(1)));
                    case "cp": {
                        // check if both files exist
                        if (terminal.currentDirectory.getFileContent().containsKey(inputs.get(1)) &&
                                terminal.currentDirectory.getFileContent().containsKey(inputs.get(2))) {
                            terminal.cp(terminal.currentDirectory.getFileContent().get(inputs.get(1)),
                                    terminal.currentDirectory.getFileContent().get(inputs.get(2)));
                        } else {
                            // use the overloaded function to create a new textfile and copy the text into it
                            terminal.cp((TextFile) terminal.currentDirectory.getFileContent().get(inputs.get(1)), inputs.get(2));
                        }
                    }
                    case "locate":
                        terminal.locate(terminal.currentDirectory.getFileContent().get(inputs.get(1)));
                    default:
                        System.out.println("Command is not valid, try: \n" + help);
                }
            }
        }
       // System.exit(0);
    }
}
