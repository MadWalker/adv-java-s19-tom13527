/**
    Class: TokenLocationSearchAnalyzer
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
                StringBuilder listString = new StringBuilder("[");
                int lastNewLine = 0;
                // loop through the map values
                for (int listCounter = 0; listCounter < map.getValue().size(); listCounter++) {
                    // output for a single location
                    if (map.getValue().size() == 1) {
                        listString.append(map.getValue().get(listCounter));
                    // output for the first location
                } else if (listCounter == 0) {
                        listString.append(map.getValue().get(listCounter) + ", ");
                    // output for the final location
                } else if (listCounter == map.getValue().size() - 1) {
                        listString.append(map.getValue().get(listCounter));
                    // new line after 80 characters
                    } else if (listString.length() - lastNewLine > 70) {
                        listString.append(map.getValue().get(listCounter) + ",\n");
                        lastNewLine = listString.length();
                    // output for middle locations
                    } else {
                        listString.append(map.getValue().get(listCounter) + ", ");
                    }
                }
                output.println(listString.toString() + "]\n");
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
