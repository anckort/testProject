package com.test.testProject.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Table(name = "locations")
@XmlRootElement(name = "location")
@XmlType(propOrder = {"floor","room"})
public class Location {

    @Id
    @Column(name = "locations_id")
    @SequenceGenerator(name = "locations_seq", sequenceName = "locations_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locations_seq")
    private Long id;

    @Column(name = "floor")
    private Double floor;

    @Column(name = "room")
    private Double room;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "location")
    private List<Staff> staffList;

    public Location() {
    }

    public Location(Double floor, Double room) {
        this.floor = floor;
        this.room = room;
    }

    @XmlTransient
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @XmlElement(name = "floor")
    public Double getFloor() {
        return floor;
    }

    public void setFloor(Double floor) {
        this.floor = floor;
    }
    @XmlElement(name = "room")
    public Double getRoom() {
        return room;
    }

    public void setRoom(Double room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", floor=" + floor +
                ", room=" + room +
                '}';
    }
}
