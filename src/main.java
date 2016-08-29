import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		new MainController(args);
	}
}

class MainController {
	private void askDropFirstLine() {
		System.out.println(parser.getFirstLines());
		System.out.println("Drop first line? (Y/N) : ");
		if (scan.nextLine().equalsIgnoreCase("N")) {
			firstLineFlag = true;
		}
	}

	boolean firstLineFlag = false;
	String localInput, HDFSInput, output;
	Storage store = new Storage();
	Parser parser = new Parser();
	Scanner scan = new Scanner(System.in);
	String tokens;
	
	MainController(String[] args) {
		localInput = args[0];
		HDFSInput = args[1];
		output = args[2];
	}

	if (store.setFilePath(localInput, HDFSInput, output)) {
		System.out.println("Enter tokens (token,token): ");
		tokens = scan.nextLine();
		parser.getToken(tokens);
	}
	
	this.askDropFirstLine(); 
	
	parser.setFileContents(firstLineFlag);
	setAttribute(String attr, int columnIndex);
	
}
