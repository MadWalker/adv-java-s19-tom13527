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
    // Create instance variable
    private Set<String> distinctTokens = new TreeSet();
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
    }
    /**
        This method takes in the inputed file and counts/documents the number
        of distinct tokens found within the text.

        @param inputFilePath sends the name of the inputfile
        @param outputFilePath sends the name of the outputfile
    */
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))
        )
        {
            //output.println(distinctTokens.size());
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
}
