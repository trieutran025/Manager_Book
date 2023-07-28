package com.example.managerbook.repository;

import com.example.managerbook.bean.Student;

import java.util.List;

public interface StudentRepoI {
    List<Student> findAllStudent();
    Student findByIDStudent(int idStudent);
}
