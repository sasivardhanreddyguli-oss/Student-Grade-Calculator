package com.example.gradecalculator;

import org.springframework.stereotype.Service;

@Service
public class GradeService {
    public String calculateGrade(double average) {
        if (average >= 90) return "A+";
        if (average >= 80) return "A";
        if (average >= 70) return "B";
        if (average >= 60) return "C";
        if (average >= 50) return "D";
        return "F";
    }

    public StudentResult createResult(String name, double m1, double m2, double m3) {
        double total = m1 + m2 + m3;
        double average = total / 3.0;
        return new StudentResult(name.trim(), m1, m2, m3, total,
                Math.round(average * 100.0) / 100.0, calculateGrade(average));
    }
}
