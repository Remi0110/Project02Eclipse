package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications
 *
 * The implementation does not need to order the list
 *
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 *
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	List<String> getSymptoms(String fileName);

	/**
	 * count occurences of symptoms in a file
	 *
	 * @param list of symptoms
	 * 
	 * @return map of iteration of symptoms with their occurences
	 * 
	 * @author R�mi ESPIN
	 */
	public Map<String, Integer> getSymptomsWithOccurences(List<String> symptoms);

	/**
	 * write a new file from a map of symptoms
	 *
	 * @param map with symptoms and their occurences
	 * 
	 * @return file with number of iteration of each symptoms from the file in param
	 *        
	 * @author R�mi ESPIN
	 */
	void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException;
}
