package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
	
	private String localPath;
	private ArrayList<DataTypeWrapper> dataTypes;
	private boolean isUseFirstRow;
	Scanner scanner = new Scanner(System.in);
	

	public String getLocalPath(){
		return localPath;
		
	}
	public void getLocalPathFromUser(){ //로컬 받는거
		//여기 확장자 가져와서 어떤 파일 포맷인지 설정해주는 것도 필요
		localPath = scanner.next();
	}
	public void getLineOptionFromUser(){ //1. 첫번째줄 쓸꺼야?
		isUseFirstRow = true;
	}
	
	public void getDataTypeFromUser(){
		//,,,,,
		dataType = fds;
	}
	
	public String getTypeString(){
		return 
	}
}
