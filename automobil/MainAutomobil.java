package automobil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MainAutomobil {

	public static void main(String[] args) throws IOException {
		
		Automobil automobil1 = new Automobil("BMW", "X3", 866212, "Jelena Brkic");
		Automobil automobil2 = new Automobil("Toyota", "Rav4", 755213, "Marko Markovic");
		
		File fajl = new File("data/podaci6.xlsx");
		
		FileOutputStream fos = new FileOutputStream(fajl);
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet list = wb.createSheet("Automobili");

		Automobil[] automobili = {automobil1, automobil2};
		
		for (int i = 0; i < automobili.length; i++) {
			XSSFRow red = list.createRow(i);
			
			XSSFCell marka = red.createCell(0);
			XSSFCell model = red.createCell(1);
			XSSFCell serijskiBroj = red.createCell(2);
			XSSFCell vlasnikAutomobila = red.createCell(3);
			
			marka.setCellValue(automobili[i].getMarka());
			model.setCellValue(automobili[i].getModel());
			serijskiBroj.setCellValue((int)automobili[i].getSerijskiBroj());
			vlasnikAutomobila.setCellValue(automobili[i].getVlasnikAutomobila());
		}
		
		wb.write(fos);
		wb.close();
		fos.close();
		
		System.out.println("Podaci upisani u fajl.");
		System.out.println();
		System.out.println("Podaci iz fajla:");
		
		FileInputStream fis = new FileInputStream(fajl);
		
		XSSFWorkbook wb2 = new XSSFWorkbook(fis);
		
		XSSFSheet list2= wb.getSheet("Automobili");
		
		for (int i = 0; i <= list2.getLastRowNum(); i++) {
			XSSFRow row = list2.getRow(i);
			
			XSSFCell marka = row.getCell(0);
			XSSFCell model = row.getCell(1);
			XSSFCell serijskiBroj = row.getCell(2);
			XSSFCell vlasnikAutomobila = row.getCell(3);
			
			
			System.out.print(marka.getStringCellValue() + ", ");
			System.out.print(model.getStringCellValue() + ", ");
			System.out.print((int)serijskiBroj.getNumericCellValue() + ", ");
			System.out.println(vlasnikAutomobila.getStringCellValue() );
			
		}

		wb2.close();
		fis.close();
	}

}
