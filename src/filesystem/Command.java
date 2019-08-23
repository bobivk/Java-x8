package filesystem;

public interface Command {
	public void execute(Terminal terminal, String... inputs);
}
