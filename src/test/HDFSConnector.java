package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSConnector {
	private Path hdfsPath;
	private Configuration conf;
	private FileSystem hdfs;
	private Parser parser;
	private BufferedInputStream inBufferedStream;
	private BufferedOutputStream outBufferedStream;
	//private BufferedReader bufferedReader;
	byte[] buffer;
	
	public HDFSConnector (Parser parser) throws IOException{
		conf = new Configuration();
		hdfs = FileSystem.get(conf);
		this.parser = parser;
	}
	public void setHdfsPath(String hdfsPath) throws IOException{
		this.hdfsPath = new Path(hdfsPath);
		if(hdfs.delete(this.hdfsPath, true)){
			hdfs.delete(this.hdfsPath, true);
		}
	}
	public void uploadFileToHdfs() throws IOException{
		
		String localPath = parser.getLocalPath();
		inBufferedStream = new BufferedInputStream(new FileInputStream(localPath));
        outBufferedStream = new BufferedOutputStream(hdfs.create(hdfsPath));
        buffer = new byte[1024];
        int len = 0;
        //int firstRowLen = 0;
        /*if(!parser.getLineOptionFromUser()){
        	bufferedReader = new BufferedReader(new FileReader(localPath));
        	firstRowLen = bufferedReader.readLine().getBytes().length;
        	bufferedReader.close();
        }*/
        while ((len = inBufferedStream.read(buffer)) > 0) {
        	//if(useFirstRow){
        		outBufferedStream.write(buffer, 0, len);
        	/*}else{
	        	outBufferedStream.write(buffer, firstRowLen, len - firstRowLen);
        		useFirstRow = true;
        	}*/
        }
        inBufferedStream.close();
		outBufferedStream.close();
		
	}
	public Path getHdfsPath(){
		return hdfsPath;
	}
}