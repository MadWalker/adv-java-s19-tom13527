/**
    Class: DistinctTokensAnalyzer
    Author: Tom Good
    Create date: 2/16/2019
*/
package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    Description:    This class, which implements the TokenAnalyzer interface,
    first adds each individual token to an ArrayList and count each time
    a new token is added. After, this class creates an output file that is
    a summary of the input file.

    @author Tom Good
*/
public class FileSummaryAnalyzer implements TokenAnalyzer {
    // Empty constructor
    public FileSummaryAnalyzer() {}
    /**
        Constructor with one Properties parameter

        @param properties
    */
    public FileSummaryAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    // Declare instance variable
    private int totalTokensCount;
    private Properties properties;
    /**
        Get method for totalTokensCount

        @return totalTokensCount
    */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }
    /**
        This method sends each string that gets passed down to an ArrayList. The
        method counts every time a new string is added to the list.

        @param token token from input file passed down
    */
    public void processToken(String token) {
        ArrayList<String> listOfTokens = new ArrayList();
        listOfTokens.add(token);
        for (String list : listOfTokens) {
            totalTokensCount += 1;
        }
    }
    /**
        This method creates the summary file, including the distinct tokens,
        of the file that is inputed to the command line by the user.

        @param inputFilePath used to get input file name
        @param outputFilePath used to get the name of the output file
    */
    public void generateOutputFile(String inputFilePath) {
        properties = new Properties();
        File inputFile = new File(inputFilePath);
        //String summaryFilePath = "output/summary.txt";
        //File outputPath = new File(summaryFilePath);
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(properties.getProperty("output.directory", "output.file.summary"))))
        )
        {
            output.println("Application name: " + properties.getProperty("application.name"));
            output.println("Author: " + properties.getProperty("author"));
            output.println("Author Email: " + properties.getProperty("author.email.address"));
            output.println("File: " + inputFile);
            output.println("Date of Analysis: " + new Date());
            output.println("Last Modified : " + new Date(inputFile.lastModified()));
            output.println("File Size: " + inputFile.length());
            output.println("File URI: " + inputFile.toURI());
            output.println("Total Tokens: " + getTotalTokensCount());
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
