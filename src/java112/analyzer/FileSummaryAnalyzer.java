package java112.analyzer;
import java.io.*;
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
    /**
        This method will create the summary file, including the distinct tokens,
        of the file that is inputed to the command line.

        @param args not used here
    */
    public void generateOutputFile(String inputFilePath, String outputFilePath) {

    }

    public void processToken(String token) {

    }
}
