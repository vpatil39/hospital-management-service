package com.cg.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.bean.Block;
import com.cg.hospital.bean.BlockPK;

public interface BlockRepository extends JpaRepository<Block, BlockPK> {

}
