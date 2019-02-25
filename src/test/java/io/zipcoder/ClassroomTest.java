package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

}
