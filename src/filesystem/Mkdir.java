package filesystem;

public class Mkdir implements Command {
	public void execute(Terminal terminal, String... inputs) {
		terminal.getCurrentDirectory().addFile(
				new Directory(inputs[1],
				terminal.getCurrentDirectory().getPathToDirectory())
		);
	}
}
