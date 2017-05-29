package by.gsu.epamlab;

import java.util.Date;

public class Result {
    private final Student student;
    private final String testName;
    private final Date date;
    private final int mark;

    public Result(Student student, String testName, Date date, int mark) {
        this.student = student;
        this.testName = testName;
        this.date = date;
        this.mark = mark;
    }

    public Result(Student student, String testName, Date date, String mark) {
        this.student = student;
        this.testName = testName;
        this.date = date;
        this.mark = Integer.parseInt(mark);
    }

    private static int getIntMark(String StringMark){
        String[] mark = StringMark.split(",");
        return Integer.parseInt(mark[0] + mark[1]);
    }

    @Override
    public String toString() {
        return student + ";" + testName + ";" + date + ";" + mark;
    }
}
