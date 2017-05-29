package by.gsu.epamlab;

public class Student {
    private final String login;

    public Student(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return login;
    }

}
