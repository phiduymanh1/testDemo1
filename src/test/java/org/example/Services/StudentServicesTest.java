package org.example.Services;

import org.example.Entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServicesTest {

    private StudentServices studentServices;


    @BeforeEach
    void setUp() {
        studentServices = new StudentServices();
    }

    @Test
    void addStudentWithValidStudent() {

        Student student = new Student(1, "Alicu",20,9.0);
        studentServices.addStudent(student);

        assertEquals(1,studentServices.getAllStudents().size());
    }

    @Test
    void addStudentWithNull(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentServices.addStudent(null));
        assertEquals("Student cannot be null",exception.getMessage());
    }

    @Test
    void addStudentWithInvalidName(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentServices.addStudent(new Student(1,"",20,9.0)));
        assertEquals("Name must not be null or empty",exception.getMessage());
    }
    @Test
    void addStudentWithInvalidAge(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentServices.addStudent(new Student(1,"Alicu",17,9.0)));
        assertEquals("Age must be greater than 18",exception.getMessage());
    }
    @Test
    void addStudentWithInvalidMark(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentServices.addStudent(new Student(1,"Alicu",18,13.0)));
        assertEquals("Mark must be between 0 and 10",exception.getMessage());
    }

    @Test
    void getStudentById() {
        Student student = new Student(1,"Alicu",20,9.0);
        studentServices.addStudent(student);
        assertEquals(student,studentServices.getStudentById(1));
    }
    @Test
    void getStudentByIdV2Nhe() {
        Student student = new Student(1,"Alicu",20,9.0);
        studentServices.addStudent(student);
        assertEquals(Optional.of(student),studentServices.getStudentByIdV2(1));
    }
    @Test
    void getStudentByIdWithInvalidId(){
        Student student = new Student(1,"Alicu",20,9.0);
        studentServices.addStudent(student);
//        assertEquals(student,studentServices.getStudentById(10));
//        assertEquals(Optional.of(student),studentServices.getStudentByIdV2(1));
        assertNull(studentServices.getStudentById(10));
        assertEquals(Optional.empty(),studentServices.getStudentByIdV2(10));
    }

    @Test
    void getStudentByIdV2() {
    }

    @Test
    void updateStudent() {
        Student student = new Student(1,"Alicu",20,9.0);
        studentServices.addStudent(student);

        student.setName("Vol cat");
        student.setAge(21);
        student.setMark(8.0);

        assertEquals("Vol cat",studentServices.getStudentById(1).getName());
        assertEquals(21,studentServices.getStudentById(1).getAge());
        assertEquals(8.0,studentServices.getStudentById(1).getMark());


    }

    @Test
    void updateStudentWithNull(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () ->studentServices.updateStudent(null));
        assertEquals("Student cannot be null",exception.getMessage());
    }

    @Test
    void updateStudentWithInvalidId(){
        Student student = new Student(1,"Alicu",20,9.0);
        studentServices.addStudent(student);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentServices.updateStudent(new Student(2,"Vol cat",21,8.0)));
        assertEquals("Student with id 2 does not exist",exception.getMessage());

        Exception exceptionV2 = assertThrows(IllegalArgumentException.class,
                () -> studentServices.updateStudentV2(new Student(2,"Vol cat",21,8.0)));
        assertEquals("Student with id 2 does not exist",exception.getMessage());
    }

    @Test
    void updateStudentWithInvalidName() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentServices.addStudent(student);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentServices.updateStudent(new Student(1, "", 20, 9.0)));
        assertEquals("Name must not be null or empty", exception.getMessage());
    }

    @Test
    void updateStudentWithInvalidAge() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentServices.addStudent(student);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentServices.updateStudent(new Student(1, "Alice", 17, 9.0)));
        assertEquals("Age must be greater than 18", exception.getMessage());
    }



    @Test
    void updateStudentV2() {
    }

    @Test
    void deleteStudent() {
        Student student = new Student(1,"Alicu",20,9.0);
        studentServices.addStudent(student);


        studentServices.deleteStudent(1);
        assertNull(studentServices.getStudentById(1));
    }

    @Test
    void deleteStudentV2() {
        Student student = new Student(1,"Alicu",20,9.0);
        studentServices.addStudent(student);

        studentServices.deleteStudentV2(1);
        assertEquals(0,studentServices.getAllStudents().size());
    }
    @Test
    void deleteStudentWithInavalidId(){
        Student student = new Student(1,"Alicu",20,9.0);
        studentServices.addStudent(student);

        assertFalse(studentServices.deleteStudent(10));
    }

    @Test
    void getAllStudents() {

    }
}