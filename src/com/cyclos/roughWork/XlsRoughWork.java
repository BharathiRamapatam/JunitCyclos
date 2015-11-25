package com.cyclos.roughWork;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cyclos.datatable.Xls_Reader;

public class XlsRoughWork {

	public static void main(String[] args) {
		String testCase = "LoginTest";
		Xls_Reader xlRead = new Xls_Reader("C:\\Users\\bharathi.ramapatnam\\Documents\\Book2.xlsx");
		System.out.println(xlRead.getRowCount("FirstSuite"));
		//System.out.println(xlRead.getCellData("FirstSuite", "TCID", 5));
		/*
		for (int rowNum=2; rowNum<= xlRead.getRowCount("FirstSuite");rowNum++ ){
			if(testCase.equals(xlRead.getCellData("FirstSuite", "TCID", rowNum))){
				if(xlRead.getCellData("FirstSuite", "Runmode", rowNum).equals("y"))
					System.out.println("run the test ");
				else
					System.out.println("Skip the test ");
			}
			*/
			//System.out.println(xlRead.getCellData("LoginParameterTest", 1, 4));
			
		}
	
		
		
		}
		
		

	


