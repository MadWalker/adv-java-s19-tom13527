package java112.analyzer;

/**
    This class will be the controller class for the analyzer project. It will
    call the methods found in the FileSummaryAnalyzer and DistinctTonkensAnalyzer.
    It will then display the output of both classes.

    @author Tom Good
*/
public class FileAnalysis {
    // Declare constant
    const COMMAND_LINE_ARGUEMENTS = 1;

    // Declare instance variables
    FileSummaryAnalyzer summaryAnalyzer;
    DistinctTokensAnalyzer distinctAnalyzer;

    /**
        This method will test to make sure there are the correct number of command-line
        arguements. It will then loop through an input file and run their analyze
        methods

        @param args String[] arguements
    */
    public void analyz(String[] arguements) {

        // test number of command line arguements
        if (arguements.length != COMMAND_LINE_ARGUEMENTS) {
            System.out.println("Please enter the name of the input file.")
        } else {

        }
    }
}
