package com.test.testProject.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


@Entity
@Table(name = "staff")
@XmlRootElement
@XmlType(propOrder = {"name","gender","position","phone","location"})
@XmlSeeAlso(value = {Location.class})
public class Staff {

    @Id
    @Column(name = "staff_id")
    @SequenceGenerator(name = "staff_seq", sequenceName = "staff_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "position")
    private String position;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locations_id")
    private Location location;

    public Staff() {
    }

    public Staff(String name, String gender, String position, String phone, Location location) {
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.phone = phone;
        this.location = location;
    }
    @XmlTransient
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    @XmlElement(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    @XmlElement(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @XmlElement(name = "location")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
