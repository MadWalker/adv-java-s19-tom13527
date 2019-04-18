/**
    Class: TokenLengthsAnalyzer
    Author: Tom Good
    Create date: 3/16/2019
*/
package java112.analyzer;
import java.io.*;
import java.util.*;
/**
    Description:    This class, which implements the interface TokenAnalyzer,
    will determine the location of certain tokens within a map and display each
    location that said token shows up to a file

    @author Tom Good
*/
public class TokenLocationSearchAnalyzer implements TokenAnalyzer {
    /**
        Constructor with one Properties parameter

        @param properties file path passed own
    */
    public TokenLocationSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        String classDefPath = properties.getProperty("classpath.search.tokens");
        String inputText;
        try (
            InputStream inputStream = this.getClass().getResourceAsStream(classDefPath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader searchTokensReader = new BufferedReader(inputStreamReader)) {
            while (searchTokensReader.ready()) {
                inputText = searchTokensReader.readLine();
                if (inputText != null && inputText.length() > 0) {
                    foundLocations.put(inputText, new ArrayList<Integer>());
                }
            }
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    // Empty constructor
    public TokenLocationSearchAnalyzer() {

    }
    // Declare instance variables
    private Properties properties;
    private Map<String, List<Integer>> foundLocations = new TreeMap<String, List<Integer>>();
    private int currentTokenLocation = 1;
    /**
        Get method for foundLocations

        @return foundLocations
    */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }

    /**
        This method will go through each token passed down and if it is within
        the map foundLocations, add the current location of the token to the
        value list of the map

        @param token each token sent from the input file
    */
    public void processToken(String token) {
        if (foundLocations.containsKey(token)) {
            foundLocations.get(token).add(currentTokenLocation);
        }
        currentTokenLocation += 1;
    }
    /**
        This method takes in the information gathered by the processToken method
        , which is the distinct token and the number of times that token shows up,
        and displays it to a new file.

        @param inputFilePath sends the name of the inputfile
    */
    public void generateOutputFile(String inputFilePath) {
        String outputPath = properties.getProperty("output.directory");
        String outputFile = properties.getProperty("output.file.token.search.locations");

        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputPath + outputFile)))
        )
        {
            for (Map.Entry<String, List<Integer>> map : foundLocations.entrySet()) {
                output.println(map.getKey() + " =");
                //StringBuilder sb = new StringBuilder("[");
                // Append all Integers in StringBuilder to the StringBuilder.
                /**for (int tokenLocations : map.getValue()) {
                    sb.append(tokenLocations);
                    sb.append(", ");
                }
                // Remove last delimiter with setLength.
                sb.setLength(sb.length() - 1);
                sb.append("]");
                output.println(sb.toString());
                */
                StringBuilder listString = new StringBuilder("[");
                //for (Integer list: map.getValue()) {
                for (int i = 0; i < map.getValue().size(); i++) {
                    //output.println(map.getValue().toString() + "\n");
                    if (map.getValue().size() == 1) {
                        listString.append(map.getValue().get(i));
                    } else if (i == 0) {
                        listString.append(map.getValue().get(i) + ",");
                    } else if (i == map.getValue().size() - 1) {
                        listString.append(" " + map.getValue().get(i));
                    } else {
                        listString.append(" " + map.getValue().get(i) + ",");
                    }
                }
                //String wrapped = listString.replaceAll("(?<=\\G.{79})", "\n");
                //output.println("[" + wrapped + "]\n");
                output.println(listString.toString() + "]");
            }

        }
            catch (FileNotFoundException fileNotFound)
            {
                fileNotFound.printStackTrace();
            }
            catch (IOException inputOutputException)
            {
                inputOutputException.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
    }
}
