package com.test.testProject.repositories;

import com.test.testProject.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff,Long> {
    List<Staff> getAllByName(String name);
    List<Staff> getAllByGender(String gender);
    List<Staff> getAllByPosition (String position);
    List<Staff> getAllByLocation_Floor (Double floor);
    List<Staff> findAll();
}
