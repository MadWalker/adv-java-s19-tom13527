/**
    Class: LargestTokensAnalyzer
    Author: Tom Good
    Create date: 3/04/2019
*/
package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    Description:    This class, which implements the interface TokenAnalyzer,
    will compare the length of  a distinct tokens shows up in a file and,
    if it is larger than a specified number, the distinct token will be added
    to a file

    @author Tom Good
*/
public class LargestTokensAnalyzer implements TokenAnalyzer {
    // Declare instance variables
    private Properties properties;
    private Set<String> largestTokens = new TreeSet();
    private int minimumTokenLength; //= properties.getProperty(largest.words.minimum.length);
    // Empty constructor
    public LargestTokensAnalyzer() {}
    /**
        Constructor with one Properties parameter

        @param properties
    */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        properties = new Properties();
        minimumTokenLength = Integer.parseInt(properties.getProperty("largest.words.minimum.length"));
        System.out.println(minimumTokenLength);
    }
    /**
        Get method for getLargestTokens

        @return largestTokens
    */
    public Set<String> getLargestTokens() {
        return largestTokens;
    }

    /**
        This method takes each token sent to it and adds it to a TreeSet if the
        length of the token in greater than the specified number

        @param token each token sent from the input file
    */
    public void processToken(String token) {
        int length = token.length();
        if (length >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }

    /**
        This method takes in the inputed file and counts/documents the number
        of distinct tokens found within the input file as long as the length
        of the token is more than the minimum number specified.

        @param inputFilePath sends the name of the inputfile
    */
    public void generateOutputFile(String inputFilePath) {
        properties = new Properties();
        //String distinctTokensFilePath = "output/distinct_tokens.txt";
        //File outputPath = new File(distinctTokensFilePath);
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(properties.getProperty("output.directory", "output.file.largest.words"))))
        )
        {
            //output.println(distinctTokens.size());
            largestTokens.forEach(output::println);

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
