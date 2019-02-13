package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    This class will take a file inputed into the command line and count the number
    of distinct tokens that are found within it's text.

    @author Tom Good
*/
public class DistinctTokensAnalyzer implements TokenAnalyzer {
    // Declare instance variable
    private Set<String> distictTokens;
    // Get method
    public Set<String> getDistinctTokens() { return distinctTokens; }
    /**
        This method will take in the inputed file and count/document the number
        of distinct tokens found within the text.

        @param args String inputFilePath, String outputFilePath
    */
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        distictTokens = new TreeSet();
        try (
            BufferedReader input = new BufferedReader(new FileReader(inputFilePath));
            PrintWriter outputFilePath = new PrintWriter(new BufferedWriter(new FileWriter("distinctTokens.txt")))
        )
            while (input.ready()) {
                // Add string to a treeset to sort distinct tokens
                distictTokens.add(input.readLine());
                // Loop through treeset and output distinct tokens to output file
                for (String set : distictTokens) {
                    outputFilePath.println(set);
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
