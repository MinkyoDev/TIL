package com.shinhan.day13.c18_lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileCompareUtil {

	static ArrayList<String> compareFile(String fstFileName, String scdFileName) throws Exception {
		ArrayList<String> result = new ArrayList<String>();
		BufferedReader br1 = new BufferedReader(new FileReader(fstFileName));
		BufferedReader br2 = new BufferedReader(new FileReader(scdFileName));
		
		String line1, line2;
		while ((line1 = br1.readLine()) != null) {
			line2= br2.readLine();
			if (!line1.equals(line2)) {
				result.add(line1);
			} 
		}
		br1.close();
		br2.close();
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		String fstFileName = "./src/com/shinhan/day13/c18_lab1/data1.txt";
		String scdFileName = "./src/com/shinhan/day13/c18_lab1/data2.txt";
		
		ArrayList<String> list = compareFile(fstFileName, scdFileName);
		System.out.println(list);
	}
}
