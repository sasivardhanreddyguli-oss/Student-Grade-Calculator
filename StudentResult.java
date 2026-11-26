package com.example.gradecalculator;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class StudentResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private double subject1;
    private double subject2;
    private double subject3;
    private double total;
    private double average;
    private String grade;
    private LocalDateTime createdAt = LocalDateTime.now();

    public StudentResult() {}

    public StudentResult(String studentName, double subject1, double subject2, double subject3,
                         double total, double average, String grade) {
        this.studentName = studentName;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.total = total;
        this.average = average;
        this.grade = grade;
    }

    public Long getId() { return id; }
    public String getStudentName() { return studentName; }
    public double getSubject1() { return subject1; }
    public double getSubject2() { return subject2; }
    public double getSubject3() { return subject3; }
    public double getTotal() { return total; }
    public double getAverage() { return average; }
    public String getGrade() { return grade; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
