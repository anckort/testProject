package com.test.testProject.services;

import com.test.testProject.entities.Location;

public interface LocationService {
    Location getLocationById(Long id);
    void save(Location location);
}
