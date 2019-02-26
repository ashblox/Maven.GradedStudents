package io.zipcoder.StudentComparators;

import io.zipcoder.Student;

import java.util.Comparator;

public class ByScoreComparator implements Comparator<Student> {

    public int compare(Student a, Student b) {
        int indexAdjustment =  b.getAverageExamScore().compareTo(a.getAverageExamScore());
        if (indexAdjustment == 0) {
            indexAdjustment = a.getLastName().compareTo(b.getLastName());
        }
        return indexAdjustment;
    }
}
