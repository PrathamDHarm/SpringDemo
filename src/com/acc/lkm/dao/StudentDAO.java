package com.acc.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.acc.lkm.entity.StudentEntity;


@SuppressWarnings("rawtypes")

@RepositoryDefinition(idClass = Integer.class, domainClass = StudentEntity.class)
@Transactional(value = "txManager")

public interface StudentDAO extends CrudRepository<StudentEntity, Integer> {
    @Query("select k from StudentEntity k where k.year_of_joining >= :year")
    List<StudentEntity> getAllStudentDetailsByYear(@Param("year") Integer year);

    @Query("select k from StudentEntity k where k.student_name = :name")
    List<StudentEntity> findByStudentName(@Param("name") String name);

    @Modifying
    @Query("delete from StudentEntity k where k.student_name = :name")
    void deleteStudentsByName(@Param("name") String name);
}
