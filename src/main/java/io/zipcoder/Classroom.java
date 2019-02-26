package io.zipcoder;

import io.zipcoder.StudentComparators.ByScoreComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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
        studentArray =  students.toArray(studentArray);
        if (studentArray.length == 0) {
            studentArray = new Student[1];
        }
        return studentArray;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public Double getAverageExamScore() {
        Double sumOfAllExamScores = 0.0;
        int totalNumberOfExams = 0;
        for (int i = 0; i < students.size(); i++) {
            sumOfAllExamScores += students.get(i).getSumOfAllExamScores();
            totalNumberOfExams += students.get(i).getNumberOfExamsTaken();
        }
        Double averageExamScore = sumOfAllExamScores/totalNumberOfExams;
        return Math.round(averageExamScore * 100)/100.0d;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)) {
                students.remove(students.get(i));
            }
        }
    }

    public Student[] getStudentsByScore() {
        Comparator<Student> compareStudents = new ByScoreComparator();
        students.sort(compareStudents);
        Student[] sortedStudents = new Student[students.size()];
        sortedStudents = students.toArray(sortedStudents);
        return sortedStudents;
    }


}

