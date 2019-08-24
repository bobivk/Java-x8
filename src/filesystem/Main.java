package filesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Directory initialDirectory = new Directory("C:", "");
        Terminal terminal = new Terminal(scanner, initialDirectory);

        //TODO: try to store the methods in a HashMap (Lambda expressions):
//        HashMap<String, Runnable> commands = new HashMap<String, Runnable>();
//        commands.put("ls", () -> terminal.ls());


        while(true){
            System.out.println(terminal.getCurrentDirectory().getPathToDirectory());
            String nextln = scanner.nextLine();
            String[] inputarr = nextln.split(" ");
            ArrayList<String> inputs = new ArrayList<>(Arrays.asList(inputarr));
            String help = "\n ls \n cd \n pwd \n mkdir \n mv \n rm \n rename \n cp \n cat \n vim \n ";    
            switch (inputs.get(0)) {
                	case "ls":
                		terminal.ls();
                		break;
                	case "help": System.out.println(help); break;
                    case "cd":
                        if (inputs.get(1).equals("..")) {
                            terminal.cd(terminal.getCurrentDirectory().getParent());
                        } else {
                            terminal.cd((Directory) terminal.getCurrentDirectory().getFileContent().get(inputs.get(1)));
                        }
                    break;
                    case "touch":
                        terminal.touch(inputs.get(1));break;
                    case "mkdir":
                        terminal.mkdir(inputs.get(1));break;
                    case "mv":
                        terminal.mv(terminal.getCurrentDirectory().getFileContent().get(inputs.get(1)),
                                (Directory) terminal.getCurrentDirectory().getFileContent().get(inputs.get(2)));
                        break;
                    case "rm":
                        terminal.rm(terminal.getCurrentDirectory().getFileContent().get(inputs.get(1)));
                        break;
                    case "rename":
                        terminal.rename(terminal.getCurrentDirectory().getFileContent().get(inputs.get(1)), inputs.get(2));
                        break;
                    case "pwd":
                        terminal.pwd();
                        break;
                    case "cat":
                        terminal.cat((TextFile) terminal.getCurrentDirectory().getFileContent().get(inputs.get(1)));
                        break;
                    case "vim":
                        terminal.vim((TextFile) terminal.getCurrentDirectory().getFileContent().get(inputs.get(1)));
                        break;
                    case "cp": {
                        // check if both files exist
                        if (terminal.getCurrentDirectory().getFileContent().containsKey(inputs.get(1)) &&
                                terminal.getCurrentDirectory().getFileContent().containsKey(inputs.get(2))) {
                            terminal.cp(terminal.getCurrentDirectory().getFileContent().get(inputs.get(1)),
                                    terminal.getCurrentDirectory().getFileContent().get(inputs.get(2)));
                        } else {
                            // create a new textfile and copy the text into it
                            terminal.cp((TextFile) terminal.getCurrentDirectory().getFileContent().get(inputs.get(1)), inputs.get(2));
                        }
                        break;
                    }
                    case "locate":
                        terminal.locate(inputs.get(1), terminal.getCurrentDirectory());
                        break;
                    case "quit":System.exit(0); break;
                    default:
                        System.out.println("Command is not valid, try: " + help);
                        break;
                }
            }
       }

}

