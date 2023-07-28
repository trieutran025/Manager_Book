package com.example.managerbook.serrvice;

import com.example.managerbook.bean.Student;

import java.util.List;

public interface StudentServiceI {
    List<Student> findAllStudent();
    Student findByIDStudent(int idStudent);
}
