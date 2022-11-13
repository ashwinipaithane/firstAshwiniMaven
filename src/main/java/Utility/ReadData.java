package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	
	//creat method for read property file
	public static String readPropertyFile(String value) throws Exception
	{
		//create object of properties
		//properties is class
		Properties readprop =new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\ashwi\\eclipse-workspace\\FirstAshwiniMaven\\TestData\\Config.property");
	   //with object of property file call "load" method and pass the actual file
		// file la access kraych ahe mhnun FileInputStream class use kele ani tya file cha path pathavala
		readprop.load(file);
		return readprop.getProperty(value);
		//ata hi method aaplyala jithe use hote tithe call kraychi like testBase madhe , inventryPage vr etc
	}
	
		// for read file 
	// read Excel file
			public static String readExcelFile(int rowNum,int ColNum) throws Exception
			{
			FileInputStream file=new FileInputStream("C:\\Users\\ashwi\\eclipse-workspace\\FirstAshwiniMaven\\TestData\\TestDataFile.xlsx");
			Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
			String value=excel.getRow(rowNum).getCell(ColNum).getStringCellValue();
			return value;
		
	}
	
		
		
	}


