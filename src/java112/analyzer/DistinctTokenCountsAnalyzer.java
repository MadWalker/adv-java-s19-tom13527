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
    shows up within the file

    @author Tom Good
*/
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer {
    // Empty Constructor
    public DistinctTokenCountsAnalyzer() {}
    /**
        Constructor with one Properties parameter

        @param properties
    */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    // Declare instance variables
    private Properties properties;
    private Map<String, Integer> distinctTokenCounts;// = new HashMap<Integer, String>();;

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
        //distinctTokensCounts.put();
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
            //output.println(distinctTokens.size());
            //distinctTokens.forEach(output::println);

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
