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
    //private int maxAmountOfTokens = 0;
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
            //maxAmountOfTokens += 1;
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
        for (Map.Entry<Integer, Integer> map : tokenLengths.entrySet()) {
            if (maxAmountOfTokens < map.getValue()) {
                maxAmountOfTokens = map.getValue();
            }
        }
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputPath + outputFile)))
        )
        {
            for (Map.Entry<Integer, Integer> map : tokenLengths.entrySet()) {
                output.println(map.getKey() + "\t" + map.getValue());
            }
            output.println("\n\n");
            for (Map.Entry<Integer, Integer> map : tokenLengths.entrySet()) {
                int tokenInstances = map.getValue();
                String repeated = "";
                if (tokenInstances == maxAmountOfTokens) {
                    repeated = new String(new char[77]).replace("\0", "*");
                } else if (tokenInstances >= maxAmountOfTokens * 0.9 && map.getValue() < maxAmountOfTokens) {
                    repeated = new String(new char[69]).replace("\0", "*");
                } else if (tokenInstances >= maxAmountOfTokens * 0.8 && map.getValue() < maxAmountOfTokens * 0.9) {
                    repeated = new String(new char[61]).replace("\0", "*");
                } else if (tokenInstances >= maxAmountOfTokens * 0.7 && map.getValue() < maxAmountOfTokens * 0.8) {
                    repeated = new String(new char[53]).replace("\0", "*");
                } else if (tokenInstances >= maxAmountOfTokens * 0.6 && map.getValue() < maxAmountOfTokens * 0.7) {
                    repeated = new String(new char[45]).replace("\0", "*");
                } else if (tokenInstances >= maxAmountOfTokens * 0.5 && map.getValue() < maxAmountOfTokens * 0.6) {
                    repeated = new String(new char[37]).replace("\0", "*");
                } else if (tokenInstances >= maxAmountOfTokens * 0.4 && map.getValue() < maxAmountOfTokens * 0.5) {
                    repeated = new String(new char[29]).replace("\0", "*");
                } else if (tokenInstances >= maxAmountOfTokens * 0.3 && map.getValue() < maxAmountOfTokens * 0.4) {
                    repeated = new String(new char[21]).replace("\0", "*");
                } else if (tokenInstances >= maxAmountOfTokens * 0.2 && map.getValue() < maxAmountOfTokens * 0.3) {
                    repeated = new String(new char[13]).replace("\0", "*");
                } else if (tokenInstances >= maxAmountOfTokens * 0.1 && map.getValue() < maxAmountOfTokens * 0.2) {
                    repeated = new String(new char[5]).replace("\0", "*");
                } else if (tokenInstances < maxAmountOfTokens * 0.1) {
                    repeated = new String(new char[1]).replace("\0", "*");
                }
                output.println(map.getKey() + "\t" + repeated);
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
