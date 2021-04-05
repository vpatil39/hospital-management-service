package com.cg.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.bean.TrainedIn;
import com.cg.hospital.bean.TrainedInPK;

public interface TrainedInRepository extends JpaRepository<TrainedIn, TrainedInPK> {

}
