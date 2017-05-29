package by.gsu.epamlab;

import by.gsu.epamlab.util.DateConverterUtil;

import java.util.Calendar;

public class Result {
    public static final int ZERO = 0;
    public static final String STRING_MARK_REGEX = "%d.%d";
    public static final int MARK_BEFORE_POINT_INDEX = 0;
    public static final int MARK_AFTER_POINT_INDEX = 1;

    private Student student;
    private String testName;
    private Calendar date;
    private int mark;

    public Result(){
        this(null, null, null, ZERO);
    }

    public Result(Student student, String testName, Calendar date) {
        this(student, testName, date, ZERO);
    }

    public Result(Student student, String testName, Calendar date, int mark) {
        this.student = student;
        this.testName = testName;
        this.date = date;
        this.mark = mark;
    }

    public Result(Student student, String testName, Calendar date, String mark) {
        this(student, testName, date);
        setMark(mark);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public String getStringMark(){
        return String.format(STRING_MARK_REGEX, mark/10, mark%10);
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setMark(String mark){
        this.mark = getIntMark(mark);
    }

    private static int getIntMark(String stringMark){
        String[] mark = stringMark.split("\\.");
        return Integer.parseInt(mark[MARK_BEFORE_POINT_INDEX] + mark[MARK_AFTER_POINT_INDEX]);
    }

    @Override
    public String toString() {
        return student + ";" + testName + ";" + DateConverterUtil.getFormattedDate(date) + ";" + getStringMark();
    }
}
