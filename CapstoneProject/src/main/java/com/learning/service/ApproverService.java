package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.entity.Staff;
import com.learning.repo.CustomerRepo;
import com.learning.repo.StaffRepo;

@Service
public class ApproverService {

	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	StaffRepo staffRepo;

	public Staff createStaff(@RequestBody Staff staff) {
		Staff s = new Staff();
		s.setStaffId(staff.getStaffId());
		s.setStaffFullName(staff.getStaffFullName());
		s.setStaffUserName(staff.getStaffUserName());
		s.setStaffPassword(staff.getStaffPassword());
		return staffRepo.save(staff);

	}

	public List<Staff> getAllStaff() {
		return staffRepo.findAll();

	}

	public Staff getstaffByid(Long staffId) {
		return staffRepo.findById(staffId).get();
	}

	public void saveStaff(Staff staff) {

		staffRepo.save(staff);
	}

}
