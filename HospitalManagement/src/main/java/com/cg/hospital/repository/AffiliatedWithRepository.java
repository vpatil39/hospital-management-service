package com.cg.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.bean.AffiliatedWith;
import com.cg.hospital.bean.AffiliatedWithPK;

public interface AffiliatedWithRepository extends JpaRepository<AffiliatedWith, AffiliatedWithPK> {

}
