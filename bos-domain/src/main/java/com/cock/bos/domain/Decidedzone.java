package com.cock.bos.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 定区
 */
public class Decidedzone implements Serializable {
    // Fields
    private String id;
    private Staff staff;
    private String name;
    private Set subareas = new HashSet(0);

    public Decidedzone() {
    }

    public Decidedzone(String id) {
        this.id = id;
    }

    public Decidedzone(String id, Staff staff, String name, Set subareas) {
        this.id = id;
        this.staff = staff;
        this.name = name;
        this.subareas = subareas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getSubareas() {
        return subareas;
    }

    public void setSubareas(Set subareas) {
        this.subareas = subareas;
    }
}
