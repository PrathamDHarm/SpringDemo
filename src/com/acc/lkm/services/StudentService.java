package com.acc.lkm.services;

import java.util.List;

import com.acc.lkm.businessbean.StudentBean;

public interface StudentService {
    
    List<StudentBean> getAllStudentByYear(Integer year);
    
    void insertStudent(String name, Integer year, String branch);
    
    void deleteStudentByName(String name);
}
