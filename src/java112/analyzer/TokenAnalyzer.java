/**
    Class: DistinctTokensAnalyzer
    Author: Tom Good
    Create date: 2/16/2019
*/
package java112.analyzer;
import java.io.*;
/**
    This interface holds the methods to process the number of tokens and to
    generate the output file within the DistinctTokensAnalyzer and
    FileSummaryAnalyzer classes.

    @author Tom Good
*/
public interface TokenAnalyzer {
    /**
        @param token single token passed down from input file
    */
    void processToken(String token);
    /**
        @param inputFilePath sends the name of the input file
    */
    //void generateOutputFile(String inputFilePath, String outputFilePath);
    void generateOutputFile(String inputFilePath);
}
