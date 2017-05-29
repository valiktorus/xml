package by.gsu.epamlab;

import javax.xml.soap.SAAJResult;

public enum ResultsEnum {
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
