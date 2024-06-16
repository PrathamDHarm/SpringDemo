package com.acc.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acc.lkm.businessbean.StudentBean;
import com.acc.lkm.entity.StudentEntity;

@Repository
@SuppressWarnings("res")
public class StudentDAOWrapper {
    
    @Autowired
    private StudentDAO studentDAO;
    
    public List<StudentBean> getAllStudentDetailsByYear(Integer year) {
        List<StudentBean> resultRet = new ArrayList<>();
        try {
            List<StudentEntity> listEntity = studentDAO.getAllStudentDetailsByYear(year);
            for (StudentEntity studentEntity : listEntity) {
                StudentBean bean = convertEntityToBean(studentEntity);
                resultRet.add(bean);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return resultRet;
    }

    @Transactional
    public List<StudentEntity> insertStudentDetails(String name, String branch, Integer year) {
        List<StudentEntity> resultSet = new ArrayList<>();
        try {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setStudent_name(name);
            studentEntity.setStudent_branch(branch);
            studentEntity.setYear_of_joining(year);
            
            studentDAO.save(studentEntity);
            resultSet.add(studentEntity);
        } catch (Exception ex) {
            System.out.println("DAOWrapper insert method exception: " + ex);
        }
        return resultSet;
    }

    @Transactional
    public List<StudentEntity> deleteStudentsByName(String name) {
        List<StudentEntity> deletedEntities = new ArrayList<>();
        try {
            List<StudentEntity> entitiesToDelete = studentDAO.findByStudentName(name);
            for (StudentEntity entity : entitiesToDelete) {
                studentDAO.delete(entity);
                deletedEntities.add(entity);
            }
        } catch (Exception ex) {
            System.out.println("DAOWrapper Exception: " + ex);
        }
        return deletedEntities;
    }

    private StudentBean convertEntityToBean(StudentEntity studentEntity) {
        StudentBean studentBean = new StudentBean();
        BeanUtils.copyProperties(studentEntity, studentBean);
        return studentBean;
    }

    private StudentEntity convertBeanToEntity(StudentBean studentBean) {
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentBean, studentEntity);
        return studentEntity;
    }
}
