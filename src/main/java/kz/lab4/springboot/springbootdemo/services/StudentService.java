package kz.lab4.springboot.springbootdemo.services;

import kz.lab4.springboot.springbootdemo.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    private long idCounter = 1;

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(Student student) {
        student.setId(idCounter++);
        student.setMark(calculateMark(student.getExam()));

        students.add(student);
    }

    private String calculateMark(int examscore) {
        if (examscore >= 90) return "A";
        if (examscore >= 75) return "B";
        if (examscore >= 60) return "C";
        if (examscore >= 50) return "D";
        return "F";

    }
}
