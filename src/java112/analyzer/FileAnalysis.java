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
        ArrayList<String> listOfTokens = new ArrayList();
        String line = null;
        // test number of command line arguements
        if (arguements.length != COMMAND_LINE_ARGUEMENTS) {
            System.out.println("Please enter the name of the input file.");
        } else {
            FileAnalysis fileAnalysis = new FileAnalysis();
            fileAnalysis.createInstanceVariables();
            fileAnalysis.openInputFile(arguements[0], listOfTokens);
            fileAnalysis.generateTokens(line, listOfTokens);
            fileAnalysis.passGeneratedTokens();
            fileAnalysis.writeOutputFiles();
        }
    }
    /**
        Create instance variables for FileSummaryAnalyzer and DistinctTokensAnalyzer

        @param args not used here
    */
    public void createInstanceVariables(){
        // instantiate instance variables
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }
    /**
        This method will open the input file with a buffered reader

        @param args String inputFilePath
    */
    public void openInputFile(String inputFilePath, ArrayList<String> listOfTokens) {
        try (BufferedReader input = new BufferedReader(new FileReader(inputFilePath))) {
            String line = null;
            while (input.ready()) {
                line = input.readLine();
                generateTokens(line, listOfTokens);
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
    public void generateTokens(String inputText, ArrayList<String> listOfTokens) {
        for (String tokens : listOfTokens) {
            tokens.add(inputText);
        }
    }
    /**
        This method will pass all the generated tokens to all of the Analyzer instances
        via the processToken method

        @param args
    */
    public void passGeneratedTokens() {
        DistinctTokensAnalyzer passTokens = new DistinctTokensAnalyzer();

    }
    /**
        This method will call the generateOutputFile methods of the Analyzer isntances

        @param args
    */
    public void writeOutputFiles() {

    }
}