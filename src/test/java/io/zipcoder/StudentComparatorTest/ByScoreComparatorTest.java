package io.zipcoder.StudentComparatorTest;

import io.zipcoder.Student;
import io.zipcoder.StudentComparators.ByScoreComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class ByScoreComparatorTest {

    @Test
    public void sortStudents1() {
        // Given
        Student student1 = new Student("Abby", "Marshall", 0.87, 0.98, 0.97);
        Student student2 = new Student("Nancy", "Dobbs", 0.67, 0.87, 0.76);
        Comparator<Student> compareStudents = new ByScoreComparator();

        // When
        int indexAdjustment = compareStudents.compare(student1, student2);

        // Then
        Assert.assertTrue(indexAdjustment < 0);
    }

    @Test
    public void sortStudents2() {
        // Given
        Student student1 = new Student("Abby", "Marshall", 0.87, 0.98, 0.97);
        Student student2 = new Student("Nancy", "Dobbs", 0.87, 0.98, 0.97);
        Comparator<Student> compareStudents = new ByScoreComparator();

        // When
        int indexAdjustment = compareStudents.compare(student1, student2);

        // Then
        Assert.assertTrue(indexAdjustment > 0);
    }
}
