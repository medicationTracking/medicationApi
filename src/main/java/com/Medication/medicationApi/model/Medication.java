package com.Medication.medicationApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
    String name;
    String activeIngredient;
    String barcode;
}
