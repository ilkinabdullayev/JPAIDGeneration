/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpaidgeneration;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

/**
 *
 * @author ilkinabdullayev
 */
@Entity
@TableGenerator(name = "TABLE_GENERATOR",table = "ID_TABLE",pkColumnName = "ID_TABLE_NAME",pkColumnValue = "PERSON_ID",valueColumnName = "ID_TABLE_VALUE")
@SequenceGenerator(name = "PERSON_SEQ", sequenceName = "PERSON_SEQ", initialValue = 25, allocationSize = 75)
public class Person implements Serializable {

    @Id
    @GeneratedValue//auto automatically
   //  @GeneratedValue(strategy = GenerationType.AUTO)
   //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PERSON_SEQ")//if you're using mysql db,orm will create autoincrement id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@GeneratedValue(strategy = GenerationType.TABLE)//created SEQUENCE table
   // @GeneratedValue(strategy = GenerationType.TABLE,generator = "TABLE_GENERATOR")
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
