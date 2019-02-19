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
    public int getTotalTokensCount() { return totalTokensCount; }

    public void processToken(String token) {
        ArrayList<String> listOfTokens = new ArrayList();;
        listOfTokens.add(token);
        for (String list : listOfTokens) {
            totalTokensCount ++;
        }
    }
    /**
        This method will create the summary file, including the distinct tokens,
        of the file that is inputed to the command line.

        @param args not used here
    */
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        try (
            BufferedReader input = new BufferedReader(new FileReader(inputFilePath));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))
        )
        {
            while (input.ready())
            {
                System.out.println("Application: File Magic\n");
                System.out.println("Author: Tom Good\n");
                System.out.println("Author Email: good@madisoncollege.edu\n");
                System.out.println("Author: Tom Good\n");
                System.out.println("File: " + input + "\n");
                System.out.println("Date of Analysis: \n");
                System.out.println("Last Modified : \n");
                System.out.println("File Size: \n");
                System.out.println("File URI: \n");
                System.out.println("Total Tokens: " + totalTokensCount + "\n");
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
