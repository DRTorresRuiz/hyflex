/**
 * @author David Omrai
 */

package hyflex.chesc2011.metrics;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ResultsCardHandler {
  /**
   * Method reads the results file and stores the data into a map.
   * @param path Path where the file is stored.
   * @return Map with algorithm results.
   */
  public static ResultsCard loadCard(
      String[] problems, Path path, String[] domains, Map<String, List<String>> cardInstances)
      throws Exception {
    String cardName = path.getFileName().toString();
    ResultsCard result = new ResultsCard(
        cardName.substring(0, cardName.lastIndexOf(".")), domains);

    Scanner scanner = new Scanner(new File(path.toString())).useDelimiter("\n");

    for (String problemId : problems) {
      
      if (scanner.hasNextLine() == false) {
        scanner.close();
        System.out.println("Not enough lines in " + path.toString() + " file.");
        return null;
      }

      Scanner line = new Scanner(scanner.nextLine()).useDelimiter(", ");

      for (String instanceId: cardInstances.get(problemId)) {

        if (line.hasNextLine() == false) {
          line.close();
          System.out.println("Not enough instances results in " + path.toString() + " file.");
          return null;
        }
        
        result.putInstanceValue(problemId, instanceId, Double.parseDouble(line.next()));
      }

      line.close();
    }
    scanner.close();

    return result;
  }


  /**
   * Method returns the array of cards names.
   * @param path Path to the results cards.
   * @return Returns the array of algorithms results file names..
   */
  public static String[] getCardsNames(Path path) {
    File resDir = new File(path.toString());

    String[] resFiles = resDir.list(new FilenameFilter() {
      @Override
      public boolean accept(File current, String name) {
        return new File(current, name).isFile();
      }
    });

    return resFiles;
  }


  /**
   * Method stored the results inside xml file.
   * @param results Map with results.
   */
  public static void saveResultsToXmlFile(
      String resultsXmlFile, List<ResultsCard> results) 
      throws Exception {
    DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
    Document document = documentBuilder.newDocument();

    // root element
    Element root = document.createElement("results");
    document.appendChild(root);

    for (ResultsCard resultCard: results) {
      Element algorithm = document.createElement("algorithm");
      algorithm.setAttribute("name", resultCard.getName());
      algorithm.setAttribute("score", Double.toString(resultCard.getScore()));

      for (String problemId: resultCard.getProblems()) {
        Element problem = document.createElement("problem");
        problem.setAttribute("name", problemId);

        
        for (String instanceId: resultCard.getInstances(problemId)) {
          Element instance = document.createElement("instance");

          instance.setAttribute(
              instanceId, 
              Double.toString(resultCard.getInstanceScore(problemId, instanceId))
          );
          
          problem.appendChild(instance);
        }

        problem.setAttribute(
            "avg", Double.toString(resultCard.getProblemScore(problemId)));
        algorithm.appendChild(problem);
      }

      root.appendChild(algorithm);
    }

    // create the xml file
    //transform the DOM Object to an XML File
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource domSource = new DOMSource(document);
    StreamResult streamResult = new StreamResult(new File(resultsXmlFile));

    transformer.transform(domSource, streamResult);
  }
}
