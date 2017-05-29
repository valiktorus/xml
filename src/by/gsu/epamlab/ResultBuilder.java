package by.gsu.epamlab;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class ResultBuilder {
    private List<Result> results;
    private ResultHandler resultHandler;
    private XMLReader reader;

    public ResultBuilder() {
        resultHandler = new ResultHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.err.println("SAX parser error" + e.getMessage());;
        }
        reader.setContentHandler(resultHandler);
    }

    public List<Result> getResults() {
        return results;
    }

    public ResultBuilder(List<Result> results) {
        this.results = results;
    }

    public void buildListResults(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            System.err.println("Error in I/O " + e.getMessage());
        } catch (SAXException e) {
            System.err.println("Error of SAX parser " + e.getMessage());
        }
        results = resultHandler.getResults();
    }
}
