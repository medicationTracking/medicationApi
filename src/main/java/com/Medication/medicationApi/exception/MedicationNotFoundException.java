package com.Medication.medicationApi.exception;

public class MedicationNotFoundException extends  RuntimeException{
    public MedicationNotFoundException(String msg){
        super(msg);
    }
}
