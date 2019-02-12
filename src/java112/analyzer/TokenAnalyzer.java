package java112.analyzer;
/**
    This interface will hold the methods to process the number of tokens and to
    generate the output file

    @author Tom Good
*/
public interface TokenAnalyzer {
    void processToken(String token);
    void generateOutputFile(String inputFilePath, String outputFilePath);
}
