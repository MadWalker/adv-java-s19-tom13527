package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    This class will create a summary file for the input file that is being
    analyzed.

    @author Tom Good
*/
public class FileSummaryAnalyzer implements TokenAnalyzer {
    // Declare instance variable
    private int totalTokensCount;
    // Get method
    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    public void processToken(String token) {
        ArrayList<String> listOfTokens = new ArrayList();
        listOfTokens.add(token);
        for (String list : listOfTokens) {
            totalTokensCount += 1;
        }
    }
    /**
        This method will create the summary file, including the distinct tokens,
        of the file that is inputed to the command line.

        @param args not used here
    */
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))
        )
        {
            output.println("Application: File Magic");
            output.println("Author: Tom Good");
            output.println("Author Email: good@madisoncollege.edu");
            output.println("File: " + inputFilePath);
            output.println("Date of Analysis: " + new Date());
            output.println("Last Modified :");
            output.println("File Size: ");
            output.println("File URI: ");
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
