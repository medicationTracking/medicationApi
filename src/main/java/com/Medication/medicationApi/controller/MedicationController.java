package com.Medication.medicationApi.controller;

import com.Medication.medicationApi.model.Medication;
import com.Medication.medicationApi.service.MedicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medication")
public class MedicationController {
    List<Medication> medicationList;
    public MedicationController(){

        MedicationService medicationService = new MedicationService();
        medicationList = medicationService.readMedicationsFromFile();
    }
    public ResponseEntity<List<Medication>> getMedications(){

        return null;
    }
}
