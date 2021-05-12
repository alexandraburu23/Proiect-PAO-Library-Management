package models;

import java.time.LocalDate;
import java.util.Objects;

public class Student extends Reader{
    private String university;

    public Student(){
        super(0,"",null);
        this.university="";
    }
    public Student(int id, String name, String university) {
        super(id, name);
        this.university = university;
    }

    public Student(int id, String name, LocalDate registrationDate, String university) {
        super(id, name, registrationDate);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String readerType(){
        return "Student";
    }

    public String toString() {
        return id + "," + name + "," + registrationDate + "," + university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return university.equals(student.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university);
    }
}
