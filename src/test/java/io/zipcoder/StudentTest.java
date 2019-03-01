package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentTest {

    @Test
    public void nullaryConstructorTest() {
        // Given
        String givenFirstName = "";
        String givenLastName = "";
        Double[] givenExamScores = {};

        // When
        Student student = new Student();
        String retrievedFirstName = student.getFirstName();
        String retrievedLastName = student.getLastName();
        List<Double> retrievedExamScores = Arrays.asList(student.getExamScores());

        // Then
        Assert.assertEquals(givenFirstName, retrievedFirstName);
        Assert.assertEquals(givenLastName, retrievedLastName);
        for(Double examScore: givenExamScores) {
            Assert.assertTrue(retrievedExamScores.contains(examScore));
        }
    }

    @Test
    public void constructorTest() {
        // Given student data
        String givenFirstName = "Debra";
        String givenLastName = "Johnson";
        Double[] givenExamScores = {0.91, 0.86, 0.93};

        // When a student is constructed with the given data
        Student student = new Student(givenFirstName, givenLastName, givenExamScores);
        String retrievedFirstName = student.getFirstName();
        String retrievedLastName = student.getLastName();
        List<Double> retrievedExamScores = Arrays.asList(student.getExamScores());

        // Then we expect the given data to match the retrieved data
        Assert.assertEquals(givenFirstName, retrievedFirstName);
        Assert.assertEquals(givenLastName, retrievedLastName);
        for(Double examScore: givenExamScores) {
            Assert.assertTrue(retrievedExamScores.contains(examScore));
        }
    }

    @Test
    public void getFirstNameTest() {
        // Given
        String givenFirstName = "Anna";
        Student student = new Student(givenFirstName, "", null);

        // When
        String retrievedFirstName = student.getFirstName();

        // Then
        Assert.assertEquals(givenFirstName, retrievedFirstName);
    }

    @Test
    public void getLastNameTest() {
        // Given
        String givenLastName = "Watson";
        Student student = new Student("", givenLastName, null);

        // When
        String retrievedLastName = student.getLastName();

        // Then
        Assert.assertEquals(givenLastName, retrievedLastName);
    }

    @Test
    public void getExamScoresTest() {
        // Given
        Double[] givenExamScores = {0.67, 0.98, 0.87};
        Student student = new Student("", "", givenExamScores);

        // When
        List<Double> retrievedExamScores = Arrays.asList(student.getExamScores());

        // Then
        for (Double examScore: givenExamScores) {
            Assert.assertTrue(retrievedExamScores.contains(examScore));
        }
    }

    @Test
    public void setFirstNameTest() {
        // Given
        Student student = new Student("Charlie", "", null);
        String givenFirstName = "David";

        // When
        student.setFirstName(givenFirstName);

        // When
        String retrievedFirstName = student.getFirstName();

        // Then
        Assert.assertEquals(givenFirstName, retrievedFirstName);
    }

    @Test
    public void setLastNameTest() {
        // Given
        Student student = new Student("", "Smith", null);
        String givenLastName = "Johnson";

        // When
        student.setLastName(givenLastName);

        // When
        String retrievedLastName = student.getLastName();

        // Then
        Assert.assertEquals(givenLastName, retrievedLastName);
    }

    @Test
    public void setExamScores() {
        // Given
        Student student = new Student("", "", null);
        Double[] givenExamScores = {0.56, 0.78, 0.74};

        // When
        student.setExamScores(givenExamScores);

        // When
        List<Double> retrievedExamScores = Arrays.asList(student.getExamScores());

        // Then
        for (Double examScore: givenExamScores) {
            Assert.assertTrue(retrievedExamScores.contains(examScore));
        }
    }

    @Test
    public void getNumberOfExamsTaken1() {
        // Given
        Student student = new Student();
        Integer expected = 0;

        // When
        Integer actual = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTaken2() {
        // Given
        Student student = new Student("", "", 0.78, 0.98, 0.97);
        Integer expected = 3;

        // When
        Integer actual = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSumOfExamScoresTest() {
        // Given
        Student student = new Student("","", 0.91, 0.93, 0.87);
        Double expectedSum = 0.91 + 0.93 + 0.87;

        // When
        Double actualSum = student.getSumOfAllExamScores();

        // Then
        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void getExamScoresAsStringTest1() {
        // Given
        Student student = new Student("", "", 0.70, 0.65, 0.89);
        String expected = "Exam Scores:\n\tExam 1 -> 0.70\n\tExam 2 -> 0.65\n\tExam 3 -> 0.89";

        // When
        String actual = student.getExamScoresAsString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoresAsStringTest2() {
        // Given
        Student student = new Student();
        String expected = "";

        // When
        String actual = student.getExamScoresAsString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest1() {
        // Given
        Student student = new Student();
        Double[] expectedExamScores = {0.78};
        // When
        student.addExamScore(0.78);

        // When
        List<Double> actualExamScores = Arrays.asList(student.getExamScores());

        // Then
        for (Double examScore: expectedExamScores) {
            Assert.assertTrue(actualExamScores.contains(examScore));
        }
    }

    @Test
    public void addExamScoreTest2() {
        // Given
        Student student = new Student("", "", 0.93, 0.89);
        Double[] expectedExamScores = {0.93, 0.89, 0.72};

        // When
        student.addExamScore(0.72);

        // When
        List<Double> actualExamScores = Arrays.asList(student.getExamScores());

        // Then
        for (Double examScore: expectedExamScores) {
            Assert.assertTrue(actualExamScores.contains(examScore));
        }
    }

    @Test
    public void setExamScoreTest() {
        // Given
        Student student = new Student("", "", 0.83);
        Double expected = 0.91;

        // When
        student.setExamScore(1, 0.91);

        // When
        Double actual = student.getExamScores()[0];

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        // Given
        Student student = new Student("", "", 0.89, 0.80, 0.74);
        Double expected = 0.81;

        // When
        Double actual = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        // Given
        Student student = new Student("Frank", "Carter", 0.94, 0.89, 0.93);
        String expected = "Student Name: Frank Carter\n> Average Score: 0.92\n> Exam Scores:\n\t" +
                "Exam 1 -> 0.94\n\tExam 2 -> 0.89\n\tExam 3 -> 0.93";

        // When
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isGradeAnATest () {
        // Given
        Double examScore = 0.98;
        Student student = new Student("", "", examScore);

        // When
        Boolean isGradeAnA = student.isGradeAnA(examScore);

        // Then
        Assert.assertTrue(isGradeAnA);
    }

    @Test
    public void isGradeABTest () {
        // Given
        Double examScore = 0.75;
        Student student = new Student("", "", examScore);

        // When
        Boolean isGradeAB = student.isGradeAB(examScore);

        // Then
        Assert.assertTrue(isGradeAB);
    }

    @Test
    public void isGradeACTest () {
        // Given
        Double examScore = 0.63;
        Student student = new Student("", "", examScore);

        // When
        Boolean isGradeAC = student.isGradeAC(examScore);

        // Then
        Assert.assertTrue(isGradeAC);
    }

    @Test
    public void isGradeADTest () {
        // Given
        Double examScore = 0.43;
        Student student = new Student("", "", examScore);

        // When
        Boolean isGradeAD = student.isGradeAD(examScore);

        // Then
        Assert.assertTrue(isGradeAD);
    }

    @Test
    public void isGradeAnFTest () {
        // Given
        Double examScore = 0.09;
        Student student = new Student("", "", examScore);

        // When
        Boolean isGradeAnF = student.isGradeAnF(examScore);

        // Then
        Assert.assertTrue(isGradeAnF);
    }

    @Test
    public void getAverageGradeTest() {
        // Given
        Double examScore = 0.78;
        Student student = new Student("", "", examScore);
        String expected = "B";

        // When
        String actual = student.getAverageGrade();

        // Then
        Assert.assertEquals(expected, actual);
    }
}