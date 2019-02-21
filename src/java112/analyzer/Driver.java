/**
    Class: DistinctTokensAnalyzer
    Author: Tom Good
    Create date: 2/16/2019
*/
package java112.analyzer;
/**
    This class instantiates the FileAnalysis class and calls its analyze method,
    sending the command line arguement made by the user.

    @author Tom Good
*/
public class Driver {
    /**
        This is the main class for the anaylzer folder, which instantiates
        and calls the analyze method of the FileAnalysis class.

        @param args command line arguements
    */
    public static void main(String[] args) {
        FileAnalysis fileAnalysis = new FileAnalysis();
        fileAnalysis.analyze(args);
    }
}
