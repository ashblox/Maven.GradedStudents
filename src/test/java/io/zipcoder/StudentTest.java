package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {

    @Test
    public void nullaryConstructorTest() {
        // Given
        String givenFirstName = "";
        String givenLastName = "";
        ArrayList<Double> givenExamScores = new ArrayList<Double>();

        // When
        Student student = new Student();
        String retrievedFirstName = student.getFirstName();
        String retrievedLastName = student.getLastName();
        ArrayList<Double> retrievedExamScores = student.getExamScores();

        // Then
        Assert.assertEquals(givenFirstName, retrievedFirstName);
        Assert.assertEquals(givenLastName, retrievedLastName);
        Assert.assertEquals(givenExamScores, retrievedExamScores);
    }

    @Test
    public void constructorTest() {
        // Given student data
        String givenFirstName = "Debra";
        String givenLastName = "Johnson";
        ArrayList<Double> givenExamScores = new ArrayList<Double>();
        givenExamScores.add(0.87);
        givenExamScores.add(0.93);
        givenExamScores.add(0.91);

        // When a student is constructed with the given data
        Student student = new Student(givenFirstName, givenLastName, givenExamScores);
        String retrievedFirstName = student.getFirstName();
        String retrievedLastName = student.getLastName();
        ArrayList<Double> retrievedExamScores = student.getExamScores();

        // Then we expect the given data to match the retrieved data
        Assert.assertEquals(givenFirstName, retrievedFirstName);
        Assert.assertEquals(givenLastName, retrievedLastName);
        Assert.assertEquals(givenExamScores, retrievedExamScores);
    }

    @Test
    public void getFirstNameTest() {
        // Given
        String givenFirstName = "Anna";
        Student student = new Student(givenFirstName, "", new ArrayList<Double>());

        // When
        String retrievedFirstName = student.getFirstName();

        // Then
        Assert.assertEquals(givenFirstName, retrievedFirstName);
    }

    @Test
    public void getLastNameTest() {
        // Given
        String givenLastName = "Watson";
        Student student = new Student("", givenLastName, new ArrayList<Double>());

        // When
        String retrievedLastName = student.getLastName();

        // Then
        Assert.assertEquals(givenLastName, retrievedLastName);
    }

    @Test
    public void getExamScoresTest() {
        // Given
        ArrayList<Double> givenExamScores = new ArrayList<>();
        givenExamScores.add(0.71);
        givenExamScores.add(0.98);
        givenExamScores.add(0.84);
        Student student = new Student("", "", givenExamScores);

        // When
        ArrayList<Double> retrievedExamScores = student.getExamScores();

        // Then
        Assert.assertEquals(givenExamScores, retrievedExamScores);
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
        ArrayList<Double> givenExamScores = new ArrayList<>();
        givenExamScores.add(0.92);
        givenExamScores.add(0.94);
        givenExamScores.add(0.87);

        // When
        student.setExamScores(givenExamScores);

        // When
        ArrayList<Double> retrievedExamScores = student.getExamScores();

        // Then
        Assert.assertEquals(givenExamScores, retrievedExamScores);
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
        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(0.67);
        examScores.add(0.56);
        examScores.add(0.92);
        Student student = new Student("", "", examScores);
        Integer expected = 3;

        // When
        Integer actual = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoresAsStringTest1() {
        // Given
        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(0.70);
        examScores.add(0.65);
        examScores.add(0.89);
        Student student = new Student("", "", examScores);
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
        ArrayList<Double> expectedExamScores = new ArrayList<>();
        expectedExamScores.add(0.78);

        // When
        student.addExamScore(0.78);

        // When
        ArrayList<Double> actualExamScores = student.getExamScores();

        // Then
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }

    @Test
    public void addExamScoreTest2() {
        // Given
        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(0.93);
        examScores.add(0.89);
        Student student = new Student("", "", examScores);
        ArrayList<Double> expectedExamScores = new ArrayList<>();
        expectedExamScores.add(0.93);
        expectedExamScores.add(0.89);
        expectedExamScores.add(0.72);

        // When
        student.addExamScore(0.72);

        // When
        ArrayList<Double> actualExamScores = student.getExamScores();

        // Then
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }

    @Test
    public void setExamScoreTest() {
        // Given
        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(0.83);
        Student student = new Student("", "", examScores);
        Double expected = 0.91;

        // When
        student.setExamScore(1, 0.91);

        // When
        Double actual = student.getExamScores().get(0);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        // Given
        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(0.89);
        examScores.add(0.80);
        examScores.add(0.74);
        Student student = new Student("", "", examScores);
        Double expected = 0.81;

        // When
        Double actual = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        // Given
        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(0.94);
        examScores.add(0.89);
        examScores.add(0.93);
        Student student = new Student("Frank", "Carter", examScores);
        String expected = "Student Name: Frank Carter\n> Average Score: 0.92\n> Exam Scores:\n\t" +
                "Exam 1 -> 0.94\n\tExam 2 -> 0.89\n\tExam 3 -> 0.93";

        // When
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }
}