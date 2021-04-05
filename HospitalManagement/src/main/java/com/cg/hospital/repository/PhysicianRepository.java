package com.cg.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.bean.Physician;

public interface PhysicianRepository extends JpaRepository<Physician, Integer> {

}
