package com.cg.hospital.test.serviceImpl;

import static org.mockito.BDDMockito.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.hospital.bean.AffiliatedWith;
import com.cg.hospital.bean.AffiliatedWithPK;
import com.cg.hospital.bean.Department;
import com.cg.hospital.bean.PhysiNameWithDeptName;
import com.cg.hospital.bean.Physician;
import com.cg.hospital.repository.PhysicianRepository;
import com.cg.hospital.serviceImpl.PhysicianServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class PhysicianServiceImplTest {

	@InjectMocks 
	private PhysicianServiceImpl undertest;
	
	@Mock
	private PhysicianRepository repo;

	
	@Test
	public void should_return_physician_name_With_dept_name() {
	
		List<String> lname =new ArrayList<String>();
		lname.add("Nose");
		lname.add("ear");
		List<Physician> phy = dummyPhysicianData();
		given(repo.findAll())
		  .willReturn(phy);
		
		List<PhysiNameWithDeptName> result
		= undertest.findAllPhysicianWithDepartmentName();
		assertNotNull(result);
		assertEquals(lname, result.get(0).getDeptName());
}


	private List<Physician> dummyPhysicianData() {
		List<Physician> phy = new ArrayList<Physician>();
		
		Physician p1 = dummyPhy(1,"vishal","Surg",1);
		Physician p2 = dummyPhy(2,"abc","gen",3);
		Physician p3 = dummyPhy(3,"bvc","Surg",4);
		Physician p4 = dummyPhy(4,"ade","gen",2);
		Physician p5 = dummyPhy(5,"qwer","Surg",5);
		phy.add(p1);phy.add(p2);phy.add(p3);phy.add(p4);phy.add(p5);
		return phy ;
	}


	private Physician dummyPhy(int i, String string, String string2, int j) {
		Physician physician = new Physician();
		physician.setEmployeeID(i);
		physician.setName(string);
		physician.setPosition(string2);
		physician.setSsn(j);
		List<Department> departments = new ArrayList<Department>();
		Department dpt = new Department();
		dpt.setDepartmentID(1);
		dpt.setName("Nose");
		Department dpt2 = new Department();
		dpt2.setDepartmentID(2);
		dpt2.setName("ear");
		departments.add(dpt);
		departments.add(dpt2);
		physician.setDepartments(departments );
		List<AffiliatedWith> listaffiliatedWiths = new ArrayList<AffiliatedWith>();
		AffiliatedWith affiliatedWith = new AffiliatedWith();
		AffiliatedWithPK id = new AffiliatedWithPK();
		id.setPhysician(1);
		affiliatedWith.setId(id);
		byte primaryAffiliation= 0;
		affiliatedWith.setPrimaryAffiliation(primaryAffiliation);
		AffiliatedWith affiliatedWith1 = new AffiliatedWith();
		AffiliatedWithPK id1 = new AffiliatedWithPK();
		id1.setPhysician(1);
		affiliatedWith1.setId(id);
		byte primaryAffiliation1= 1;
		affiliatedWith1.setPrimaryAffiliation(primaryAffiliation1);
		listaffiliatedWiths.add(affiliatedWith);
		listaffiliatedWiths.add(affiliatedWith1);

		return physician;
	}


	private List<Department> dummyDept() {
		
		List<Department> listdept= new ArrayList<Department>();
		Department dept = new Department();
		List<AffiliatedWith> affiliatedWiths =dummyValueAffilatedWith();
		dept.setAffiliatedWiths(affiliatedWiths );
		// TODO Auto-generated method stub
		return null;
	}


	private List<AffiliatedWith> dummyValueAffilatedWith() {
		
		
		// TODO Auto-generated method stub
		return null;
	}	
	
}
