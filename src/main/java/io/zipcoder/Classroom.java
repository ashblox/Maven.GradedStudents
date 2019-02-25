package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Classroom {

    private ArrayList<Student> students;
    private int maxNumberOfStudents;

    public Classroom() {
        this.maxNumberOfStudents = 30;
        this.students = new ArrayList<>(30);
    }

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        students = new ArrayList<>();
    }

    public Classroom(Student... students) {
        if (students != null) {
            this.students = new ArrayList<>(Arrays.asList(students));
        } else {
            this.students = new ArrayList<>();
        }
        this.maxNumberOfStudents = students.length;
    }

    public Student[] getStudents() {
        Student[] studentArray = new Student[students.size()];
        return students.toArray(studentArray);
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        System.out.println(classroom.getStudents().length);
    }
}

