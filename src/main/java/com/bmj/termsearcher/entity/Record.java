package com.bmj.termsearcher.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String term;
    @Column
    private double hours;

    // Default constructor needed by Hibernate
    public Record() {}
    
    public Record(String term, double hours) {
        this.term = term;
        this.hours = hours;
    }

    public String getTerm() {
        return term;
    }

    public double getHours() {
        return hours;
    }
}
