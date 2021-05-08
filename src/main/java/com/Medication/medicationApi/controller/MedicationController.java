package com.Medication.medicationApi.controller;

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


    @GetMapping
    public ResponseEntity<Medication> getMedicationFromBarcode(@RequestParam(required = false) String barcode){
        if(barcode != null){ //TODO error handling
            for(Medication medication : medicationList){ //needs better search maybe?
                if(medication.getBarcode().equals(barcode)){
                    return new ResponseEntity<>(medication, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
