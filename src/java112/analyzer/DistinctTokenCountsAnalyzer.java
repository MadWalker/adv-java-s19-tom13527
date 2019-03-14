/**
    Class: DistinctTokenCountsAnalyzer
    Author: Tom Good
    Create date: 3/04/2019
*/
package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    Description:    This class, which implements the interface TokenAnalyzer,
    will not only display each distinct token, but the number of times that token
    shows up within the file using a map

    @author Tom Good
*/
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer {
    // Empty Constructor
    public DistinctTokenCountsAnalyzer() {}
    /**
        Constructor with one Properties parameter

        @param properties file path passed own
    */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    // Declare instance variables
    private Properties properties;
    private Map<String, Integer> distinctTokenCounts = new TreeMap<String, Integer>();
    /**
        Get method for distinctTokenCounts

        @return distinctTokenCounts
    */
    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    /**
        This method takes each token sent to it and adds it to a Map, which will
        take the token and the number of times that token shows up in the file

        @param token each token sent from the input file
    */
    public void processToken(String token) {
        if (distinctTokenCounts.containsKey(token)) {
            distinctTokenCounts.put(token, distinctTokenCounts.get(token) + 1);
        } else {
            distinctTokenCounts.put(token, 1);
        }
    }
    /**
        This method takes in the information gathered by the processToken method
        , which is the distinct token and the number of times that token shows up,
        and displays it to a new file.

        @param inputFilePath sends the name of the inputfile
    */
    public void generateOutputFile(String inputFilePath) {
        String outputPath = properties.getProperty("output.directory");
        String outputFile = properties.getProperty("output.file.distinct.counts");
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputPath + outputFile)))
        )
        {
            for (Map.Entry<String, Integer> map : distinctTokenCounts.entrySet()) {
                output.println(map.getKey() + "\t" + map.getValue());
            }

        }
            catch (FileNotFoundException fileNotFound)
            {
                fileNotFound.printStackTrace();
            }
            catch (IOException inputOutputException)
            {
                inputOutputException.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
    }
}
