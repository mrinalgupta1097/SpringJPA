package com.mrinalgupta.SpringJPA.repository;

import com.mrinalgupta.SpringJPA.entity.Guardian;
import com.mrinalgupta.SpringJPA.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("mrinalgupta1097@gmail.com")
                .firstName("Mrinal")
                .lastName("gupta")
//                .guardianName("Rajesh")
//                .guardianEmail("rajesh@gmail.com")
//                .guardianMobile("9876543210")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("mehak")
                .email("mehak@gmail.com")
                .mobile("9876543212")
                .build();
        Student student = Student.builder()
                .firstName("Madhav")
                .lastName("agarwal")
                .emailId("madhav@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        var allStudents = studentRepository.findAll();
        allStudents
                .forEach(System.out::println);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Mrinal");
        System.out.println(studentList.get(0).getGuardian());
    }

}