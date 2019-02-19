package java112.analyzer;
/**
    This class will instantiate the and run the FileAnalysis class found within
    the analyzer folder.

    @author Tom Good
*/
public class Driver {
    /**
        This is the main class for the anaylzer folder, which will instantiate
        and call the run method of the FileAnalysis class.

        @param args command line arguements
    */
    public static void main(String[] args) {
        FileAnalysis fileAnalysis = new FileAnalysis();
        fileAnalysis.analyze(args);
    }
}
