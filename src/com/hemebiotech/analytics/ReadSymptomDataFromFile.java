package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReadSymptomDataFromFile implements ISymptomReader {

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
	public void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException {

		String currentUsersHomeDir = System.getProperty("user.home");
		String path = currentUsersHomeDir + System.getProperty("file.separator") + "result.out";
		FileWriter writer = new FileWriter(path);
		if (mapSymptomsOccurences != null && !mapSymptomsOccurences.isEmpty()) {
			mapSymptomsOccurences.forEach((k, v) -> {
				try {
					writer.write(k + "=" + v);
					writer.write(System.getProperty("line.separator"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			writer.close();

		} else {
			writer.write("aucun symptome n'a été trouvé");
			writer.close();
		}
		System.out.println("le fichier de sortie se trouve: " + path);
	}

	
	@Override
	public Map<String, Integer> getSymptomsWithOccurences(List<String> symptoms) {

		Map<String, Integer> map = new TreeMap<>();

		if (symptoms != null && !symptoms.isEmpty()) {
			Collections.sort(symptoms);

			for (String symptom : symptoms) {
				map.put(symptom, map.containsKey(symptom) ? map.get(symptom) + 1 : 1);
			}

		}
		return map;

	}

}
