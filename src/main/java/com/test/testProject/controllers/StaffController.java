package com.test.testProject.controllers;

import com.google.gson.Gson;
import com.test.testProject.entities.Location;
import com.test.testProject.entities.Staff;
import com.test.testProject.services.LocationService;
import com.test.testProject.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/setStaff", method = RequestMethod.POST, consumes="application/json")
    public @ResponseBody String setStaff(@RequestBody String requestStr){
        Map map = new Gson().fromJson(requestStr, Map.class);
        ArrayList<Map> list = (ArrayList <Map>) map.get("staff");
        for (Map staffMap: list){
            Map locationMap = (Map) staffMap.get("location");
            Location location = new Location((Double)locationMap.get("floor"),(Double)locationMap.get("room"));
            Staff staff = new Staff(staffMap.get("name").toString(),
                                    staffMap.get("gender").toString(),
                                    staffMap.get("position").toString(),
                                    staffMap.get("phone").toString(),
                                    location);
            locationService.save(location);
            staffService.save(staff);
        }
        return "ok";
    }


    @RequestMapping(value = "/getStaff", method = RequestMethod.GET)
    public @ResponseBody String getStaff(@RequestParam(name = "searchField") String searchField,
                                         @RequestParam(name = "value") String value,
                                         @RequestParam(name = "sortBy") String sortBy) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Staff.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        List<Staff> staffList;
        switch (searchField){
            case "name":
                staffList = staffService.getAllByName(value);
                sortList(staffList,sortBy);
                for (Staff staff: staffList){
                    marshaller.marshal(staff, stringWriter);
                }
                break;
            case "gender":
                staffList = staffService.getAllByGender(value);
                sortList(staffList,sortBy);
                for (Staff staff: staffList){
                    marshaller.marshal(staff, stringWriter);
                }
                break;
            case "position":
                staffList = staffService.getAllByPosition(value);
                sortList(staffList,sortBy);
                for (Staff staff: staffList){
                    marshaller.marshal(staff, stringWriter);
                }
                break;
            case "floor":
                staffList = staffService.getAllByLocation_Floor(Double.parseDouble(value));
                staffList = sortList(staffList,sortBy);
                for (Staff staff: staffList){
                    marshaller.marshal(staff, stringWriter);
                }
                break;
            case "":
                staffList = staffService.findAll();
                sortList(staffList,sortBy);
                for (Staff staff: staffList){
                    marshaller.marshal(staff, stringWriter);
                }
                break;
                default:
                    stringWriter.append("Invalid serach fild");
                    break;
        }
        return stringWriter.toString();
    }
    private List<Staff> sortList(List <Staff> staffList, String sortBy){
        if (!sortBy.trim().isEmpty()){
            switch (sortBy){
                case "name":
                    staffList.sort(Comparator.comparing(Staff::getName));
                    break;
                case "gender":
                    staffList.sort(Comparator.comparing(Staff::getGender));
                    break;
                case "position":
                    staffList.sort(Comparator.comparing(Staff::getPosition));
                    break;
                case "phone":
                    staffList.sort(Comparator.comparing(Staff::getPhone));
                    break;
            }
        }
        return staffList;
    }
}

