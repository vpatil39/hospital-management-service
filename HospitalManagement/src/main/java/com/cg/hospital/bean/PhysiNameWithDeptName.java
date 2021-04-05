package com.cg.hospital.bean;

import java.util.List;

public class PhysiNameWithDeptName {

	private String physicianName;

	private String physicianPosition;

	private List <String> deptName;

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public String getPhysicianPosition() {
		return physicianPosition;
	}

	public void setPhysicianPosition(String physicianPosition) {
		this.physicianPosition = physicianPosition;
	}

	public List<String> getDeptName() {
		return deptName;
	}

	public void setDeptName(List<String> deptName) {
		this.deptName = deptName;
	}
}
