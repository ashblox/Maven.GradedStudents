package io.zipcoder;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student() {
        firstName = "";
        lastName = "";
        examScores = new ArrayList<Double>();
    }

    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExamScores(ArrayList<Double> examScores) {
        this.examScores = examScores;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScoresAsString() {
        String examScoresAsString = "";
        if (examScores.size() != 0) {
            examScoresAsString = "Exam Scores:\n";
            for (int i = 0; i < examScores.size(); i++) {
                examScoresAsString += String.format("\tExam %d -> %.2f\n", i+1, examScores.get(i));
            }
        }
        return examScoresAsString.trim();
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int exam, double score) {
        examScores.set(exam - 1, score);
    }

    public Double getAverageExamScore() {
        Double average = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            average += examScores.get(i);
        }
        average = average/examScores.size();
        average = Math.round(average * 100)/100.0d;
        return average;
    }

    @Override
    public String toString() {
        String studentToString = String.format("Student Name: %s %s\n> Average Score: %.2f\n> %s",
                getFirstName(), getLastName(), getAverageExamScore(), getExamScoresAsString());
        return studentToString;
    }
}

