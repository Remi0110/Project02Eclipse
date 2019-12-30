package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		final String file = new String("symptoms.txt");

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();
		List<String> symptoms = readSymptomDataFromFile.getSymptoms(file);
		Map<String, Integer> mapSymptomsOccurences = readSymptomDataFromFile.getSymptomsWithOccurences(symptoms);
		readSymptomDataFromFile.writeSymptomsAndOccurences(mapSymptomsOccurences);
	}

}