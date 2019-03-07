/**
    Class: DistinctTokensAnalyzer
    Author: Tom Good
    Create date: 2/16/2019
*/
package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    Description:    This class, which implements the interface TokenAnalyzer,
    gathers each distinct token and adds them to a TreeSet distinctTokens. It
    then creates an output file that shows each distinct file found within
    the input file.

    @author Tom Good
*/
public class DistinctTokensAnalyzer implements TokenAnalyzer {
    // Empty constructor
    public DistinctTokensAnalyzer() { }
    /**
        Constructor with one Properties parameter

        @param properties
    */
    public DistinctTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    // Create instance variable
    private Set<String> distinctTokens = new TreeSet();
    private Properties properties;
    /**
        The get method for the set distinctTokens

        @return distinctTokens
    */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
    /**
        This method takes each token sent to it and adds it to a TreeSet

        @param token each token sent from the input file
    */
    public void processToken(String token) {
        distinctTokens.add(token);
        System.out.println("Within processToken: " + token);
    }
    {System.out.println("outside of methods: " + distinctTokens);}
    /**
        This method takes in the inputed file and counts/documents the number
        of distinct tokens found within the text.

        @param inputFilePath sends the name of the inputfile
    */
    public void generateOutputFile(String inputFilePath) {
        String outputPath = properties.getProperty("output.directory");
        String outputFile = properties.getProperty("output.file.distinct");
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputPath + outputFile)))
        )
        {
            System.out.println("Within generateOutputFile: " + distinctTokens);
            distinctTokens.forEach(output::println);

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
    {System.out.println("outside of methods: " + distinctTokens);}
}
