/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upraxis.msinaction.web.domain;

import java.io.Serializable;
import java.util.UUID;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 *
 * @author jesse
 */
@Table("users")
@SolrDocument(solrCoreName = "users")
public class Users implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @PrimaryKey
    @Id
    @Field
    private UUID id;
    
    @Field
    private String firstName;
    
    @Field
    private String middleName;
    
    @Field
    private String lastName;

    public Users() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + this.id + ", firstName=" + this.firstName + ", middleName=" + this.middleName + ", lastName=" + this.lastName + '}';
    }
    
}
