package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	public ReadSymptomDataFromFile() {

	}

	@Override
	public List<String> getSymptoms(String fileName) {
		List<String> result = new ArrayList<String>();

		if (fileName != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public FileWriter writeFileFromListWithSymptomsAndOccurences(String fileName) throws IOException {
		Map<String, Integer> symptomsOccurences = this.getSymptomsWithOccurences(fileName);
		FileWriter writer = new FileWriter("result.out");
		symptomsOccurences.forEach((k, v) -> {
			try {
				writer.write(k + ":" + v);
				writer.write(System.getProperty("line.separator"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		writer.close();
		return writer;
	}

	@Override
	public Map<String, Integer> getSymptomsWithOccurences(String fileName) {
		List<String> symptoms = this.getSymptoms(fileName);
		Collections.sort(symptoms);
		Map<String, Integer> map = new TreeMap<>();

		for (String symptom : symptoms) {
			map.put(symptom, map.containsKey(symptom) ? map.get(symptom) + 1 : 1);
		}

		return map;

	}

}
