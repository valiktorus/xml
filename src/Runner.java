import by.gsu.epamlab.Result;
import by.gsu.epamlab.ResultBuilder;
import by.gsu.epamlab.ResultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        ResultBuilder builder = new ResultBuilder();
        builder.buildListResults("src/results.xml");
        List<Result> results = builder.getResults();
        for (Result result: results) {
            System.out.println(result);
        }
    }
}
