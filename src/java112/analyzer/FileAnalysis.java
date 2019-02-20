package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    This class will be the controller class for the analyzer project. It will
    call the methods found in the FileSummaryAnalyzer and DistinctTonkensAnalyzer.
    It will then display the output of both classes.

    @author Tom Good
*/
public class FileAnalysis {
    // Declare constant
    final int COMMAND_LINE_ARGUEMENTS = 1;
    // Declare instance variables
    FileSummaryAnalyzer summaryAnalyzer;
    DistinctTokensAnalyzer distinctAnalyzer;
    /**
        This method will test to make sure there are the correct number of command-line
        arguements. It will then loop through an input file and run their analyze
        methods

        @param args String[] arguements
    */
    public void analyze(String[] arguements) {
        String inputText = "";
        String summaryFilePath = "summary.txt";
        String distinctTokensFilePath = "distinct_tokens.txt";
        // test number of command line arguements
        if (arguements.length != COMMAND_LINE_ARGUEMENTS) {
            System.out.println("Please enter the name of the input file.");
        } else {
            FileAnalysis fileAnalysis = new FileAnalysis();
            fileAnalysis.createInstanceVariables();
            fileAnalysis.openInputFile(arguements[0], inputText);
            fileAnalysis.generateTokens(inputText);
            fileAnalysis.passGeneratedTokens(inputText);
            fileAnalysis.writeOutputFiles(arguements[0], summaryFilePath, distinctTokensFilePath);
        }
    }
    /**
        Create instance variables for FileSummaryAnalyzer and DistinctTokensAnalyzer

        @param args not used here
    */
    public void createInstanceVariables() {
        // instantiate instance variables
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }
    /**
        This method will open the input file with a buffered reader

        @param args String inputFilePath
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
        This method will loop through the lines of input and generate indivdual tokens

        @param args BufferedReader input
    */
    public void generateTokens(String tokens) {
        String[] tokenArray = tokens.split("\\W+");
        int i = 0;
        for (i=0; i < tokenArray.length; i++) {
            System.out.println("Correct tokens: " + tokenArray[i]);
        }
        for (String token : tokenArray) {
            passGeneratedTokens(token);
            /**
                FIX THE TWO SPACES ADDED TO ARRAY
            */
            System.out.println("Incorrect tokens: " + token);
        }
    }
    /**
        This method will pass all the generated tokens to all of the Analyzer instances
        via the processToken method

        @param args
    */
    public void passGeneratedTokens(String tokens) {
        FileAnalysis fileAnalysis = new FileAnalysis();
        fileAnalysis.createInstanceVariables();
        summaryAnalyzer.processToken(tokens);
        distinctAnalyzer.processToken(tokens);
    }
    /**
        This method will call the generateOutputFile methods of the Analyzer isntances

        @param args
    */
    public void writeOutputFiles(String inputFilePath, String summaryFilePath, String distinctTokensFilePath) {
        FileAnalysis fileAnalysis = new FileAnalysis();
        fileAnalysis.createInstanceVariables();
        summaryAnalyzer.generateOutputFile(inputFilePath, summaryFilePath);
        distinctAnalyzer.generateOutputFile(inputFilePath, distinctTokensFilePath);
    }
}
