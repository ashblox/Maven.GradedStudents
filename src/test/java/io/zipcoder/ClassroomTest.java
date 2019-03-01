package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ClassroomTest {

    @Test
    public void nullaryConstructorTest() {
        // Given
        int expectedMaxNumberOfStudents = 30;

        // When
        Classroom classroom = new Classroom();

        // When
        Student[] actualStudents = classroom.getStudents();
        int actualMaxNumberOfStudents = classroom.getMaxNumberOfStudents();

        // Then
        Assert.assertTrue(actualStudents != null);
        Assert.assertEquals(expectedMaxNumberOfStudents, actualMaxNumberOfStudents);
    }

    @Test
    public void constructorWithMaxStudentsTest() {
        // Given
        int expectedMaxNumberOfStudents = 15;

        // When
        Classroom classroom = new Classroom(15);

        // When
        int actualMaxNumberOfStudents = classroom.getMaxNumberOfStudents();

        // Then
        Assert.assertTrue(classroom.getStudents() != null);
        Assert.assertEquals(expectedMaxNumberOfStudents, actualMaxNumberOfStudents);
    }

    @Test
    public void constructorWithStudentArrayTest() {
        // Given
        Student[] expectedStudents = {new Student(), new Student(), new Student()};
        int expectedMaxNumber = expectedStudents.length;

        // When
        Classroom classroom = new Classroom(expectedStudents);

        // When
        List<Student> actualStudents = Arrays.asList(classroom.getStudents());
        int actualMaxNumber = classroom.getMaxNumberOfStudents();

        // Then
        for (Student student: expectedStudents) {
            Assert.assertTrue(actualStudents.contains(student));
        }
        Assert.assertEquals(expectedMaxNumber, actualMaxNumber);
    }

    @Test
    public void getStudentsTest() {
        // Given
        Student[] expectedStudents = {new Student(), new Student(), new Student()};
        Classroom classroom = new Classroom(expectedStudents);

        // When
        List<Student> actualStudents = Arrays.asList(classroom.getStudents());

        // Then
        for (Student student: expectedStudents) {
            Assert.assertTrue(actualStudents.contains(student));
        }
    }

    @Test
    public void getMaxNumberOfStudentsTest() {
        // Given
        int expectedMaxNumber = 37;
        Classroom classroom = new Classroom(expectedMaxNumber);

        // When
        int actualMaxNumber = classroom.getMaxNumberOfStudents();

        // Then
        Assert.assertEquals(expectedMaxNumber, actualMaxNumber);
    }

    @Test
    public void getAverageExamScoreTest() {
        // Given
        Student student1 = new Student("", "", 0.67, 0.81, 0.87);
        Student student2 = new Student("", "", 0.82, 0.48);
        Student student3 = new Student("", "", 0.91, 0.67, 0.43, 0.45, 0.99);
        Double expectedAverage = 0.71;
        Classroom classroom = new Classroom(student1, student2, student3);

        // When
        Double actualAverage = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expectedAverage, actualAverage);
    }

    @Test
    public void addStudentTest() {
        // Given
        Classroom classroom = new Classroom(new Student(), new Student());
        Student studentToAdd = new Student("", "", 0.89);

        // When
        classroom.addStudent(studentToAdd);
        List<Student> actualStudents = Arrays.asList(classroom.getStudents());

        // Then
        Assert.assertTrue(actualStudents.contains(studentToAdd));
    }

    @Test
    public void removeStudentTest() {
        // Given
        String firstName = "firstName";
        String lastName = "lastName";
        Classroom classroom = new Classroom(new Student(firstName, lastName, new Double[4]));
        Student expected = null;

        // When
        classroom.removeStudent(firstName, lastName);

        // When
        Student actual = classroom.getStudents()[0];

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest1() {
        // Given
        Student student1 = new Student("Amanda", "Blake", 0.70, 0.80);
        Student student2 = new Student("Tommy", "Edwards", 0.55, 0.65);
        Student student3 = new Student ("Jose", "Antonio", 0.75, 0.75);
        Classroom classroom = new Classroom(student1, student2, student3);
        Student[] expectedStudents = {student3, student1, student2};

        // When
        Student[] actualStudents = classroom.getStudentsByScore();

        // Then
        Assert.assertTrue(Arrays.equals(expectedStudents, actualStudents));
    }

    @Test
    public void getStudentsByScoreTest2() {
        // Given
        Student student1 = new Student("Frank", "Jester", 0.67);
        Student student2 = new Student("Tony", "Hughes", 0.98);
        Student student3 = new Student("Chelsea", "McKinney", 0.78);
        Student student4 = new Student("Hyde", "Parker", 0.78);
        Student student5 = new Student("James", "Oscar", 0.78);
        Student student6 = new Student("George", "Jefferson", 0.67);
        Student student7 = new Student("Maria", "Ortiz", 0.98);
        Student student8 = new Student("Hank", "Hodges", 0.80);
        Student student9 = new Student("Mark", "Tony", 0.56);
        Student student10 = new Student("Jeffrey", "Adams", 0.99);
        Classroom classroom = new Classroom(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10);
        Student[] expectedStudents = {student10, student2, student7, student8, student3, student5, student4, student6, student1, student9};

        // When
        Student[] actualStudents = classroom.getStudentsByScore();

        // Then
        Assert.assertTrue(Arrays.equals(expectedStudents, actualStudents));
    }

    @Test
    public void getGradebookTest() {
        // Given
        Student student1 = new Student("Clara", "Dougherty", 0.45);
        Student student2 = new Student("Deborah", "Hammond", 0.79);
        Student student3 = new Student("Ryan", "Hyde", 0.67);
        Student student4 = new Student("Thomas", "Boulden", 0.97);
        Student student5 = new Student("Shauna", "Myers", 0.45);
        Classroom classroom = new Classroom(student1, student2, student3, student4, student5);
        Map<Student, String> expected = new LinkedHashMap<>();
        expected.put(student4, "A");
        expected.put(student2, "B");
        expected.put(student3, "C");
        expected.put(student1, "D");
        expected.put(student5, "D");

        // When
        Map<Student, String> actual = classroom.getGradebook();

        // Then
        Assert.assertEquals(expected.entrySet(),actual.entrySet());
    }

}
