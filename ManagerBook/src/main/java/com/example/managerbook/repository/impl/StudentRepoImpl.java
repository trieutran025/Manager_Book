package com.example.managerbook.repository.impl;

import com.example.managerbook.bean.Student;
import com.example.managerbook.repository.StudentRepoI;
import com.example.managerbook.util.Constants;
import com.example.managerbook.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepoImpl implements StudentRepoI {
    @Override
    public List<Student> findAllStudent() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_STUDENT)) {
            ResultSet resultSet =statement.executeQuery();
            Student student;
            while (resultSet.next()) {
                int idStudent = resultSet.getInt("id_Student");
                String codeStudent = resultSet.getString("code_Student");
                String nameStudent = resultSet.getString("name_student");
                String classStudent = resultSet.getString("class_Student");

                student = new Student(idStudent, codeStudent,nameStudent, classStudent);
                students.add(student);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Student findByIDStudent(int idStudent) {
        Student student=null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement  = connection.prepareStatement(Constants.FIND_BY_ID_STUDENT)) {
            statement.setInt(1, idStudent);
            ResultSet resultSet =statement.executeQuery();
            if(resultSet.next()){
                String codeStudent = resultSet.getString("code_student");
                String nameStudent = resultSet.getString("name_student");
                String classStudent = resultSet.getString("class_Student");
                student = new Student(idStudent,codeStudent, nameStudent, classStudent);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
