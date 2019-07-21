package utilityPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
   private static XSSFSheet ExcelWSheet;
   private static XSSFWorkbook ExcelWBook;
   private static XSSFCell Cell;
   private static XSSFRow Row;
   public static void setExcelFile(String Path,String SheetName) throws Exception
   {
	   try
	   {
		   FileInputStream ExcelFile=new FileInputStream(Path);
		   ExcelWBook=new XSSFWorkbook(ExcelFile);
		   ExcelWSheet=ExcelWBook.getSheet(SheetName);
	   }
	   catch(Exception e)
	   {
		   throw(e);
	   }
   }
   public static int getRowContains(String sTestCaseName,int colNum)throws Exception
   {
	   int i;
	   try
	   {
		   int rowCount=ExcelWSheet.getLastRowNum();
				   
		   for(i=1;i<=rowCount;i++)
		   {
			   if(ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName))
			   {
				   break;
			   }
		   }
		   return i;
	   }
	   catch(Exception e)
	   {
		   throw(e);
	   }
   }
   public static int noofblankrows(int iTestCaseRow,int rCount)throws Exception
   {
	   int i;
	   for(i=iTestCaseRow+1;i<=rCount;i++)
	   {
		   
		   if(ExcelUtils.getCellData(i,0)!="")
		   {
			   break;
		   }
	   }
	   System.out.println("Blank"+i);
	   return i;
   }
   public static String getCellData(int RowNum,int ColNum)throws Exception
   {
	   try
	   {
		   Cell=ExcelWSheet.getRow(RowNum).getCell(ColNum);
				 
		   String CellData=Cell.getStringCellValue();
		   return CellData;
	   }
	   catch(Exception e)
	   {
		   return "";
	   }
   }
   public static Object[][] getTableArray(int iTestCaseRow)throws Exception
   {
	   int rCount=ExcelWSheet.getLastRowNum();
	   int k=noofblankrows(iTestCaseRow,rCount);
	   int noOfCols=(ExcelWSheet.getRow(iTestCaseRow).getLastCellNum())-1;
	   int noOfRows=(k-iTestCaseRow);
	   System.out.println(noOfRows);
	   System.out.println(noOfCols);
	   String[][] tabArray=new String[noOfRows][noOfCols];
	   try
	   {
		   int ci=0;
		   while(iTestCaseRow<k)
		   {
			   int startCol=1;
			   int cj=0;
			   int totalCols=(ExcelWSheet.getRow(iTestCaseRow).getLastCellNum())-1;
					  
			   for(int j=startCol;j<=totalCols;j++,cj++)
			   {
				   System.out.println("value of cj");
				   System.out.println(cj);
				   tabArray[ci][cj]=getCellData(iTestCaseRow,j);
				   System.out.println(tabArray[ci][cj]);
			   }
			   ci=ci+1;
			   iTestCaseRow=iTestCaseRow+1;
		   }
	   }
	   catch(FileNotFoundException e)
	   {
		   System.out.println("Could not read the excel sheet");
	   }
	   catch(IOException e)
	   {
		   e.printStackTrace();
	   }
	   return(tabArray);
	   
   }
   
}
