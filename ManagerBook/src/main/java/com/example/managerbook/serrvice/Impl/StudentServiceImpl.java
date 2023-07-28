package com.example.managerbook.serrvice.Impl;

import com.example.managerbook.bean.Student;
import com.example.managerbook.repository.StudentRepoI;
import com.example.managerbook.repository.impl.StudentRepoImpl;
import com.example.managerbook.serrvice.StudentServiceI;

import java.util.List;

public class StudentServiceImpl implements StudentServiceI {
    StudentRepoI studentRepoI = new StudentRepoImpl();
    @Override
    public List<Student> findAllStudent() {
        return studentRepoI.findAllStudent();
    }

    @Override
    public Student findByIDStudent(int idStudent) {
        return studentRepoI.findByIDStudent(idStudent);
    }
}
