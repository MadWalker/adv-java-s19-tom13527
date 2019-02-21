/**
    Class: DistinctTokensAnalyzer
    Author: Tom Good
    Create date: 2/16/2019
*/
package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    This class is the controller class for the analyzer project, setting up
    the processing classes DistinctTokensAnalyzer and FileSummaryAnalyzer. It
    holds the main run method, "analyze", which will then call all other mehtods
    to open and read the input file, gather each token as a string, and pass each
    token down to the two analyzer classes.

    @author Tom Good
*/
public class FileAnalysis {
    // Declare constant
    final int COMMAND_LINE_ARGUEMENTS = 1;
    // Declare instance variables
    FileSummaryAnalyzer summaryAnalyzer;
    DistinctTokensAnalyzer distinctAnalyzer;
    /**
        This method tests to make sure there are the correct number of command-line
        arguements. If there is a correct amount of command line arguements,
        the method will instantiate an instance of the FileAnalysis, then call
        the createInstanceVariables, openInputFile, and writeOutputFiles methods.

        @param args String[] arguements
    */
    public void analyze(String[] arguements) {
        String inputText = "";
        // test number of command line arguements
        if (arguements.length != COMMAND_LINE_ARGUEMENTS) {
            System.out.println("Please enter the name of the input file.");
        } else {
            FileAnalysis fileAnalysis = new FileAnalysis();
            fileAnalysis.createInstanceVariables();
            fileAnalysis.openInputFile(arguements[0], inputText);
            fileAnalysis.writeOutputFiles(arguements[0]);
        }
    }
    /**
        This method instantiates the FileSummaryAnalyzer and DistinctTokensAnalyzer classes
    */
    public void createInstanceVariables() {
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }
    /**
        This method opens the input file with a buffered reader, reads the file,
        and adds each word to a string variable

        @param inputFilePath the name of the input file
        @param inputText the instance variable that will hold each string from the input file
    */
    public void openInputFile(String inputFilePath, String inputText) {
        try (BufferedReader input = new BufferedReader(new FileReader(inputFilePath))) {
            while (input.ready()) {
                inputText = input.readLine();
                generateTokens(inputText);
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    /**
        This method loops through the lines of input and generates indivdual tokens

        @param tokens the string passed down from the input file
    */
    public void generateTokens(String tokens) {
        String[] tokenArray = tokens.split("\\W+");
        for (String token : tokenArray) {
            passGeneratedTokens(token);
        }
    }
    /**
        This method passes all the generated tokens to all of the Analyzer instances
        via the processToken method

        @param tokens the generated tokens passed down
    */
    public void passGeneratedTokens(String tokens) {
        FileAnalysis fileAnalysis = new FileAnalysis();
        fileAnalysis.createInstanceVariables();
        summaryAnalyzer.processToken(tokens);
        distinctAnalyzer.processToken(tokens);
    }
    /**
        This method calls the generateOutputFile methods for each of
        the Analyzer isntances, as well as set the output file names for each
        specific generateOutputFile method.

        @param inputFilePath the name of the input file
    */
    public void writeOutputFiles(String inputFilePath) {
        String summaryFilePath = "summary.txt";
        String distinctTokensFilePath = "distinct_tokens.txt";
        FileAnalysis fileAnalysis = new FileAnalysis();
        fileAnalysis.createInstanceVariables();
        summaryAnalyzer.generateOutputFile(inputFilePath, summaryFilePath);
        distinctAnalyzer.generateOutputFile(inputFilePath, distinctTokensFilePath);
    }
}
