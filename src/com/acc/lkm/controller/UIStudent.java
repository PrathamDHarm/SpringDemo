package com.acc.lkm.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acc.lkm.businessbean.StudentBean;
import com.acc.lkm.services.StudentService;

public class UIStudent {
    public static void main(String args[]) {
        StudentService studentServiceIMPL = null;
        try {
            @SuppressWarnings("resource")
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/acc/lkm/resources/cst_main_config.xml");
            studentServiceIMPL = (StudentService) applicationContext.getBean("studentServiceImpl");
            
//            insertStudentDetails(studentServiceIMPL);
            getAllStudentDetails(studentServiceIMPL);
//            deleteStudentDetails(studentServiceIMPL);
            
        } catch (Exception e) {
            System.out.println("Exception in main method: " + e.getMessage());
        }
    }

    public static void insertStudentDetails(StudentService serviceIMPL) {
        try {
            serviceIMPL.insertStudent("John Doe", 2024, "Computer Science");
            System.out.println("Student inserted successfully.");
        } catch (Exception ex) {
            System.out.println("Exception while inserting student: " + ex.getMessage());
        }
    }

    public static void getAllStudentDetails(StudentService serviceImpl) {
        try {
            List<StudentBean> listStudentBean = serviceImpl.getAllStudentByYear(2018);
            System.out.println("Students enrolled in 2018:");
            for (StudentBean sb : listStudentBean) {
                System.out.println("Name: " + sb.getStudent_name() + ", Year: " + sb.getYear_of_joining() + ", Branch: " + sb.getStudent_branch());
            }
        } catch (Exception e) {
            System.out.println("Exception while getting students: " + e.getMessage());
        }
    }

    public static void deleteStudentDetails(StudentService serviceImpl) {
        try {
            serviceImpl.deleteStudentByName("John Doe");
            System.out.println("Student 'John Doe' deleted successfully.");
        } catch (Exception e) {
            System.out.println("Exception while deleting student: " + e.getMessage());
        }
    }
}
