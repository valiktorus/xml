package by.gsu.epamlab;

import by.gsu.epamlab.util.DateConverterUtil;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ResultHandler extends DefaultHandler{
    private enum ResultsEnum {
        RESULTS("results"),
        STUDENT("student"),
        LOGIN("login"),
        TESTS("tests"),
        TEST("test"),
        NAME("name"),
        DATE("date"),
        MARK("mark");

        private String value;

        ResultsEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

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
        ResultsEnum temp = ResultsEnum.valueOf(localName.toUpperCase());
        switch (temp){
            case TEST:
                currentResult = new Result(currentStudent,
                        attributes.getValue(Constants.TEST_NAME_INDEX),
                        DateConverterUtil.getCalendarFromXML(attributes.getValue(Constants.DATE_INDEX)),
                        attributes.getValue(Constants.MARK_INDEX));
                results.add(currentResult);
                break;
            case LOGIN:
                currentEnum = temp;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (currentEnum == ResultsEnum.LOGIN){
            currentStudent = new Student(value);
            currentEnum = null;
        }
    }
}
