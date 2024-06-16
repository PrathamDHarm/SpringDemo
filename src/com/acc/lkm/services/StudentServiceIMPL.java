package com.acc.lkm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.lkm.businessbean.StudentBean;
import com.acc.lkm.dao.StudentDAOWrapper;

@Service("studentServiceImpl")
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentDAOWrapper studentDAOWrapper;

    @Override
    public List<StudentBean> getAllStudentByYear(Integer year) {
        return studentDAOWrapper.getAllStudentDetailsByYear(year);
    }

    @Override
    @Transactional
    public void insertStudent(String name, Integer year, String branch) {
        studentDAOWrapper.insertStudentDetails(name, branch, year);
    }

    @Override
    @Transactional
    public void deleteStudentByName(String name) {
        studentDAOWrapper.deleteStudentsByName(name);
    }
}
