package com.test.testProject.services;

import com.test.testProject.entities.Location;
import com.test.testProject.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location getLocationById(Long id) {
        return locationRepository.getOne(id);
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location);
    }
}
