package com.test.testProject.services;

import com.test.testProject.entities.Staff;

import java.util.List;

public interface StaffService{
    void save(Staff staff);
    List<Staff> getAllByName(String name);
    List<Staff> getAllByGender(String gender);
    List<Staff> getAllByPosition (String position);
    List<Staff> getAllByLocation_Floor (Double floor);
    List<Staff> findAll();
}
