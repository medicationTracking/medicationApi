package com.Medication.medicationApi.exception;

public class BarcodeNotGivenException extends RuntimeException{
    public BarcodeNotGivenException(String msg){
        super(msg);
    }
}
