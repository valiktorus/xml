package by.gsu.epamlab;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultHandler extends DefaultHandler{
    List<Result> results;
    private Result currentResult = null;
    private Student currentStudent = null;
    private ResultsEnum currentEnum = null;

    public ResultHandler() {
        results = new ArrayList<>();
    }

    public List<Result> getResults() {
        return results;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("test".equals(localName)){
            currentResult = new Result(currentStudent, attributes.getValue(0), new Date(attributes.getValue(1)), attributes.getValue(2));
        }else {
            ResultsEnum temp = ResultsEnum.valueOf(localName.toUpperCase());
            if (ResultsEnum.LOGIN == temp){
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("test".equals(localName)){
            results.add(currentResult);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (currentEnum != null){
            currentStudent = new Student(value);
        }
    }
}
