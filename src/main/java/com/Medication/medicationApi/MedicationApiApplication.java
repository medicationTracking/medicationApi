package com.Medication.medicationApi;

import com.Medication.medicationApi.service.MedicationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicationApiApplication {

	public static void main(String[] args) {
		MedicationService service = new MedicationService();
		service.readMedicationsFromFile("a");
		SpringApplication.run(MedicationApiApplication.class, args);
	}

}
