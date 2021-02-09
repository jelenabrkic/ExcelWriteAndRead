package racun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MainRacun {

	public static void main(String[] args) throws IOException   {
		
		Racun racun1 = new Racun("027-11356-112", 0);
		Racun racun2 = new Racun("033-35898-003", 0);
		Racun racun3 = new Racun("558-93312-997", 0);
		
		File fajl = new File("data/podaci5.xlsx");
		
		FileOutputStream fos = new FileOutputStream(fajl);
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet list = wb.createSheet("Racuni");
		
		Racun[] racuni = {racun1, racun2, racun3};
		double[] dodaj = {2000.0, 3000.0, 1000.0};
		double[] oduzmi = {500.0, 700.0, 200.0};
		
		for (int i = 0; i < racuni.length; i++) {
			XSSFRow red = list.createRow(i);
			
			XSSFCell brRacuna = red.createCell(0);
			XSSFCell pocetnoStanje = red.createCell(1);
			XSSFCell uplacenNovac = red.createCell(2);
			XSSFCell podignutNovac = red.createCell(3);
			XSSFCell trenutnoStanje = red.createCell(4);
			
			brRacuna.setCellValue(racuni[i].getBrRacuna());
			pocetnoStanje.setCellValue(racuni[i].getStanje());
			
			uplacenNovac.setCellValue(racuni[i].dodavanjeNovca(dodaj[i]));
			podignutNovac.setCellValue(racuni[i].uzimanjeNovca(oduzmi[i]));
			trenutnoStanje.setCellValue(racuni[i].getStanje());
			
		}
		
		wb.write(fos);
		wb.close();
		fos.close();
		
		System.out.println("Podaci upisani u fajl.");
		System.out.println();
		System.out.println("Podaci iz fajla:");
		
		FileInputStream fis = new FileInputStream(fajl);
		
		XSSFWorkbook wb2 = new XSSFWorkbook(fis);
		
		XSSFSheet list2= wb.getSheet("Racuni");
		
		for (int i = 0; i <= list2.getLastRowNum(); i++) {
			XSSFRow row = list2.getRow(i);
			
			XSSFCell brRacuna = row.getCell(0);
			XSSFCell pocetnoStanje = row.getCell(1);
			XSSFCell uplacenNovac = row.getCell(2);
			XSSFCell podignutNovac = row.getCell(3);
			XSSFCell trenutnoStanje = row.getCell(4);
			
			
			System.out.print(brRacuna.getStringCellValue() + ", ");
			System.out.print(pocetnoStanje + ", ");
			System.out.print(uplacenNovac + ", ");
			System.out.print(podignutNovac + ", ");
			System.out.println(trenutnoStanje);
		}

		wb2.close();
		fis.close();

	}

}
