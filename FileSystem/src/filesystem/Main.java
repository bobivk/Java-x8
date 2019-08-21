package filesystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Terminal terminal = new Terminal(scanner);

        //TODO: try to store the methods in a HashMap (Lambda expressions):
//        HashMap<String, Runnable> commands = new HashMap<String, Runnable>();
//        commands.put("ls", () -> terminal.ls());


        while(!scanner.nextLine().equals("end")){
            String nextln = scanner.nextLine();
            String[] inputs = nextln.split(" ");
            String help = "\n ls \n cd \n pwd \n mkdir \n mv \n rm \n rename \n cp \n cat \n vim \n ";
            switch(inputs[0]) {
                case "ls":
                    terminal.ls();
                case "cd":
                    if(inputs[1].equals("..")){
                        terminal.cd(terminal.currentDirectory.getParent());
                    } else {
                        terminal.cd((Directory) terminal.currentDirectory.getFileContent().get(inputs[1]));
                    }
                case "touch":
                    terminal.touch(inputs[1]);
                case "mkdir":
                    terminal.mkdir(inputs[1]);
                case "mv":
                    terminal.mv(terminal.currentDirectory.getFileContent().get(inputs[1]),
                            (Directory) terminal.currentDirectory.getFileContent().get(inputs[2]));
                case "rm":
                    terminal.rm(terminal.currentDirectory.getFileContent().get(inputs[1]));
                case "rename":
                    terminal.rename(terminal.currentDirectory.getFileContent().get(inputs[1]), inputs[2]);
                case "pwd":
                    terminal.pwd();
                case "cat":
                    terminal.cat((TextFile) terminal.currentDirectory.getFileContent().get(inputs[1]));
                case "vim":
                    terminal.vim((TextFile) terminal.currentDirectory.getFileContent().get(inputs[1]));
                case "cp": {
                    // check if both files exist
                    if (terminal.currentDirectory.getFileContent().containsKey(inputs[1]) &&
                            terminal.currentDirectory.getFileContent().containsKey(inputs[2])) {
                        terminal.cp(terminal.currentDirectory.getFileContent().get(inputs[1]),
                                terminal.currentDirectory.getFileContent().get(inputs[2]));
                    } else {
                        // use the overloaded function to create a new textfile and copy the text into it
                        terminal.cp((TextFile) terminal.currentDirectory.getFileContent().get(inputs[1]), inputs[2]);
                    }
                }
                case "locate": terminal.locate(terminal.currentDirectory.getFileContent().get(inputs[1]));
                case "help": System.out.println(help);
                default:System.out.println("Command is not valid, try: \n" + help);
            }
            System.out.println(terminal.getPath());
        }
        System.exit(0);
    }
}
