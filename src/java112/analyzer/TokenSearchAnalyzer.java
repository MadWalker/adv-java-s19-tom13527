/**
    Class: TokenLengthsAnalyzer
    Author: Tom Good
    Create date: 3/16/2019
*/
package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    Description:    This class, which implements the interface TokenAnalyzer,
    will determine the location of certain tokens within a map and display each
    location that said token shows up to a file

    @author Tom Good
*/
public class TokenSearchAnalyzer implements TokenAnalyzer {
    // Empty Constructor
    public TokenSearchAnalyzer() {}
    /**
        Constructor with one Properties parameter

        @param properties file path passed own
    */
    public TokenSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    // Declare instance variables
    private Properties properties;
    private Map<String, List<Integer>> foundLocations = new HashMap<String, List<Integer>>();
    private int currentTokenLocation;
    /**
        Get method for foundLocations

        @return foundLocations
    */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }

    /**
        This method...

        @param token each token sent from the input file
    */
    public void processToken(String token) {
        if (tokenLengths.containsKey(token.length())) {
            tokenLengths.put(token.length(), tokenLengths.get(token.length()) + 1);
        } else {
            tokenLengths.put(token.length(), + 1);
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
        String outputFile = properties.getProperty("output.file.token.lengths");
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputPath + outputFile)))
        )
        {
            for (Map.Entry<Integer, Integer> map : tokenLengths.entrySet()) {
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
