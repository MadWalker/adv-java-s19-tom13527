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

        @param args String token
    */
    public void processToken(String token) {

    }
}
