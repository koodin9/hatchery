import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	
	private String localPath;
	private boolean useFirstRow;
	int lineCount, i;
	String fileType, answer;
	BufferedReader bufferedReader;
	
	public boolean setUseFirstRow(String ans){
		if(ans.equals("yes")){
			useFirstRow = true;
			return true;
		}else if(ans.equals("no")){
			useFirstRow = false;
			return true;
		}else{
			return false;
		}
	}
	public boolean setLocalPath (String localPath){
		try{
			this.localPath = localPath;
			bufferedReader = new BufferedReader(new FileReader(localPath));
			return true;
		}catch(FileNotFoundException fnfe){
			return false;
		}
	}
	public String getLocalPath(){
		return localPath;
	}
	public void previewRows(int rowCount) throws IOException{
		String line;
		i = 1;
		try {
			while((line = bufferedReader.readLine())!= null && i <= lineCount){
				System.out.println("[Row"+i+"]"+line);
				i ++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedReader.close();
	}

}