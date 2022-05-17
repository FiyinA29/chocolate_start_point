package com.bnta.chocolate.models;

import javax.persistence.*;
@Entity //To let hibernate know that we want to map a database.
@Table(name = "chocolates") //To specify the table name/ can also include ' schema = " " ' to help distinguish one set of tables from another
public class Chocolate {
    @Id //Defines a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Identity is a type of identifier for the primary key.
    @Column //Used to map an object's property to a column in a table
    private Long id;
    @Column
    private String name;
    @Column
    private int cocoaPercentage;
    @ManyToOne //Many instances of the chocolate entity mapped to one instance of the estate entity (many chocolates in one estate).
    @JoinColumn(name = "estate_id", nullable = false) //Creates a foreign key that cannot be empty in the table.
    private Estate estate;

    public Chocolate(String name, int cocoaPercentage, Estate estate) {
        this.name = name;
        this.cocoaPercentage = cocoaPercentage;
        this.estate = estate;
    }
    public Chocolate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCocoaPercentage() {
        return cocoaPercentage;
    }

    public void setCocoaPercentage(int cocoaPercentage) {
        this.cocoaPercentage = cocoaPercentage;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }
}
