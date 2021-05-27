package com.Medication.medicationApi.service;

import com.Medication.medicationApi.model.Medication;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedicationService {

    public List<Medication> readMedicationsFromFile()  {
        List<Medication> medicationList = new ArrayList<>();
        try {
            OPCPackage pkg = OPCPackage.open(new File("medicationList.xlsx"));
            //creating workbook instance that refers to .xls file
                XSSFWorkbook wb = new XSSFWorkbook(pkg);
                //creating a Sheet object to retrieve the object
                XSSFSheet sheet = wb.getSheetAt(0);
                int rowCount = 0;
                for(Row row: sheet){    //iteration over row using for each loop
                    int cellCount = 0;
                    Medication medication = new Medication();
                    for(Cell cell: row){    //iteration over cell using for each loop
                        DataFormatter df = new DataFormatter();
                        if(cellCount == 1 && rowCount != 0){
                            medication.setBarcode(df.formatCellValue(cell));
                        }
                        if(cellCount == 2 && rowCount != 0){
                            medication.setName(df.formatCellValue(cell));
                        }
                        if(cellCount == 3 && rowCount != 0){
                            medication.setActiveIngredient(df.formatCellValue(cell));
                        }if(cellCount == 5 && rowCount != 0){
                            medication.setCompany(df.formatCellValue(cell));
                        }
                        cellCount++;
                    }
                    if(rowCount != 0){
                        medicationList.add(medication);
                    }
                    rowCount++;
                }
            } catch (InvalidFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        medicationList.remove(medicationList.get(medicationList.size()-1));
        return  medicationList;
    }
}
