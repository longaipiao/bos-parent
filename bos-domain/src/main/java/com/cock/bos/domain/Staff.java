package com.cock.bos.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 取派员
 */
public class Staff implements Serializable {

    // Fields
    private String id;
    private String name;
    private String telephone;
    private String haspda = "0";//是否有PDA，1：有 0：无
    private String deltag;
    private String station;
    private String standard;
    private Set decidedzones = new HashSet(0);

    public Staff() {
    }

    public Staff(String id) {
        this.id = id;
    }

    public Staff(String id, String name, String telephone,
                 String haspda, String deltag, String station,
                 String standard, Set decidedzones) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.haspda = haspda;
        this.deltag = deltag;
        this.station = station;
        this.standard = standard;
        this.decidedzones = decidedzones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHaspda() {
        return haspda;
    }

    public void setHaspda(String haspda) {
        this.haspda = haspda;
    }

    public String getDeltag() {
        return deltag;
    }

    public void setDeltag(String deltag) {
        this.deltag = deltag;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Set getDecidedzones() {
        return decidedzones;
    }

    public void setDecidedzones(Set decidedzones) {
        this.decidedzones = decidedzones;
    }
}
