package com.cg.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.bean.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
