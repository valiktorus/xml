import by.gsu.epamlab.Result;
import by.gsu.epamlab.ResultBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        ResultBuilder builder = new ResultBuilder();
        builder.buildListResults(GeneralConstants.fileName);
        List<Result> results = builder.getResults();
        printList(results);
    }

    private static <E> void printList(List<E> list){
        for (E element : list) {
            System.out.println(element);
        }
    }
}
