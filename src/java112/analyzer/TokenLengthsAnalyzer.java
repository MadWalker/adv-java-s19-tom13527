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
    will determine the length distribution of the tokens that are passed down
    and display the distribution as the actual number of its size, and a
    histogram of its size

    @author Tom Good
*/
public class TokenLengthsAnalyzer implements TokenAnalyzer {
    // Empty Constructor
    public TokenLengthsAnalyzer() {}
    /**
        Constructor with one Properties parameter

        @param properties file path passed own
    */
    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    // Declare instance variables
    private Properties properties;
    private Map<Integer, Integer> tokenLengths = new TreeMap<Integer, Integer>();
    /**
        Get method for tokenLengths

        @return tokenLengths
    */
    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }
    /**
        This method takes each token sent to it and compares the length in size
        of the token to the number of times a token of the same length appears within
        the document

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
        int maxAmountOfTokens = 0;
        // get the largest number of times a word length shows up in a file
        for (Map.Entry<Integer, Integer> map : tokenLengths.entrySet()) {
            if (maxAmountOfTokens < map.getValue()) {
                maxAmountOfTokens = map.getValue();
            }
        }
        int histogramDividend = maxAmountOfTokens / 79;
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputPath + outputFile)))
        )
        {
            // display the word length with the number of times it shows up in file
            for (Map.Entry<Integer, Integer> map : tokenLengths.entrySet()) {
                // make sure 0 length is not displayed
                if (map.getKey() != 0) {
                    output.println(map.getKey() + "\t" + map.getValue());
                }
            }
            output.println("\n\n");
            // display histogram for number of times word length shows up in file
            for (Map.Entry<Integer, Integer> map : tokenLengths.entrySet()) {
                int tokenInstances = map.getValue();
                int numberOfStars = tokenInstances / histogramDividend;
                // make sure 0 length is not displayed
                if (map.getKey() != 0) {
                    String repeated = new String(new char[numberOfStars]).replace("\0", "*");
                    output.println(map.getKey() + "\t*" + repeated);
                }
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
