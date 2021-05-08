package com.Medication.medicationApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medication")
public class MedicationController {

    public ResponseEntity<List<Medication>> getMedications(){

    }
}
