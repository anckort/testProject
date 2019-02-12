package com.test.testProject.services;

import com.test.testProject.entities.Staff;
import com.test.testProject.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    StaffRepository staffRepository;

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public List<Staff> getAllByName(String name) {
        return staffRepository.getAllByName(name);
    }

    @Override
    public List <Staff> getAllByGender(String gender) {
        return staffRepository.getAllByGender(gender);
    }

    @Override
    public List <Staff> getAllByPosition(String position) {
        return staffRepository.getAllByPosition(position);
    }

    @Override
    public List <Staff> getAllByLocation_Floor(Double floor) {
        return staffRepository.getAllByLocation_Floor(floor);
    }

    @Override
    public List <Staff> findAll() {
        return staffRepository.findAll();
    }

}
