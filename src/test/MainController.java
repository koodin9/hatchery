import java.util.Scanner;

public class MainController {

	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainController main = new MainController();
		
		try{
			//Parsing Data
			Parser parser = new Parser();
			while(!parser.setLocalPath(main.getUserInputString("input path in local file system : "))){
				System.out.println("File Not Found");
			}
			parser.previewRows(main.getUserInputInteger("How many rows do you want to preview ? (number)","number"));
			while(!parser.setUseFirstRow(main.getUserInputString("Do you want to use first row? (yes/no").toLowerCase())){
				System.out.println("(yes/no)");
			}
			//HDFS
			HDFSConnector hdfsConnector = new HDFSConnector(parser);
			hdfsConnector.setHdfsPath(main.getUserInputString("output path in HDFS : "));
			hdfsConnector.uploadFileToHdfs();
			//
		}catch(Exception ex){
			
		}
	}
	public String getUserInputString(String message){
		System.out.print(message);
		return scanner.next();
	}
	public int getUserInputInteger(String message, String exceptionMessage){
		int input;
		while(true){
			try{
				input = Integer.parseInt(scanner.next());
				break;
			}catch(NumberFormatException nfe){
				System.out.print(exceptionMessage);
			}
		}return input;
	}
}