package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		final String file = new String("symptoms.txt");

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();
		readSymptomDataFromFile.writeFileFromListWithSymptomsAndOccurences(file);
	}

}