package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    This class will take a file inputed into the command line and count the number
    of distinct tokens that are found within it's text.

    @author Tom Good
*/
public class DistinctTokensAnalyzer implements TokenAnalyzer {
    private Set<String> distinctTokens = new TreeSet();
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
    public void processToken(String token) {
        distinctTokens.add(token);
    }
    /**
        This method will take in the inputed file and count/document the number
        of distinct tokens found within the text.

        @param args String inputFilePath, String outputFilePath
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
