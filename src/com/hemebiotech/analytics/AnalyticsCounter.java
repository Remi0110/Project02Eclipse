package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {


	ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();
	
	/**
	 * read symptoms in a file and create a list of symptoms 
	 *
	 * @param file
	 * 
	 * @return list of symptoms
	 * 
	 * @author Rémi ESPIN
	 */
	public List<String> reading(String file) {
		return readSymptomDataFromFile.getSymptoms(file);
	}
	
	/**
	 * count occurences of symptoms in a list and create a map of symptoms 
	 *
	 * @param list of symptoms
	 * 
	 * @return map of iteration of symptoms with their occurences
	 * 
	 * @author Rémi ESPIN
	 */
	public Map<String, Integer> count(List<String> symptoms){
		return readSymptomDataFromFile.getSymptomsWithOccurences(symptoms);
	}
	
	/**
	 * save a new file from a map of symptoms
	 *
	 * @param map with symptoms and their occurences
	 * 
	 * @return file with number of iteration of each symptoms from the map in param
	 *        
	 * @author Rémi ESPIN
	 */
	public void saving(Map<String, Integer> mapSymptomsOccurences) throws Exception {
		readSymptomDataFromFile.writeSymptomsAndOccurences(mapSymptomsOccurences);
	}

}


