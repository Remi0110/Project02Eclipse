package com.hemebiotech.analytics;

import java.io.FileWriter;
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
	 * @param file
	 *            name
	 * @return list of iteration of symptoms with their occurences : : :
	 * @author Rémi ESPIN
	 */
	public Map<String, Integer> getSymptomsWithOccurences(String fileName);

	/**
	 * write a new file from a list of symptoms
	 *
	 * @param file
	 *            name
	 * @return file with number of iteration of symptoms from the file in argument :
	 *         : :
	 * @author Rémi ESPIN
	 */
	FileWriter writeFileFromListWithSymptomsAndOccurences(String fileName) throws IOException;
}
