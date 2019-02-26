package io.zipcoder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student() {
        firstName = "";
        lastName = "";
        examScores = new ArrayList<>();
    }

    public Student(String firstName, String lastName, Double... examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (examScores != null) {
            this.examScores = new ArrayList<>(Arrays.asList(examScores));
        } else {
            this.examScores = new ArrayList<>();
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double[] getExamScores() {
        Double[] examScoresAsArray = new Double[examScores.size()];
        return examScores.toArray(examScoresAsArray);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExamScores(Double[] examScores) {
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public Double getSumOfAllExamScores() {
        Double sumOfExamScores = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            sumOfExamScores += examScores.get(i);
        }
        return sumOfExamScores;
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
        Double average = getSumOfAllExamScores()/examScores.size();
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

