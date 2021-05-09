package com.Medication.medicationApi.controller;

import com.Medication.medicationApi.exception.BarcodeNotGivenException;
import com.Medication.medicationApi.exception.MedicationNotFoundException;
import com.Medication.medicationApi.model.Medication;
import com.Medication.medicationApi.service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {
    List<Medication> medicationList;

    public MedicationController(){
        MedicationService medicationService = new MedicationService();
        medicationList = medicationService.readMedicationsFromFile();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Medication>> getAllMedications(){
        return new ResponseEntity<>(medicationList,HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<Medication> getMedicationFromBarcode(@RequestParam(required = false) String barcode){
        Medication medicationToFind = null;
        if(barcode != null){ 
            for(Medication medication : medicationList){ //needs better search maybe?
                if(medication.getBarcode().equals(barcode)){
                    medicationToFind = medication;
                    return new ResponseEntity<>(medicationToFind, HttpStatus.OK);
                }
            }
            if(medicationToFind == null){
                throw new MedicationNotFoundException("Medication not found");
            }
        }else{
            throw new BarcodeNotGivenException("No barcode given");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BarcodeNotGivenException.class)
    public ResponseEntity<String> handleBarcodeNotGivenException(BarcodeNotGivenException ex){
        return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MedicationNotFoundException.class)
    public ResponseEntity<String> handleMedicationNotFoundException(MedicationNotFoundException ex){
        return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.NOT_FOUND);
    }
}
