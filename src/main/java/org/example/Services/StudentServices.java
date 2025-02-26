package org.example.Services;

import org.example.Entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentServices {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        students.add(student);
    }

    // Cách 1: getById
    public Student getStudentById(long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Cách 2: getById
    public Optional<Student> getStudentByIdV2(long id) {
        return students
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    // Cách 1: update student
    public void updateStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        boolean found = false;
        for (int i = 0; i < students.size(); ++i) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Student with id " + student.getId() + " does not exist");
        }
    }

    // Cách 2: update student
    public void updateStudentV2(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        Optional<Student> existingStudent = getStudentByIdV2(student.getId());
        if (existingStudent.isPresent()) {
            students.set(students.indexOf(existingStudent.get()), student);
        } else {
            throw new IllegalArgumentException("Student with id " + student.getId() + " does not exist");
        }
    }

    // Cách 1: xóa student
    public boolean deleteStudent(long id) {
        for (int i = 0; i < students.size(); ++i) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    // Cách 2: xóa student
    public boolean deleteStudentV2(long id) {
        return students.removeIf(student -> student.getId() == id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
