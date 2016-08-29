package test;

public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Parsing Data
		Parser parser = new Parser();
		parser.getLocalPathFromUser();
		parser.getDataTypeFromUser();
		
		
		//HDFS
		HDFSConnector hdfs = new HDFSConnector(parser);
		hdfs.uploadFileToHdfs();
		
		//
		
	}

}
