package com.example.releaselearning.repository;

import com.example.releaselearning.entity.ClassTbl;
import com.example.releaselearning.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ClassRepository extends JpaRepository<ClassTbl, String>, JpaSpecificationExecutor<ClassTbl> {
    List<ClassTbl> findByTeacherId(String teacherId);
}
